import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@FunctionalInterface
interface getProducts {
    int filter();
}


public class Functional_Programming {

    static private List<Product> products = new ArrayList<>();

    static {
        products.add(new Product(321434, "item-1", 500.00));
        products.add(new Product(421431, "item-2", 3000.00));
        products.add(new Product(221433, "item-3", 7000.00));
        products.add(new Product(621437, "item-4", 1000.00));
        products.add(new Product(821436, "item-5", 5000.00));

    }

    // ------------------------------------------------------
    // Declarative style ==> What : using Local Named Inner class
    // ------------------------------------------------------
    private static List<Product> getProducts1(double price) {
        class ByPrice implements Predicate<Product> {
            @Override
            public boolean test(Product t) {
                return t.getPrice() == price;
            }
        }
        Predicate<Product> byPrice1 = new ByPrice();
        return Lib.filter(products, byPrice1);
    }

    private static List<Product> getProducts1(double min, double max) {
        class ByPrice implements Predicate<Product> {
            @Override
            public boolean test(Product t) {
                return t.getPrice() > min && t.getPrice() < max;
            }
        }
        Predicate<Product> byPrice1 = new ByPrice();
        return Lib.filter(products, byPrice1);
    }

    // ------------------------------------------------------
    // Declarative style ==> What : using AnonymousLocal Named Inner class
    // ------------------------------------------------------
    private static List<Product> getProducts2(double price) {
        Predicate byPrice2 = new Predicate<Product>() {
            @Override
            public boolean test(Product t) {
                return t.getPrice() == price;
            }
        };
        return Lib.filter(products, byPrice2);
    }

    private static List<Product> getProducts2(double min, double max) {
        Predicate byPrice2 = new Predicate<Product>() {
            @Override
            public boolean test(Product t) {
                return t.getPrice() > min && t.getPrice() < max;
            }
        };
        return Lib.filter(products, byPrice2);
    }


    // ------------------------------------------------------
    // Declarative style ==> What : using function
    // ------------------------------------------------------

    private static List<Product> getProducts(double price) {
        return Lib.filter(products, t -> t.getPrice() == price);
    }

    private static List<Product> getProducts(double min, double max) {
        return Lib.filter(products, t -> t.getPrice() >= min && t.getPrice() <= max);
    }


    public static void display(List<Product> products) {
        for (Product product : products) {
            System.out.println(product);
        }
    }

    public static Predicate<Integer> and(Predicate<Integer> p1, Predicate<Integer> p2) {
        return i -> p1.test(i) && p2.test(i);
    }

    public static void main(String[] args) {
        List<Product> products;
        // ---------------------------------------------------
        products = getProducts1(1000.00);
        products = getProducts1(1000.00, 3000.00);
        display(products);
        // -----------------------------------------------------
        // ---------------------------------------------------
        products = getProducts2(1000.00);
        products = getProducts2(1000.00, 3000.00);
        display(products);
        // -----------------------------------------------------
        // ---------------------------------------------------
        products = getProducts(1000.00);
        products = getProducts(1000.00, 3000.00);
        display(products);
        // -----------------------------------------------------

        Predicate<Integer> p1 = i -> i > 50;
        Predicate<Integer> p2 = i -> i < 100;

        Predicate<Integer> pred = and(p1, p2);

        boolean res = pred.test(10000);
        System.out.println(res);
    }
}
