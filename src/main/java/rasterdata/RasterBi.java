package rasterdata;

import java.awt.image.BufferedImage;
import java.util.Optional;


public class RasterBi implements Raster {

    private final BufferedImage image;

    public RasterBi(int width, int height) {
        image = new BufferedImage(width,height, BufferedImage.TYPE_INT_RGB);
    }

    @Override
    public int width() {
        return image.getWidth();
    }

    @Override
    public int height() {
        return image.getHeight();
    }

    @Override
    public void setColor(int x, int y, int color) {
        if(x >= 0 && x < width() && y >= 0 && y < height()) {
            image.setRGB(x,y,color);
        }
    }

    @Override
    public Optional<Integer> getColor(int x, int y) {
        if(x >= 0 && x < width() && y >= 0 && y < height()) {
            return Optional.of(image.getRGB(x,y));
        }
        else return Optional.empty();
    }
}
