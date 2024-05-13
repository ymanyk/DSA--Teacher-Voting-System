package adt;

import java.util.Iterator;

/**
 * @author Teoh Jia Hao
 */
public interface VoterQueueInterface<T> {

    public Iterator<T> getIterator();

    //Task: Adds a new entry to the back of the queue. 
    public void enqueue(T newEntry);

    //Task: Removes and returns the entry at the front of the queue.
    public T dequeue();

    //Task: Retrieves the entry at the front of the queue.
    public T getFront();

    //get the specific data by providing a specific index
    public T getSpecificData(int index);
    //task: Detects whether the queue is empty.

    public boolean isEmpty();

    public void clear();

}
