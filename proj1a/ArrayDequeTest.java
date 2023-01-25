public class ArrayDequeTest {
    public static void main(String[] args) {
        System.out.println("Running tests.\n");
        ArrayDeque<Integer> a = new ArrayDeque<>();
        a.addFirst(1);
        a.addFirst(2);
        a.addLast(3);
        a.addLast(4);
        System.out.print("ArrayDeque status: ");
        a.printDeque();
        System.out.println("size: " + a.size());

        boolean passed = checkEmpty(a.isEmpty(), false) && checkSize(a.size(), 4);
        printTestStatus(passed);
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
