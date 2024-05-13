package adt;

import java.util.Iterator;

/**
 * @author Wong Soon Chee
 */
public interface ListInterfaceVoter<T> {

    public boolean addVoter(T newEntry);

    public boolean addVoter(int newPosition, T newEntry);

    public T removeVoter(int givenPosition);

    public void clearVoterList();

    public boolean replaceVoter(int givenPosition, T newEntry);

    public T getEntryVoter(int givenPosition);

    public boolean contains(T anEntry);

    public boolean isEmpty();

    public boolean isFull();

    public int getLength();

    public void display();

    public int getPosition(T Entry);

    public Iterator<T> getIterator();
}
