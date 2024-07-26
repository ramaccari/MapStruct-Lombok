package com.cazadordigital.mapstructlombokdemo.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cazadordigital.mapstructlombokdemo.dto.GetCategory;
import com.cazadordigital.mapstructlombokdemo.dto.GetProduct;
import com.cazadordigital.mapstructlombokdemo.entity.Category;
import com.cazadordigital.mapstructlombokdemo.entity.Product;
import com.cazadordigital.mapstructlombokdemo.mapper.CategoryMapper;
import com.cazadordigital.mapstructlombokdemo.mapper.ProductMapper;
import com.cazadordigital.mapstructlombokdemo.repository.CategoryRepository;
import com.cazadordigital.mapstructlombokdemo.repository.ProductRepository;

@Configuration
public class InitDatabase {

    @Autowired
    private ProductRepository productRepository;
    
    @Autowired
    private CategoryRepository categoryRepository;

    private ProductMapper productMapper = ProductMapper.INSTANCE;
    
    private CategoryMapper categoryMapper = CategoryMapper.INSTANCE;

    @Bean
    CommandLineRunner testProductMapperCommand(){

        return args -> {

            List<Product> products = productRepository.findAll();

            System.out.println("PRODUCTS");
            products.forEach(System.out::println);

            System.out.println("GET PRODUCTS");
            List<GetProduct> getProductList = productMapper.toDtoList(products);
            getProductList.forEach(System.out::println);

            System.out.println("MAPPED PRODUCTS");
            List<Product> mappedProducts = productMapper.toEntityList(getProductList);
            mappedProducts.forEach(System.out::println);

        };
    }

    @Bean
    CommandLineRunner testCategoriaMapperCommand() {

        return args -> {

            List<Category> categories = categoryRepository.findAll();

            System.out.println("CATEGORIES");
            categories.forEach(System.out::println);

            System.out.println("GET CATEGORIES");
            List<GetCategory> getCategoryList = categoryMapper.toDtoList(categories);
            getCategoryList.forEach(System.out::println);

            System.out.println("MAPPED CATEGORIES");
            List<Category> mappedCategories = categoryMapper.toEntityList(getCategoryList);
            mappedCategories.forEach(System.out::println);

        };
    }

}
