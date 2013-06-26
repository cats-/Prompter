package cats.prompt.restriction;

/**
 * User: cats
 * Date: 6/25/13
 * Time: 9:40 AM
 */
public interface Restriction<T> {

    public boolean restrict(final T value);
}
