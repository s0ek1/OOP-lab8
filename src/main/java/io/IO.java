package io;
import product.Product;
import product.ProductsMap;

import java.util.Map;

public interface IO {
    void writeToJSON(ProductsMap products, String fileName);
    Map<Integer, Product> readFromJSON(String fileName);
    }
