package product;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class ProductsMap {
    Map<Integer, Product> productMap = new HashMap<>();
    public ProductsMap() {}
    public List<Product> getProducts() { return new ArrayList<>(productMap.values()); }
    public void addProduct(Product product) { productMap.put(product.getId(), product); }
    public void removeProductById(int id) { productMap.remove(id); }
    public void showByManufacturer(Map<String, List<Product>> productsByManufacturer) {
        for (Map.Entry<String, List<Product>> entry : productsByManufacturer.entrySet()) {
            List<Product> manufacturerProducts = entry.getValue();
            System.out.println("Производитель: " + entry.getKey() + ": [" + manufacturerProducts.size() + "]");
            for (Product product : manufacturerProducts) {
                System.out.println("\t" + "\t[id|"+product.getId()+ "]\t`"+product.getName()+ '`' +
                        "  \tЦiна = "+product.getCost()+ "  \t`"+product.getTerm()+ '`' + "\tКількість = "+product.getCount());
            }
            System.out.println();
        }
    }
    public void showByTerm(LocalDate date) { for (Product pr : productMap.values()) if (pr.getTerm().isAfter(date)) System.out.println(pr); }

    public void showByCost(String name, Double cost) {
        for (Product pr : productMap.values()) if (pr.getName().equals(name)&&pr.getCost()<=cost) System.out.println(pr);
    }
    public void formatProductsMapList(Map<Integer,Product> tempProducts){ productMap = tempProducts; }
}