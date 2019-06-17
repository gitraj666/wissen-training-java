import java.util.ArrayList;


public class Main {

    public static void main(String[] args) {
        // Input
        String[] records = {
                "E1,IT,1000",
                "E2,HR,4000",
                "E3,IT,2000",
                "E4,SALES,500",
                "E5,HR,500",
                "E6,IT,4000",
        };

        //Output
        /*
        IT => 3000
        HR => 1000
         */

        ArrayList<String> deptName = new ArrayList<String>();
        ArrayList<Integer> amount = new ArrayList<Integer>();
        for (String record : records) {
            String[] data = record.split(",");
            String deptData = data[1];
            int amtData = Integer.parseInt(data[2]);

            boolean isPresent = false;
            if (deptName.size() == 0) {
                deptName.add(deptData);
                amount.add(amtData);
            }
            //System.out.println(deptName.size());
            for (int i = 0; i < deptName.size(); i++) {
                //System.out.println(deptName.get(i));
                if ((deptName.get(i)) == deptData) {
                    isPresent = true;
                    int temp = amount.get(i);
                    temp += (amtData);
                    amount.set(i, temp);
                } else {
                    deptName.add(deptData);
                    amount.add(amtData);
                }
            }

        }


        for (String item : deptName)
            System.out.println(item);

    }
}
