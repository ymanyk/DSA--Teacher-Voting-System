package adt;

/**
 * @author Teoh Jia Hao
 * @param <T>
 */
public class ArrayStackVoter<T> implements VoterStackInterface<T> {

    private T[] array;
    private int topIndex; // index of top entry
    private int btmindex = 0;
    private static final int DEFAULT_CAPACITY = 10;

    public ArrayStackVoter() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayStackVoter(int initialCapacity) {
        array = (T[]) new Object[initialCapacity];
        topIndex = -1;
    }

    @Override
    public void addVoter(T newEntry) {
        topIndex++;

        if (topIndex < array.length) {
            array[topIndex] = newEntry;
        }
    }

    @Override
    public T checkLastVoter() {
        T top = null;

        if (!isEmpty()) {
            top = array[topIndex];
        }

        return top;
    }

    @Override
    public void checkAllVoter() {
        if (!isEmpty()) {
            for (int i = 0; i < array.length; i++) {
                if (array[i] != null) {
                    System.out.println(array[i]);
                }

            }

        }

    }

    @Override
    public T removeLastVoter() {
        T top = null;
        if (!isEmpty()) {
            top = array[topIndex];
            array[topIndex] = null;
            topIndex--;

        } // end if

        return top;
    }

    @Override
    public T removeFirstVoter() {
        T bottom = null;

        if (!isEmpty()) {
            bottom = array[0];
            for (int i = 1; i <= topIndex; i++) {
                array[i - 1] = array[i];
            }
            array[topIndex] = null;
            topIndex--;

        } // end if

        return bottom;
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
