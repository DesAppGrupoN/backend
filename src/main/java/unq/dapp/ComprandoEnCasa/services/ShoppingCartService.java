package unq.dapp.ComprandoEnCasa.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import unq.dapp.ComprandoEnCasa.model.domain.*;
import unq.dapp.ComprandoEnCasa.model.domain.commerce.Commerce;
import unq.dapp.ComprandoEnCasa.model.domain.commerce.PayMethods;
import unq.dapp.ComprandoEnCasa.model.domain.shipment.Delivery;
import unq.dapp.ComprandoEnCasa.model.domain.shipment.OnSite;
import unq.dapp.ComprandoEnCasa.model.domain.shipment.ShipmentType;
import unq.dapp.ComprandoEnCasa.model.domain.shipment.ShipmentTypeEnum;
import unq.dapp.ComprandoEnCasa.model.dtos.ProductShoppingCartDTO;
import unq.dapp.ComprandoEnCasa.model.dtos.PurchaseDTO;
import unq.dapp.ComprandoEnCasa.model.dtos.ShoppingCartDTO;
import unq.dapp.ComprandoEnCasa.model.dtos.TurnDTO;
import unq.dapp.ComprandoEnCasa.model.exceptions.UserNotFoundException;
import unq.dapp.ComprandoEnCasa.persistence.commerce.CommerceRepository;
import unq.dapp.ComprandoEnCasa.persistence.commerce.ProductRepository;
import unq.dapp.ComprandoEnCasa.persistence.commerce.ShoppingCartRepository;
import unq.dapp.ComprandoEnCasa.persistence.commerce.UserRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
public class ShoppingCartService {

    @Autowired
    private ShoppingCartRepository repository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CommerceRepository commerceRepository;

    @Autowired
    private EmailService emailService;

    public List<ShoppingCart> findAll() { return repository.findAll(); }

    public Optional<ShoppingCart> findById(int id) { return repository.findById(id); }

    public void save(ShoppingCart shoppingCart) {
        this.repository.save(shoppingCart);
    }

    public void addProduct(ProductShoppingCartDTO productShoppingCartDTO) {
        Optional<User> user = userRepository.findByEmail(productShoppingCartDTO.getUserEmail());
        Optional<Product> product = productRepository.findById(productShoppingCartDTO.getIdProduct());
        if (user.isPresent() && product.isPresent()){
            ShoppingCart shoppingCart = user.get().getShoppingCart();
            shoppingCart.addItem(product.get());
            userRepository.save(user.get());
        }
    }

    public void removeProduct(ProductShoppingCartDTO productShoppingCartDTO) {
        Optional<User> user = userRepository.findByEmail(productShoppingCartDTO.getUserEmail());
        Optional<Product> product = productRepository.findById(productShoppingCartDTO.getIdProduct());
        if (user.isPresent() && product.isPresent()){
            ShoppingCart shoppingCart = user.get().getShoppingCart();
            shoppingCart.removeItem(product.get());
            userRepository.save(user.get());
        }
    }

    public ShoppingCart getUserShoppingCart(String userEmail) {
        Optional<User> user = userRepository.findByEmail(userEmail);
        if(user.isPresent()) {
            ShoppingCart shoppingCart = user.get().getShoppingCart();
            return shoppingCart;
        }
        else {
            return new ShoppingCart();
        }
    }

    public void changeProductQuantity(ProductShoppingCartDTO productShoppingCartDTO) {
        Optional<User> user = userRepository.findByEmail(productShoppingCartDTO.getUserEmail());
        Optional<Product> product = productRepository.findById(productShoppingCartDTO.getIdProduct());
        if (user.isPresent() && product.isPresent()){
            ShoppingCart shoppingCart = user.get().getShoppingCart();
            shoppingCart.changeQuantity(product.get(), productShoppingCartDTO.getQuantity());
            userRepository.save(user.get());
        }
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }

    public List<Commerce> getCommercesInUserShoppingCart(String userEmail) {
        Optional<User> user = userRepository.findByEmail(userEmail);
        if(user.isPresent()) {
            List<Integer> commerceIds = user.get().getShoppingCart().getCommercesId();
            return commerceIds.stream().map(id -> commerceRepository.findById(id).get()).collect(Collectors.toList());
        }
        else {
            return new ArrayList<>();
        }

    }

    public List<PayMethods> getAvailablePaymethods(String userEmail) {
        List<List<PayMethods>> allPayMethods = this.getCommercesInUserShoppingCart(userEmail).stream().map(Commerce::getPayMethods).collect(Collectors.toList());
        List<PayMethods> payMethods = Arrays.stream(PayMethods.values()).collect(Collectors.toList());

        if(allPayMethods.size() == 0) {
            return new ArrayList<>();
        }

        for(List<PayMethods> list : allPayMethods) {
            for(PayMethods p : PayMethods.values()) {
                if(!list.contains(p)) {
                    payMethods.remove(p);
                }
            }
        }

        return payMethods.stream().collect(Collectors.toList());
    }

