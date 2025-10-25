package com.elkabani.firstspringboot;

import com.elkabani.firstspringboot.entity.Category;
import com.elkabani.firstspringboot.repositories.CategoryRepository;
import com.elkabani.firstspringboot.entity.Product;

import com.elkabani.firstspringboot.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderService {
    private PaymentService paymentService;
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;


    @Transactional
    public void placeOrder(){
      //  var paymentService = new PaypalPaymentService();

        var category = Category.builder()
                .name("Electronics")
                .build();
        var product = Product.builder()
                .name("Camera")
                .price(50.0)
                .build();

        category.addProduct(product);
        categoryRepository.save(category);


        //paymentService.processPayment(100);
    }

    @Transactional
    public void addNewCategoryAndProduct(){
        var category = Category.builder()
                .name("Appliances")
                .build();
        var product = Product.builder()
                .name("Fridge")
                .price(100.0)
                .build();
        category.addProduct(product);
        categoryRepository.save(category);
    }

    @Transactional
    public void findAndNewOrder(int id){
        var category = categoryRepository.findById(id).get();

        var product = Product.builder()
                .name("Headphones")
                .price(50.0)
                .build();

        category.addProduct(product);
        productRepository.save(product);
    }

    public void deleteProduct(int id){

        productRepository.deleteById(id);

    }
}
