public class AListTestInsert {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3};
        arr = AList.insert(arr, 5, 6);
        print(arr);
    }

    public static void print(int[] arr) {
        for (int item: arr) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
}
