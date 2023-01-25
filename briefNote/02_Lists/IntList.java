public class IntList {
	public int first;
	public IntList rest;

	public IntList(int f, IntList r) {
		first = f;
		rest = r;
	}

	public void addFirst(int x) {
		int temp = first;
		this.first = x;
		this.rest = new IntList(temp, this.rest);
	}

	public int size() {
		int count = 0;
		IntList L = this;
		while (L != null) {
			count++;
			L = L.rest;
		}
		return count;
	}

	public int size(IntList L, int s) {
		if (L == null) return s;
		return size(L.rest, s + 1);
	}

	/** Get the ith integer of the list */
	public int get(int i) {
		if (i >= size()) {
			System.out.println("The index is out of bound. Please enter another number.");
			return -1;
		}
		IntList p = this;
		int count = 0;
		int num = p.first;

		// count means p's current position
		// count = 0 means p points to 0th, count = 1 means p points to 1th
		while (count != i) {
			p = p.rest;
			num = p.first;
			count++;
		}

		return num;

		// if (i == 0)
		    // return first;
		// return rest.get(i - 1);
	}

	public static void main(String[] args) {
		IntList L = new IntList(15, null);
		// L = new IntList(10, L);
		// L = new IntList(5, L);
		L.addFirst(10);
		L.addFirst(5);
		System.out.println(L.size(L, 0));
		System.out.println(L.get(0) + " " + L.get(2));
	}
}
