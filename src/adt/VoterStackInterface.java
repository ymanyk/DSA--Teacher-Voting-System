package adt;
/**
 * @author Teoh Jia Hao
 */
public interface VoterStackInterface<T> {

    public void addVoter(T newEntry);

    public T removeLastVoter();

    public T checkLastVoter();

    public void checkAllVoter();

    public T removeFirstVoter();

    public boolean isEmpty();

    public void clear();
}
