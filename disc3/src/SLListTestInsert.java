public class SLListTestInsert {
    public static void main(String[] args) {
        SLList l = new SLList();
        l.addFirst(1);
        l.addFirst(2);
        l.addFirst(3);
        System.out.print("Initial State:              ");
        l.print();
        System.out.print("Insert 5 at position 0:     ");
        l.insert(5, 0);
        l.print();
        System.out.print("Insert 100 at position 100: ");
        l.insert(100, 100);
        l.print();
        System.out.print("Insert 10 at position 2:    ");
        l.insert(10, 2);
        l.print();
    }


}
