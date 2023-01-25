public class AListReverse {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 4, 5};
        AList.reverse(arr);
        for (int item: arr) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
}
