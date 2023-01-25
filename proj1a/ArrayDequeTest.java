public class ArrayDequeTest {
    public static void main(String[] args) {
        System.out.println("Running tests.\n");
//        Test1();
//        Test2();
        Test3();
    }

    public static void Test1() {
        System.out.println("Test1:");
        ArrayDeque<Integer> a = new ArrayDeque<>();
        a.addFirst(1);
        a.addFirst(2);
        a.addLast(3);
        a.addLast(4);
        System.out.println("No resize: ");
        printBasicInfo(a);
        System.out.println("Index 1: " + a.get(1));
        System.out.println();
    }

    public static void Test2() {
        System.out.println("Test2: resize for bigger");
        ArrayDeque<Integer> a = new ArrayDeque<>();
        printBasicInfo(a);
        a.addFirst(1);
        a.addFirst(2);
        a.addFirst(3);
        a.addFirst(4);
        a.addFirst(5);
        a.addFirst(6);
        a.addFirst(7);
        a.addFirst(8);
        printBasicInfo(a);
        System.out.println("addLast");
        a.addLast(9);
        a.addLast(10);
        a.addLast(11);
        printBasicInfo(a);
        System.out.println("removeFirst");
        a.removeFirst();
        a.removeFirst();
        printBasicInfo(a);
        System.out.println("removeLast");
        a.removeLast();
        a.removeLast();
        printBasicInfo(a);
        System.out.println("Index 5: " + a.get(5));
    }

    public static void Test3() {
        ArrayDeque<Integer> a = new ArrayDeque<>();
        a.addFirst(1);
        a.addFirst(2);
        a.addFirst(3);
        a.addFirst(4);
        a.addFirst(5);
        a.addFirst(6);
        a.addFirst(7);
        a.addFirst(8);
        a.addFirst(9);
        a.addFirst(10);
        printBasicInfo(a);
        System.out.println("resize for smaller");
        a.removeLast();
        a.removeLast();
        a.removeLast();
        a.removeLast();
        a.removeLast();
        a.removeLast();
        a.removeLast();
        printBasicInfo(a);
        System.out.println();
    }

    public static void printBasicInfo(ArrayDeque<Integer> a) {
        System.out.print("Items: ");
        a.printDeque();
        System.out.println("size: " + a.size());
        System.out.println("If empty? " + a.isEmpty());
    }

    public static boolean checkEmpty(boolean expected, boolean actual) {
        if (expected != actual) {
            System.out.println("isEmpty() returned " + actual + ", but expected: " + expected);
            return false;
        }
        return true;
    }

    public static boolean checkSize(int expected, int actual) {
        if (expected != actual) {
            System.out.println("size() returned " + actual + ", but expected: " + expected);
            return false;
        }
        return true;
    }

    public static void printTestStatus(boolean passed) {
        if (passed) {
            System.out.println("\nTest passed!\n");
        } else {
            System.out.println("Test failed!\n");
        }
    }

}
