
/**
 * The Private interface represents vehicles that are not available for public transportation.
 * Vehicles that implement this interface should provide a method to update the necessary features and implementations.
 */
public interface Private {

    /**
    * Updates the distance traveled by the private vehicle.
    *
    * @param km The distance traveled by the private vehicle in kilometers.
    */
    public abstract void travel(int km);
}
