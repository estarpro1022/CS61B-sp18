public interface List61B<T> {
    public void addFirst(T item);

    public void addLast(T item);

    public T removeFirst();

    public T removeLast();

    public int size();

    public boolean isEmpty();

    public T get(int index);

    default public void print() {
        for (int i = 0; i < size(); i++) {
            System.out.print(get(i));
        }
        System.out.println();
    }
}
