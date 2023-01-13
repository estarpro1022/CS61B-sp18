public class SLList {
	// restric access. if public, you need to maintain it forever.
	private IntNode sentinel;
	private int size;

	public SLList() {
		sentinel = new IntNode(0, null);
		sentinel.next = null;
		size = 0;
	}

	/** The first item(if it exists) is at sentinel.next */
	public SLList(int x) {
		sentinel = new IntNode(0, null);
		sentinel.next = new IntNode(x, null);
		size = 1;	// don't want to add follow-up size 
	}


	/** Add x to the front of the list */
	public void addFirst(int x) {
		sentinel.next = new IntNode(x, sentinel.next);
	}

	/** Add x to the end of the list */
	public void addLast(int x) {
		IntNode p = sentinel;

		// Move p until it reaches the end of the list
		// when p.next equals null, it arrives.
		while (p.next != null) p = p.next;
		p.next = new IntNode(x, null);
	}

	/** Return the size of the list starting at IntNode p */
	private static int size(IntNode p) {
		if (p == null)
			return 0;
		return 1 + size(p.next);
	}

	/** Return the size of the list */
	public int size() {
		IntNode p = sentinel.next;
		int totalSize = 0;
		while (p != null) {
			totalSize++;
			p = p.next;
		}

		return totalSize;

		// second way
		// size(first);
	}

	/** Return the first item in the list */
	public int getFirst() {
		return sentinel.next.item;
	}

	public static void main(String[] args) {
		SLList L = new SLList();
		L.addLast(10);
		L.addLast(20);
		System.out.println(L.size());
	}

}
