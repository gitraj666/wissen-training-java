import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Ex5 {
    // Task --> filtering the below list get all the veg items into new list

    //Imperative programming --> bad method
    static List<String> menu = new ArrayList<>();

    static {
        menu.add("veg");
        menu.add("veg");
        menu.add("veg");
        menu.add("nveg");
        menu.add("veg");
        menu.add("veg");
        menu.add("nveg");
        menu.add("veg");
        menu.add("veg");
        menu.add("veg");
    }


    public static void main(String args[]) {

        List<String> vegMenu = new ArrayList<>();


//        for(String item:menu){
//            if(item=="veg") veg.add("veg");
//        }
//        for(String item:veg){
//            System.out.println(item);
//        }


//        vegMenu = menu
//                .stream()
//                .filter(t -> t.equals("veg"))
//                .collect(Collectors.toList());

        menu.removeIf(t -> t.equals("nveg")); //Lambda Expression

        for (String item : vegMenu) {
            System.out.println(item);
        }
    }
}
