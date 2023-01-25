public class ArrayDeque<T> {
    private int nextFirst, nextLast;
    private int size;
    private T[] items;

    public ArrayDeque() {
        items = (T []) new Object[8];
        nextFirst = 3;
        nextLast = 4;
        size = 0;
    }

    public void addFirst(T item) {
        items[nextFirst] = item;
        nextFirst = nextFirst == 0 ? items.length - 1 : nextFirst - 1;
        size++;
    }

    public void addLast(T item) {
        items[nextLast] = item;
        nextLast = nextLast == items.length - 1 ? 0 : nextLast + 1;
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        boolean[] isPrinted = new boolean[items.length];
        for (int i = (nextFirst + 1) % items.length; i < items.length; i++) {
            if (items[i] != null && !isPrinted[i]) {
                System.out.print(items[i] + " ");
                isPrinted[i] = true;
            }
        }
        for (int i = 0; i <= (nextLast - 1) % items.length; i++) {
            if (items[i] != null && !isPrinted[i]) {
                System.out.print(items[i] + " ");
                isPrinted[i] = true;
            }
        }
        System.out.println();
    }

    public T removeFirst() {
        T item = items[(nextFirst + 1) % items.length];
        items[(nextFirst + 1) % items.length] = null;
        nextFirst = (nextFirst + 1) % items.length;
        size--;
        return item;
    }

    public T removeLast() {
        int lastItemPos = nextLast == 0 ? items.length - 1 : nextLast - 1;
        T item = items[lastItemPos];
        items[lastItemPos] = null;
        nextLast = lastItemPos;
        size--;
        return item;
    }

    public T get(int index) {
        return items[(nextFirst + 1 + index) % items.length];
    }



}
