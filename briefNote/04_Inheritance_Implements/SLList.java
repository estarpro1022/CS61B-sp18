 /** An SLList is a list of integers, which hides the terrible truth
   * of the nakedness within. */
public class SLList<T> implements List61B<T> {
	private static class LinkNode<T> {
		T item;
		LinkNode<T> next;

		public LinkNode(T item, LinkNode<T> next) {
			this.item = item;
			this.next = next;
		}

		public LinkNode() {
			item = null;
			next = null;
		}
	}

	private LinkNode<T> sentinel;
	private int size;

	public SLList() {
		sentinel = new LinkNode<>(null, null);
		size = 0;
	}

	public SLList(T item) {
		sentinel = new LinkNode<>(null, null);
		sentinel.next = new LinkNode<>(item, null);
		size = 1;
	}

	@Override
	public void addFirst(T item) {
		sentinel.next = new LinkNode<>(item, sentinel.next);
		size++;
	}

	@Override
	public void addLast(T item) {
		LinkNode<T> p = sentinel;
		while (p.next != null) {
			p = p.next;
		}
		p.next = new LinkNode<>(item, null);
		size++;
	}

	@Override
	public T removeFirst() {
		T item = sentinel.next.item;
		sentinel.next = sentinel.next.next;
		size--;
		return item;
	}

	@Override
	public T removeLast() {
		LinkNode<T> p = sentinel;
		if (p.next == null) {
			return null;
		}
		while (p.next.next != null) {
			p = p.next;
		}
		T item = p.next.item;
		p.next = null;
		size--;
		return item;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public T get(int index) {
		if (index < 0) {
			System.out.println("index must > 0.");
			return null;
		}
		LinkNode<T> p = sentinel.next;
		int count = 0;
		while (count != index && p.next != null) {
			p = p.next;
			count++;
		}
		return p.item;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	public void print() {
		LinkNode<T> p = sentinel.next;
		while (p != null) {
			System.out.print(p.item + " ");
			p = p.next;
		}
		System.out.println();
	}
}