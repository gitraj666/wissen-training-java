import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

class Query {
    public static <T> List<T> filter(List<T> products, Predicate<T> predicate) {
        List<T> out = new ArrayList<>();

        products.forEach(item -> {
            if (predicate.test(item)) {
                out.add(item);
            }
        });

        return out;
    }

    public static <T, R> List<R> map(List<T> products, Function<T, R> func) {
        List<R> out = new ArrayList<>();

        products.forEach(item -> {
            out.add(func.apply(item));
        });
        return out;
    }

    public static <T, R> List<R> forEach(List<T> products, Consumer<T> consumer) {
        List<R> out = new ArrayList<>();

        products.forEach(item -> {
            consumer.accept(item);
        });
        return out;
    }

}


public class Ex8 {
    // Develop a Stream Library
    public static void main(String[] args) {
        List<Products> products = Arrays.asList(
                new Products(1234521, "item-1", 7000.0),
                new Products(1234521, "item-2", 3000.0),
                new Products(1234521, "item-3", 6000.0),
                new Products(1234521, "item-4", 1000.0),
                new Products(1234521, "item-5", 1800.0),
                new Products(1234521, "item-6", 8900.0)
        );

        List<Products> res = Query.filter(products, item -> item.getPrice() > 3000);
        //List<Products> res2 = Query.map(res, item -> item.getName());
        Query.forEach(res, System.out::println);

        products
                .stream()
                .filter(i -> i.getPrice() > 3000)
                .map(i -> i.getName())
                .forEach(System.out::println);

        Stream.of(products).forEach(System.out::print);
    }
}
