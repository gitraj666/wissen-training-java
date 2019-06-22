import java.util.ArrayList;


import java.util.Comparator;
import java.util.Objects;

class Products implements Comparable<Product> {

    private int id;
    private String name;
    private Double price;

    public int getId() {
        return id;
    }

    @Override
    public int compareTo(Product o) {
        return Double.compare(this.price, o.getPrice());
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public Products(int id, String name, Double price) {
        super();
        this.id = id;
        this.price = price;
        this.name = name;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Products products = (Products) o;
        return id == products.id &&
                Objects.equals(name, products.name) &&
                Objects.equals(price, products.price);
    }

    @Override
    public String toString() {
        return "Products{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

}

public class Java8_Features {

    public static void main(String[] args) {
        Products product1 = new Products(123795, "laptop", 100.0);
        Products product2 = new Products(133895, "mobile", 8100.0);
        Products product3 = new Products(213795, "ipad", 7100.0);
        Products product4 = new Products(123695, "tablet", 200.0);
        Products product5 = new Products(823795, "camera", 600.0);

        ArrayList<Products> products = new ArrayList<>();
        products.add(null);
        products.add(product1);
        products.add(product2);
        products.add(product3);
        products.add(product4);
        products.add(product5);


        Comparator<Products> byPrice = (p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice());
        Comparator<Products> byName = (p1, p2) -> p1.getName().compareTo(p2.getName());

        Comparator<Products> byPriceAndName = byPrice.thenComparing(byName);

        //products.forEach(item-> System.out.println(item));
        products.forEach(System.out::println);
    }
}
