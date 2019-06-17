import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface MyAnnotation {
    int someValue();
}


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.LOCAL_VARIABLE)
@interface MyAnnotation2 {
    int someVar();
}


class Hello {
    @MyAnnotation(someValue = 10)
    public void display() {
        System.out.println("Hello");
    }

    public void displayVar() {
        @MyAnnotation2(someVar = 20) int someData = 10;
    }

}

public class Annotation {
    public static void main(String args[]) {
        Hello h = new Hello();

        try {
            Method m = h.getClass().getMethod("display");
            Method m2 = h.getClass().getMethod("displayVar");
            MyAnnotation mmA = m.getAnnotation(MyAnnotation.class);
            MyAnnotation2 mmA2 = m2.getAnnotation(MyAnnotation2.class);
            System.out.println(mmA.someValue());
            System.out.println(mmA2.someVar());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
