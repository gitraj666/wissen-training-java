import java.util.function.Function;
import java.util.function.Predicate;

public class Ex7 {
    /*
    Functions are tightly coupled with login and log out solve that issue

     */
    public static void main(String[] args) {

        // Old Bad Method
//        Function<String, Integer> function1 = s -> {
//          System.out.println("before :: log");
//          int i = Integer.parseInt(s);
//          System.out.println("after::log");
//          return i
//        };
//
//        Function<Integer, String> function2 = i -> {
//            System.out.println("before :: log");
//            String s = String.valueOf(i);
//            System.out.println("after::log");
//            return s;
//        };

        Predicate<Integer> function3 = t -> t == 100;

        Function<String, Integer> function1 = s -> {
            int i = Integer.parseInt(s);
            return i;
        };

        Function<Integer, String> function2 = i -> {
            String s = String.valueOf(i);
            return s;
        };


        Function<Function<String, Integer>, Function<String, Integer>> logWrapper = (inputFn) -> {
            return s -> {
                System.out.println("::before log");
                int r = inputFn.apply(s);
                System.out.println(r);
                System.out.println("::after log");
                return r;
            };
        };

        Function<String, Integer> function1WithLog = logWrapper.apply(function1);
        //Function<String, Integer> function2WithLog = logWrapper.apply(function2);
        function1WithLog.apply("125");

        boolean res = function3.test(100);
        System.out.println(res);

    }
}
