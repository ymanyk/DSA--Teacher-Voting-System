package adt;
/**
 * @author Rinisha
 */
public interface LinkedListInterface<T> {

    public boolean addNewItem(T newEntry);

    public boolean add(int newPosition, T newEntry);

    public T removeItem(int givenPosition);

    public void clear();

    public boolean update(int givenPosition, T newEntry);

    public T findVariable(int givenPosition);

    public int search(T anEntry);

    public int getTotalLength();

    public boolean isEmpty();

    public boolean isFull();

    public void display();
}
