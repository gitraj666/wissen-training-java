import java.util.ArrayList;

class Node {
    private Node next;
    //private int count;
    ArrayList<Integer> count = new ArrayList<>();
    private int amt;

    public Node(int amt, Node next) {
        this.next = next;
        this.amt = amt;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void gotoNext(Node next, int amount) {
        next.withdrawAmt(amount);
    }

    public void withdrawAmt(int amount) {
        //int count = 0;
        while (amount >= this.amt) {
            amount -= amt;
            System.out.println("Note " + this.amt + " returned");
            //count.add(this.amt);
        }
        if (amount > 0 && this.next != null) this.gotoNext(this.next, amount);
        //return count;
    }
}


public class Ex6 {

    public static void main(String[] args) {
        int depositMoney = 2000;
        Node note100 = new Node(100, null);
        Node note500 = new Node(500, note100);
        Node note2000 = new Node(2000, note500);

        //System.out.println(note500.getNext());
        //System.out.println(note2000.withdrawAmt(depositMoney));
//        ArrayList<Integer> res = note2000.withdrawAmt(depositMoney);
//        for(Integer r : res)
//            System.out.println(r);
        note2000.withdrawAmt(depositMoney);
    }
}
