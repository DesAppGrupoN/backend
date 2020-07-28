package unq.dapp.ComprandoEnCasa.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import unq.dapp.ComprandoEnCasa.model.builders.CommerceBuilder;
import unq.dapp.ComprandoEnCasa.model.builders.ProductBuilder;
import unq.dapp.ComprandoEnCasa.model.domain.Category;
import unq.dapp.ComprandoEnCasa.model.domain.Product;
import unq.dapp.ComprandoEnCasa.model.domain.User;
import unq.dapp.ComprandoEnCasa.model.domain.commerce.Commerce;
import unq.dapp.ComprandoEnCasa.model.dtos.ProductDTO;
import unq.dapp.ComprandoEnCasa.persistence.commerce.ProductRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    @Transactional
    public List<Product> findAll() { return repository.findAll(); }

    @Transactional
    public Optional<Product> findById(int id) { return repository.findById(id); }

    @Transactional
    public void save(ProductDTO productDTO) {
            Product product = ProductBuilder.aProduct()
                    .withName(productDTO.getName())
                    .withBrand(productDTO.getBrand())
                    .withCategory(productDTO.getCategory())
                    .withStock(productDTO.getStock())
                    .withImage(productDTO.getImage())
                    .withPrice(productDTO.getPrice())
                    .withId(productDTO.getId())
                    .withCommerceId(productDTO.getCommerceId())
                    .build();
            repository.save(product);
        }


    @Transactional
    public void deleteById(int id) {
        repository.deleteById(id);
    }

    @Transactional
    public List<Product> getAllByCommerceId(int id) {
        return repository.findByCommerceId(id);
    }

    public Category[] getCategories() {
        return Category.values();
    }

    public List<Product> searchByCommerceId(int commerceId) {
        List<Product> products = repository.findByCommerceId(commerceId);
        return products.stream().filter(it -> it.getStock() > 0).collect(Collectors.toList());
    }
}
