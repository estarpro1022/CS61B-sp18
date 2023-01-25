public class ArrayDeque<T> {
    private int nextFirst, nextLast;
    private int size;
    private T[] items;

    public ArrayDeque() {
        items = (T []) new Object[8];
        nextFirst = 7;
        nextLast = 0;
        size = 0;
    }

    private void ifResize() {
        if (size == items.length) {
            resize(2 * items.length);
        }
        if (items.length > 8) {
            double ratio = 1.0 * size / items.length;
            if (ratio <= 0.25) {
                resize(items.length / 2);
            }
        }
    }

    public void addFirst(T item) {
        ifResize();
        items[nextFirst] = item;
        nextFirst = nextFirst == 0 ? items.length - 1 : nextFirst - 1;
        size++;
    }

    public void addLast(T item) {
        ifResize();
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
        for (int i = nextFirst + 1; i < items.length; i++) {
            if (items[i] != null && !isPrinted[i]) {
                System.out.print(items[i] + " ");
                isPrinted[i] = true;
            }
        }
        for (int i = 0; i < nextLast; i++) {
            if (items[i] != null && !isPrinted[i]) {
                System.out.print(items[i] + " ");
                isPrinted[i] = true;
            }
        }
        System.out.println();
    }

    public T removeFirst() {
        // 空的deque删除不做操作
        if (size == 0) {
            return null;
        }
        ifResize();
        int firstItemPos = (nextFirst + 1) % items.length;
        T item = items[firstItemPos];
        items[firstItemPos] = null;
        nextFirst = firstItemPos;
        size--;
        return item;
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }
        ifResize();
        int lastItemPos = nextLast == 0 ? items.length - 1 : nextLast - 1;
        T item = items[lastItemPos];
        items[lastItemPos] = null;
        nextLast = lastItemPos;
        size--;
        return item;
    }

    public T get(int index) {
        if (index < 0) {
            System.out.println("Index is not allowed to be negative.");
            return null;
        }
        if (index >= size) {
            System.out.println("Index is out of bound.");
            return null;
        }
        return items[(nextFirst + 1 + index) % items.length];
    }

    private void resize(int capacity) {
        T[] newItems = (T []) new Object[capacity];
        boolean[] isCopy = new boolean[items.length];
        int num = 0;
        for (int i = (nextFirst + 1) % items.length; i < items.length; i++) {
            if (items[i] != null && !isCopy[i]) {
                newItems[i - (nextFirst + 1) % items.length] = items[i];
                num++;
                isCopy[i] = true;
            }
        }
        int lastItemPos = nextLast == 0 ? items.length - 1 : nextLast - 1;
        for (int i = 0; i <= lastItemPos; i += 1) {
            if (items[i] != null && !isCopy[i]) {
                newItems[i + num] = items[i];
                isCopy[i] = true;
            }
        }
        items = newItems;
        nextFirst = items.length - 1;
        nextLast = size;
    }
}
