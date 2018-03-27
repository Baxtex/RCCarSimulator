package com.company.Shared;

/**
 * Wraps coordinates and heading into an object to be moved around.
 * Attributes are immutable after being set in the constructor.
 */
public class DataWrapper {

    public final int[] coordinates;
    public final Heading heading;

    /**
     * Constructor that sets this class's attributes.
     *
     * @param coordinates - int array of coordinates.
     * @param heading     - Heading for direction.
     */
    public DataWrapper(int[] coordinates, Heading heading) {
        this.coordinates = coordinates;
        this.heading = heading;
    }
}
