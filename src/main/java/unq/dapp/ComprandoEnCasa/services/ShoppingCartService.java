package unq.dapp.ComprandoEnCasa.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import unq.dapp.ComprandoEnCasa.model.domain.Product;
import unq.dapp.ComprandoEnCasa.model.domain.ShoppingCart;
import unq.dapp.ComprandoEnCasa.model.domain.User;
import unq.dapp.ComprandoEnCasa.model.dtos.ProductShoppingCartDTO;
import unq.dapp.ComprandoEnCasa.persistence.commerce.ProductRepository;
import unq.dapp.ComprandoEnCasa.persistence.commerce.ShoppingCartRepository;
import unq.dapp.ComprandoEnCasa.persistence.commerce.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ShoppingCartService {

    @Autowired
    private ShoppingCartRepository repository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

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

}
