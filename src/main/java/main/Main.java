package main;

import io.IO;
import io.IOProcessor;
import product.ProductsMap;
import ui.UI;
import ui.UIProducts;

import java.util.Scanner;

public class Main {
    public static final String fileNameJson = "productMap.json";
    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }
    private void run() {
        UI ui = new UIProducts();
        IO io = new IOProcessor();
        ProductsMap products = new ProductsMap();

        Scanner scanner = new Scanner(System.in);
        boolean status = true;
        menu();
        while (status) {
            int option = scanner.nextInt();
            switch (option) {
                case -1 -> menu();
                case 0 -> status = false;
                case 1 -> ui.fillProductMap(products);
                case 2 -> ui.showProductsMap(products);
                case 3 -> io.writeToJSON(products,fileNameJson);
                case 4 -> products.formatProductsMapList(io.readFromJSON(fileNameJson));
                case 5 -> ui.addProductMap(scanner,products);
                case 6 -> ui.removeProductMap(scanner,products);
                case 7 -> ui.showProductMapWithCost(scanner,products);
                case 8 -> ui.showProductMapWithTerm(scanner,products);
                case 9 -> ui.showProductMapWithSortCost(products);
                case 10-> ui.showProductMapWithSortTerm(products);
                case 11-> ui.showManufacturesProducts(products);
                case 12-> ui.showProductsByManufacturer(products);
            }
            System.out.print(":");
        }
    }
    private void menu() {
        System.out.print("""
                   ======================== ========================
                   Выберите пункт из меню:
                   [0] - Завершити програму.
                   [1] - Зчитування з коду.
                   [2] - Вивести весь список продуктів.
                   [3] - Зберігання даних у json файл.
                            [4] - Зчитування з json файлу.
                   [5] - Додати новий продукт.
                   [6] - Вилучити по ID.
                   [7] - Вивести список продуктів для заданого найменування, ціна яких не перевищує задану.
                   [8] - Вивести список товарів, термін зберігання яких більше заданого.
                   [9] - Вивести список продуктів впорядкованих за зростанням вартості.
                   [10] - Вивести список продуктів в порядку спадання терміну зберігання.
                   [11] - Вивести список виробників продуктів, зареєстрованих в програмі.
                   [12] - Вивести список продуктів для кожного виробника, які він виробляє.
                : """);
    }
}