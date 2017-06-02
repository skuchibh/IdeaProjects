package collections;

import java.util.NoSuchElementException;

/**
 * Created by Surya Vamsi on 20-Mar-15.
 */
public interface IntIterator {
    public int value() throws NoSuchElementException;
    /*
     * @throws NoSuchElementException only if iterator already invalid
     */
    public void advance() throws NoSuchElementException;
    public boolean isValid();
}
