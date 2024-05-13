package adt;
/**
 *
 * @author Yong Man Kei
 */
public interface StackInterface<T> {

    public void pushM(T newEntry);

    public T popM();

    public T peek();

    public void peekA();

    public boolean isEmpty();

    public void clear();
}
