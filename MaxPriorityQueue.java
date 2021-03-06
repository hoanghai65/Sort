public interface MaxPriorityQueue<Key extends Comparable<Key>> extends Iterable<Key>{
    public void insert(Key v);

    public Key deleteMax();

    public boolean isEmpty();

    public Key max();

    public int size();
}
