public interface ListInterface<E> {
	public void add(E item);
	public void addAll(E[] arr);
	public int size();
	public boolean contains(E item);
	public int indexOf(E item);
	public void remove(int index);
	public void removeAll(E[] arr);
	public void clear();
	public boolean equals(List<E> list);
	public E get(int index);
	public List<E> subList(int start, int end);
	public void add(int index, E item);
}