public class AListReplicate {
    public static void main(String[] args) {
        int[] arr = new int[] {1, 2, 3};
        arr = AList.replicate(arr);
        for (int item: arr) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
}
