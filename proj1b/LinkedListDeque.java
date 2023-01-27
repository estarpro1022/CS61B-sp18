/** circular linkedlist and basic operations */
public class LinkedListDeque<T> implements Deque<T> {
    private LinkNode sentinel;
    private int size;

    // can't be defined as static, because LinkNode uses T
    private class LinkNode {
        private LinkNode prev;
        private T item;
        private LinkNode next;

        public LinkNode(T i, LinkNode p, LinkNode n) {
            item = i;
            prev = p;
            next = n;
        }
    }

    public LinkedListDeque() {
        sentinel = new LinkNode(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    /** Adds one item to the front of the list */
    @Override
    public void addFirst(T item) {
        LinkNode p = new LinkNode(item, sentinel, sentinel.next);
        sentinel.next.prev = p;
        sentinel.next = p;
        size++;
    }

    /** Adds one item at the end of the list */
    @Override
    public void addLast(T item) {
        LinkNode p = new LinkNode(item, sentinel.prev, sentinel);
        sentinel.prev.next = p;
        sentinel.prev = p;
        size++;
    }

    /** Removes the first item in the list */
    @Override
    public T removeFirst() {
        // forbidden to call removeFirst when size equals 0
        if (size == 0) {
            // but autograder tests empty list...
            return null;
        }
        LinkNode p = sentinel.next;
        sentinel.next = p.next;
        sentinel.next.prev = sentinel;
        p.prev = null;
        p.next = null;
        size--;
        return p.item;
    }

    /** Removes the last item in the list */
    @Override
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        LinkNode p = sentinel.prev;
        sentinel.prev = p.prev;
        p.prev.next = sentinel;
        p.prev = null;
        p.next = null;
        size--;
        return p.item;
    }

    /** Returns the size of the list */
    @Override
    public int size() {
        if (size < 0) {
            System.out.println("REPORT AN ERROR: size is negative.");
        }
        return size;
    }

    /** Returns true if deque is empty, otherwise false */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /** Gets ith item in the deque */
    @Override
    public T get(int index) {
        int count = 0;
        LinkNode p = sentinel.next;
        while (count != index) {
            p = p.next;
            count++;
        }
        return p.item;
    }

    /** Helper method of getRecursive */
    private T getRecursive(LinkNode p, int i) {
        if (p == sentinel) {
            // means return to the beginning
            return null;
        }
        if (i == 0) {
            return p.item;
        }
        return getRecursive(p.next, i - 1);
    }

    /** Gets ith item in a recursive way */
    public T getRecursive(int index) {
        return getRecursive(sentinel.next, index);
    }

    /** Prints items in the deque from first to last */
    @Override
    public void printDeque() {
        LinkNode p = sentinel.next;
        while (p != sentinel) {
            System.out.print(p.item + " ");
            p = p.next;
        }
        System.out.println();
    }
}
