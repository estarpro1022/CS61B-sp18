/** circular linkedlist and basic operations */
public class LinkedListDeque<T> {
    private LinkNode sentinel;
    private int size;

    // can't be defined as static, because LinkNode uses T
    private class LinkNode {
        public LinkNode prev;
        public T item;
        public LinkNode next;

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
    public void addFirst(T item) {
        LinkNode p = new LinkNode(item, sentinel, sentinel.next);
        sentinel.next.prev = p;
        sentinel.next = p;
        size++;
    }

    /** Adds one item at the end of the list */
    public void addLast(T item) {
        LinkNode p = new LinkNode(item, sentinel.prev, sentinel);
        sentinel.prev.next = p;
        sentinel.prev = p;
        size++;
    }

    /** Removes the first item in the list */
    public T removeFirst() {
        // forbidden to call removeFirst when size equals 0
        LinkNode p = sentinel.next;
        sentinel.next = p.next;
        sentinel.next.prev = sentinel;
        p.prev = null;
        p.next = null;
        size--;
        return p.item;
    }

    /** Removes the last item in the list */
    public T removeLast() {
        LinkNode p = sentinel.prev;
        sentinel.prev = p.prev;
        p.prev.next = sentinel;
        p.prev = null;
        p.next = null;
        size--;
        return p.item;
    }

    /** Returns the size of the list */
    public int size() {
        return size;
    }

    /** Returns true if deque is empty, otherwise false */
    public boolean isEmpty() {
        return size == 0;
    }

    /** Gets ith item in the deque */
    public T get(int index) {
        int count = 0;
        LinkNode p = sentinel;
        while (count != index) {
            p = p.next;
            count++;
        }
        return p.item;
    }

    /** Prints items in the deque from first to last */
    public void printDeque() {
        LinkNode p = sentinel.next;
        while (p != sentinel) {
            System.out.print(p.item + " ");
            p = p.next;
        }
        System.out.println();
    }
}
