package co.za.task.tracker.util.property_fetcher;

/**
 * Property retrieval operator
 * @param <T> the property data type
 */
@FunctionalInterface
public interface IPropertyFetcher<T> {

    /**
     * gets the property value/s
     * @param keyValue key for property
     * @return returns value/s of property
     */
    String getProperty(T keyValue);
}
