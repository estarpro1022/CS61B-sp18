public class SLList {
    private static class IntNode {
        public int item;
        public IntNode next;

        public IntNode(int item, IntNode next) {
            this.item = item;
            this.next = next;
        }

        public static void reverse(IntNode node) {
            if (node == null)
                return;
            reverse(node.next);
            IntNode p = node.next;
            if (p == null)
                return;
            while (p.next != null)
                p = p.next;
            int tmp = node.item;
            IntNode first = node;
            while (first.next != null) {
                // 元素依次前移
                first.item = first.next.item;
                first = first.next;
            }
            p.item = tmp;
        }
    }

    private IntNode first;

    public void addFirst(int x) {
        first = new IntNode(x, first);
    }

    public void insert(int item, int position) {
        if (first == null || position == 0) {
            addFirst(item);
            return;
        }
        int size = 0;
        IntNode pCount = first;
        while (pCount != null) {
            size++;
            pCount = pCount.next;
        }

        if (position >= size) {
            IntNode last = first;
            while (last.next != null)
                last = last.next;
            last.next = new IntNode(item, null);
            return;
        }

        int count = 1;
        IntNode p = first;
        while (count != position) {
            p = p.next;
            count++;
        }

        p.next = new IntNode(item, p.next);
    }

    public void insertByOfficial(int item, int position) {
        if (first == null || position == 0) {
            // 直接调用前面写好的method
            addFirst(item);
            return;
        }

        IntNode currentNode = first;
        while (position > 1 && currentNode.next != null) {
            currentNode = currentNode.next;
            position--;
        }

        // 一定要加next
        currentNode.next = new IntNode(item, currentNode.next);
    }

    public void reverse() {
        IntNode.reverse(first);
    }

    private IntNode reverseRecursiveHelper(IntNode node) {
        if (node == null || node.next == null)
            return node;
        IntNode reversed = reverseRecursiveHelper(node.next);
        node.next.next = node;
        node.next = null;
        return reversed;
    }

    public void reverseByOfficial() {
        first = reverseRecursiveHelper(first);
    }

    public void reverseIterative() {
        IntNode p = first;
        if (p == null)
            return;
        IntNode node = first;
        while (node != null) {
            IntNode node1 = node;
            while (node1.next != null)
                node1 = node1.next;
            int tmp = node.item;
            node.item = node1.item;
            node1.item = tmp;

            node = node.next;
        }
    }

    public void reverseIterativeByOfficial() {
        IntNode frontOfReversed = null;
        IntNode nextNodeToAdd = first;
        while (nextNodeToAdd != null) {
            IntNode remainderOfOriginal = nextNodeToAdd.next;
            nextNodeToAdd.next = frontOfReversed;
            frontOfReversed = nextNodeToAdd;
            nextNodeToAdd = remainderOfOriginal;
        }
        first = frontOfReversed;
    }

    public void print() {
        IntNode p = first;
        while (p != null) {
            System.out.print(p.item + " ");
            p = p.next;
        }
        System.out.println();
    }
}
