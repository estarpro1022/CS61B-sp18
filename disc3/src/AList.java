public class AList {

    public static int[] insert(int[] arr, int item, int position) {
        int[] newArr = new int[arr.length + 1];
//        if (position >= arr.length) {
//            System.arraycopy(arr, 0, newArr, 0, arr.length);
//            newArr[arr.length] = item;
//            return newArr;
//        }
        position = Math.min(position, arr.length);
        System.arraycopy(arr, 0, newArr, 0, position);
        newArr[position] = item;
        System.arraycopy(arr, position, newArr, position + 1, arr.length - position);
        return newArr;
    }

    public static void reverse(int[] arr) {
        // 采用了冒泡排序的思想，但是时间复杂度为O(n²)
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                int tmp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = tmp;
            }
        }
    }

    public static void reverseByOfficial(int[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            int tmp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = tmp;
        }
    }

    public static int[] replicate(int[] arr) {
        int len = 0;
        for (int elem: arr) {
            len += elem;
        }
        int[] newArr = new int[len];
        int breakPoint = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i]; j++) {
                newArr[j + breakPoint] = arr[i];
            }
            breakPoint += arr[i];
        }
        return newArr;
    }

    public static int[] replicateByOfficial(int[] arr) {
        int total = 0;
        for (int item: arr) {
            total += item;
        }

        int[] result = new int[total];
        int i = 0;
        for (int item: arr) {
            for (int counter = 0; counter < item; counter++) {
                result[i] = item;
                i++;
            }
        }
        return result;
    }
}
