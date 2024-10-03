package rasterdata;

//Represents a two dimensional grid

import java.util.Optional;

public interface Raster {

    /**
     * Returns number of columns
     * @return
     */
    int width();


    /**
     * Returns number of rows
     * @return
     */
    int height();


    /**
     *
     * @param x - Row address
     * @param y - Column address
     * @return Optional of color if the given address is valid; empty optional otherwise
     */
    Optional<Integer> getColor(int x, int y);

    /**
     *
     * @param x - Row address
     * @param y - Column address
     * @param color - Integer of color
     */
    void setColor(int x, int y, int color);
}