    public List<LocalTime> getCommercesTurns(Integer commerceId) {
        Optional<Commerce> commerce = this.commerceRepository.findById(commerceId);
        if(commerce.isPresent()) {
            return commerce.get().getAttentionSchedule().getTurnsForDay();
        }
        else {
            return new ArrayList<>();
        }
    }

    public void confirmPurchase(PurchaseDTO purchaseDTO) {

        User userBuyer = userRepository.findByEmail(purchaseDTO.getUserEmail()).orElseThrow(UserNotFoundException::new);
        List<Commerce> commercesInShoppingCart = this.getCommercesInUserShoppingCart(purchaseDTO.getUserEmail());
        ShoppingCart shoppingCart = userBuyer.getShoppingCart();
        List<ShoppingCartDTO> shoppingCartForCommerce = this.generateShoppingCartForCommerce(commercesInShoppingCart, shoppingCart);
        List<PurchaseOrder> purchaseOrders = this.generatePurchaseOrders(shoppingCartForCommerce, purchaseDTO);

        this.validateShoppingCart(userBuyer);

        purchaseOrders.forEach(userBuyer::addToPurchaseHistory);

        // Enviar mails

        for(Commerce commerce : commercesInShoppingCart) {
            TurnDTO turn = purchaseDTO.getTurns().stream().filter(it -> it.getCommerceId().equals(commerce.getId())).findFirst().get();

            String to = commerce.getUserEmail();
            String buyer = userBuyer.getEmail();
            List<String> productNames = shoppingCart.getCart().stream().filter(it -> it.getProduct().getCommerceId().equals(commerce.getId())).map(CartElement::getProduct).map(Product::getName).collect(Collectors.toList());

            ShipmentTypeEnum shipmentType = turn.getShipment();
            String shipmentTurn = "";

            if(shipmentType.equals(ShipmentTypeEnum.ON_SITE)) {
                shipmentTurn = "Tipo de envio: retiro en local el dia " + turn.getDay().toString() + " a las " + turn.getTime();
            }
            else {
                shipmentTurn = "Tipo de envio: envio a domicilio";
            }

            String subject = "Alguien compro tus productos";
            String message = "Comprador: " + buyer + "\n" + "Productos: " + productNames + "\n" + shipmentTurn;

            try {
                this.emailService.sendNotificaitoin(to, subject, message);
            }
            catch (Exception e) { }
        }

        shoppingCart.emptyCart();
        this.userRepository.save(userBuyer);

    }


    private void validateShoppingCart(User user) {
        ShoppingCart shoppingCart = user.getShoppingCart();
        for(CartElement cartElement : shoppingCart.getCart()) {
            if(cartElement.isValid()) {
                Product product = cartElement.getProduct();
                product.setStock(product.getStock() - cartElement.getQuantity());
                this.productRepository.save(product);
            }
        }
    }

    private List<PurchaseOrder> generatePurchaseOrders(List<ShoppingCartDTO> shoppingCartForCommerce, PurchaseDTO purchaseDTO) {
        List<PurchaseOrder> purchaseOrders = new ArrayList<>();
        for(ShoppingCartDTO shoppingCartDTO : shoppingCartForCommerce) {
            PurchaseOrder purchaseOrder = new PurchaseOrder();
            purchaseOrder.setShoppingCart(shoppingCartDTO.getShoppingCart());
            purchaseOrder.setDate(LocalDate.now());
            purchaseOrder.setCommerceId(shoppingCartDTO.getCommerceId());

            ShipmentTypeEnum shipmentType = purchaseDTO.getTurns().stream().filter(t -> t.getCommerceId().equals(shoppingCartDTO.getCommerceId())).findFirst().get().getShipment();
            purchaseOrder.setShipmentType(shipmentType);

            purchaseOrders.add(purchaseOrder);
        }

        return purchaseOrders;
    }


    private List<ShoppingCartDTO> generateShoppingCartForCommerce(List<Commerce> commerces, ShoppingCart shoppingCart) {
        List<ShoppingCartDTO> shoppingCartDTOList = new ArrayList<>();

        for(Commerce commerce : commerces) {
            List<Product> products = shoppingCart.getCart().stream().map(CartElement::getProduct).collect(Collectors.toList());
            ShoppingCartDTO shoppingCartDTO = new ShoppingCartDTO();
            shoppingCartDTO.addAllProducts(products);
            shoppingCartDTOList.add(shoppingCartDTO);
            shoppingCartDTO.setCommerceId(commerce.getId());
        }

        return shoppingCartDTOList;
    }
}
