public interface ListInterface {
	public void add(int item);
	public void addAll(int[] arr);
	public int size();
	public boolean contains(int item);
	public int indexOf(int item);
	public void remove(int index);
	public void removeAll(int[] arr);
	public void clear();
	public boolean equals(List list);
	public int get(int index);
	public List subList(int start, int end);
	public void add(int index, int item);
}