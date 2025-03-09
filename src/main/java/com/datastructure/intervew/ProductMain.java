package com.datastructure.intervew;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ProductMain {
    public static void main(String[] args) {
        List<Product> productsList = new ArrayList<>();
        Optional<Product> highestPaidEmployeeWrapper=
                productsList.stream().collect(Collectors.maxBy(Comparator.comparingDouble(Product::getPrice)));
        System.out.println(highestPaidEmployeeWrapper);
        Product highestPaidEmployee = highestPaidEmployeeWrapper.get();

    }


    public List<Product> addProduct(List<Product> productsList){
        productsList.add(new Product(1,"HP Laptop",25000f));
        productsList.add(new Product(2,"Dell Laptop",30000f));
        productsList.add(new Product(3,"Lenevo Laptop",28000f));
        productsList.add(new Product(4,"Sony Laptop",28000f));
        productsList.add(new Product(5,"Apple Laptop",90000f));
        return productsList;
    }


}

