package ui;
import product.Product;
import product.ProductsMap;
import java.time.LocalDate;
import java.util.*;
public class UIProducts implements UI {
    @Override
    public void fillProductMap(ProductsMap products) {
        products.addProduct(new Product("Шампунь", "Nivea", 111.50, LocalDate.of(2023, 2, 20), 45));
        products.addProduct(new Product("Шоколад", "Roshen", 38.75, LocalDate.of(2023, 2, 15), 100));
        products.addProduct(new Product("Кава", "Nescafe", 427.60, LocalDate.of(2024, 6, 7), 37));
        products.addProduct(new Product("Медовик", "Roshen", 28.90, LocalDate.of(2024, 8, 8), 12));
        products.addProduct(new Product("Горілка", "Гетьман", 147.60, LocalDate.of(2023, 2, 3), 19));
        products.addProduct(new Product("Масло", "Ферма", 46.50, LocalDate.of(2033, 9, 30), 23));
        products.addProduct(new Product("Кава", "Nescafe", 4.90, LocalDate.of(2025, 8, 19), 65));
        products.addProduct(new Product("Цукерки", "Roshen", 19.90, LocalDate.of(2024, 3, 31), 81));
        products.addProduct(new Product("Круасан", "Ligos", 30.80, LocalDate.of(2023, 2, 3), 60));
        products.addProduct(new Product("Молоко", "Ферма", 33.40, LocalDate.of(2022, 12, 31), 43));
    }
    @Override
    public void showProductsMap(ProductsMap tempProducts) {
        List<Product> products = tempProducts.getProducts();
        for (Product product : products) System.out.println(product);
    }
    @Override
    public void addProductMap(Scanner scanner, ProductsMap products) {
        System.out.print("Введіть назву: ");
        scanner.nextLine();
        String name = scanner.nextLine();
        System.out.print("Введіть виробника: ");
        String manufacturer = scanner.nextLine();
        System.out.print("Введіть вартісь: ");
        double cost = scanner.nextDouble();
        System.out.print("Введіт год, місяць, і день терміну: ");
        int year = scanner.nextInt();
        int month = scanner.nextInt();
        int day = scanner.nextInt();
        System.out.print("Введіть кількість: ");
        int count = scanner.nextInt();
        products.addProduct(new Product(name, manufacturer, cost, LocalDate.of(year, month, day), count));
    }
    @Override
    public void removeProductMap(Scanner scanner, ProductsMap products) {
        System.out.print("Введіть ідентифікатор продукту: ");
        int id = scanner.nextInt();
        products.removeProductById(id);
        System.out.println("Продукт був видалений.");
    }
    @Override
    public void showProductMapWithCost(Scanner scanner, ProductsMap products) {
        scanner.nextLine();
        System.out.print("Ведіть назву продукта: ");
        String name = scanner.nextLine();
        System.out.print("Ведіть вартісь продукта: ");
        Double cost = scanner.nextDouble();
        products.showByCost(name,cost);
    }
    @Override
    public void showProductMapWithTerm(Scanner scanner, ProductsMap products) {
        System.out.print("Введіт год, місяць, і день терміну: ");
        int year = scanner.nextInt();
        int month = scanner.nextInt();
        int day = scanner.nextInt();
        LocalDate date = LocalDate.of(year, month, day);
        products.showByTerm(date);
    }
    @Override
    public void showProductMapWithSortCost(ProductsMap products) {
        List<Product> productList = new ArrayList<>(products.getProducts());
        productList.sort(Comparator.comparing(Product::getCost));
        for (Product product : productList) System.out.println(product);
    }
    @Override
    public void showProductMapWithSortTerm(ProductsMap products) {
        List<Product> productList = new ArrayList<>(products.getProducts());
        productList.sort(Comparator.comparing(Product::getTerm).reversed());
        for (Product product : productList) System.out.println(product);
    }
    @Override
    public void showManufacturesProducts(ProductsMap products) {
        for (Map.Entry<String, List<Product>> entry : getStringListMap(products).entrySet())  {
            System.out.print(entry.getKey() + ", ");
        }
        System.out.println();
    }
    @Override
    public void showProductsByManufacturer(ProductsMap products) {
        Map<String, List<Product>> productsByManufacturer = getStringListMap(products);
        products.showByManufacturer(productsByManufacturer);
    }
    private static Map<String, List<Product>> getStringListMap(ProductsMap products) {
        Map<String, List<Product>> productsByManufacturer = new HashMap<>();
        for (Product product : products.getProducts()) {
            String manufacturer = product.getManufacturer();
            if (!productsByManufacturer.containsKey(manufacturer)) {
                productsByManufacturer.put(manufacturer, new ArrayList<>());
            }
            productsByManufacturer.get(manufacturer).add(product);
        }
        return productsByManufacturer;
    }
}