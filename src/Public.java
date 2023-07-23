/**
 * The Public interface represents a public vehicle and provides a method to compute the fare
 * based on the distance traveled.
 */
public interface Public {
    /**
    * Computes the fare for a public vehicle based on the distance traveled in kilometers.
    *
    * @param km The distance traveled by the public vehicle in kilometers.
    */
    public abstract int computeFair(int km);
}
