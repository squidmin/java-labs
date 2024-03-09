package collections.arraylist;

import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class Product implements Comparable<Product> {

    private final String productId;
    private final double price;

    public Product(String productId, double price) {
        this.productId = productId;
        this.price = price;
    }

    @Override
    public int compareTo(Product product) {
        return this.productId.compareTo(product.productId);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Product product = (Product) obj;
        return Objects.equals(this.productId, product.productId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.productId, this.price);
    }

    public static void main(String[] args) {
        Product x = new Product("1234", 123.45);
        Product y = new Product("1234", 123.45);
        System.out.println((x.compareTo(y) == 0) == (x.equals(y)));

        TreeSet<Product> products = new TreeSet<>(Set.of(
            new Product("1234", 543.09),
            new Product("3456", 56.76),
            new Product("2136", 123.45),
            new Product("2136", 321.45)
        ));
        products.forEach(product -> System.out.println("Product ID: " + product.productId + "; Price: " + product.price));
    }

}
