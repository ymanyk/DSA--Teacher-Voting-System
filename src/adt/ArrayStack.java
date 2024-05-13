package adt;

/**
 * @author Yong Man Kei
 * @param <T>
 */
public class ArrayStack<T> implements StackInterface<T> {

    private T[] array;
    private int topIndex; // index of top entry
    private static final int DEFAULT_CAPACITY = 10;

    public ArrayStack() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayStack(int initialCapacity) {
        array = (T[]) new Object[initialCapacity];
        topIndex = -1;
    }

    @Override
    public void pushM(T newEntry) {
        topIndex++;

        if (topIndex < array.length) {
            array[topIndex] = newEntry;
        }
    }

    @Override
    public T peek() {
        T top = null;

        if (!isEmpty()) {
            top = array[topIndex];
        }

        return top;
    }

    public int getTopIndex() {
        return topIndex;
    }

    @Override
    public void peekA() {
        if (!isEmpty()) {
            for (int i = topIndex; i >= 0; i--) {

                System.out.println(array[i]);
            }

        }

    }

    @Override
    public T popM() {
        T top = null;

        if (!isEmpty()) {
            top = array[topIndex];
            array[topIndex] = null;
            topIndex--;

        } // end if

        return top;
    }

    @Override
    public boolean isEmpty() {
        return topIndex < 0;
    }

    @Override
    public void clear() {
        topIndex = -1;
    }

}
