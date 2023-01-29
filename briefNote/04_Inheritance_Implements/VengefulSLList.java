public class VengefulSLList<Item> extends SLList<Item> {
    private SLList<Item> deletedItems;

    /* Remember to initialize variables */
    public VengefulSLList() {
        deletedItems = new SLList<>();
    }

    @Override
    public Item removeLast() {
        Item lastItem = super.removeLast();
        deletedItems.addLast(lastItem);
        return lastItem;
    }

    /* Prints deleted items */
    public void printDeletedItems() {
        deletedItems.print();
    }

    public static void main(String[] args) {
        VengefulSLList<String> vengefulSLList = new VengefulSLList<>();
        vengefulSLList.addLast("hel");
        vengefulSLList.addLast("piece");
        vengefulSLList.addLast("love");
        vengefulSLList.print();
        vengefulSLList.removeLast();
        vengefulSLList.print();
        vengefulSLList.printDeletedItems();
    }
}
