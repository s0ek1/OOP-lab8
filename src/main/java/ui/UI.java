package ui;

import product.ProductsMap;

import java.util.Scanner;

public interface UI {
    void fillProductMap(ProductsMap products);
    void showProductsMap(ProductsMap products);
    void addProductMap(Scanner scanner, ProductsMap products);
    void removeProductMap(Scanner scanner, ProductsMap products);
    void showProductMapWithCost(Scanner scanner, ProductsMap products);
    void showProductMapWithTerm(Scanner scanner, ProductsMap products);
    void showProductMapWithSortCost(ProductsMap products);
    void showProductMapWithSortTerm(ProductsMap products);
    void showManufacturesProducts(ProductsMap products);
    void showProductsByManufacturer(ProductsMap products);
}
