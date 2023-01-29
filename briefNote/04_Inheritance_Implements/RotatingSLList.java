public class RotatingSLList<Item> extends SLList<Item> {
    public void rotateRight() {
        Item item = removeLast();
        addFirst(item);
    }

    public static void main(String[] args) {
        RotatingSLList<String> rotate = new RotatingSLList<>();
        rotate.addLast("lps");
        rotate.addLast("hel");
        rotate.addLast("kev");
        rotate.print();
        rotate.rotateRight();
        rotate.print();
    }
}
