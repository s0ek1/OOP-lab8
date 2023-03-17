package io;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import product.Product;
import product.ProductsMap;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IOProcessor implements IO {

    @Override
    public void writeToJSON(ProductsMap products, String fileName) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        try {
            List<Product> product = products.getProducts();
            objectMapper.writeValue(new File(fileName), product);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public Map<Integer, Product> readFromJSON(String fileName) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        try {
            List<Product> products = objectMapper.readValue(new File(fileName), new TypeReference<List<Product>>() {});
            Map<Integer, Product> productMap = new HashMap<>();
            for (Product product : products) productMap.put(product.getId(), product);
            return productMap;
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found!");
        } catch (IOException e) {
            System.out.println("File Read ERROR!");
        }
        return null;
    }

}