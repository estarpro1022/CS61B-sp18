public class SLListTestReverse {
    public static void main(String[] args) {
        SLList l = new SLList();
        l.addFirst(10);
        l.addFirst(5);
        l.addFirst(1);
        System.out.println("Reverse method: ");
        System.out.print("Initial state: ");
        l.print();
        System.out.print("Reverse state: ");
        l.reverse();
        l.print();
        System.out.print("Iterative method: ");
        SLList l1 = new SLList();
        l1.addFirst(3);
//        l1.addFirst(2);
//        l1.addFirst(1);
        System.out.print("Initial state: ");
        l1.print();
        System.out.print("Reverse state: ");
        l1.reverse();
        l1.print();
        System.out.println("========================");
        SLList l2 = new SLList();
        l2.addFirst(3);
        l2.addFirst(2);
        l2.addFirst(1);
        l2.reverseByOfficial();
        l2.print();
    }
}
