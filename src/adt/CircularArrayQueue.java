package adt;

import java.util.Iterator;

/**
 * @author Teoh Jia Hao
 */
public class CircularArrayQueue<T> implements VoterQueueInterface<T> {

    private T[] array; // circular array of array entries and one unused location
    private int fIndex;
    private int bIndex;
    private static final int DEFAULT_CAPACITY = 5;

    public CircularArrayQueue() {
        this(DEFAULT_CAPACITY);
    }

    public CircularArrayQueue(int initialCapacity) {
        array = (T[]) new Object[initialCapacity + 1];
        fIndex = 0;
        bIndex = initialCapacity;
    }

    public void enqueue(T newEntry) {

        resize();
        bIndex = (bIndex + 1) % array.length;
        array[bIndex] = newEntry;

    }

    public T dequeue() {
        T front = null;

        if (!isEmpty()) {
            front = array[fIndex];
            array[fIndex] = null;
            fIndex = (fIndex + 1) % array.length;
        }

        return front;
    }

    public T getFront() {
        T front = null;

        if (!isEmpty()) {
            front = array[fIndex];
        }

        return front;
    }

    public T getSpecificData(int index) {
        T data = null;

        if (!isEmpty()) {
            data = array[(fIndex + index) % array.length];
        }

        return data;
    }

    public T[] getArray() {
        return array;
    }

    public boolean isEmpty() {
        return fIndex == ((bIndex + 1) % array.length);
    }

    public void clear() {
        if (!isEmpty()) {
            for (int index = fIndex; index != bIndex; index = (index + 1) % array.length) {
                array[index] = null;
            }
            array[bIndex] = null;
        }

        fIndex = 0;
        bIndex = array.length - 1;
    }

    private boolean isArrayFull() {
        return fIndex == ((bIndex + 2) % array.length);
    }

    private void resize() {
        //check the array is full and expand it
        int j = 0;
        if (isArrayFull()) {

            T[] copyArray;
            copyArray = (T[]) new Object[array.length * 2];
            int y = 0;
            for (int i = fIndex; i < (array.length - 1) % array.length; y++) {
                i = (fIndex + y) % array.length;
                copyArray[(j) % copyArray.length] = array[i];
                j++;
            }

            //COPY AND PASTE THE BACK INDEX
            y = 0;
            if (((array.length - 1) % array.length) != bIndex && fIndex != 0) {
                for (int i = array.length % array.length; i <= bIndex; y++) {
                    i = (array.length + y) % array.length;
                    copyArray[(j) % copyArray.length] = array[i];
                    j++;
                }
            }
            fIndex = 0;
            bIndex = (array.length - 1) % array.length;
            array = copyArray;
            bIndex = (bIndex - 1) % array.length;

        }
    }

    public Iterator<T> getIterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        String outputStr = "";
        int j = 0;
        for (int i = fIndex; i < bIndex; j++) {
            i = (fIndex + j) % array.length;
            outputStr += array[i] + "\n";
        }

        return outputStr;
    }
}
