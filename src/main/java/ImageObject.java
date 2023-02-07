
import java.awt.*;
import java.awt.image.BufferedImage;

import static javax.imageio.ImageIO.read;

public class ImageObject {
    private BufferedImage image;
    private EnergyGridGenerator energyGridGenerator = new EnergyGridGenerator();
    private Color[][] pixelGrid;
    private SeamRemover seamRemover = new SeamRemover();
    private int height;
    private int width;
    private int[][] energyGrid;

    public ImageObject(BufferedImage imageFile) {
        image = imageFile;
        width = image.getWidth();
        height = image.getHeight();
        generatePixelArray();
        energyGrid = energyGridGenerator.generateEnergyGrid(pixelGrid);
    }

    private void generatePixelArray() {
        pixelGrid = new Color[height][width];
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                pixelGrid[row][col] = new Color(image.getRGB(col, row));
            }
        }
    }

    public int[][] getEnergyGrid() {
        return energyGrid;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public Color[][] getPixelGrid() {
        return pixelGrid;
    }

    public void setPixelGrid(Color[][] pixelGrid) {
        this.pixelGrid = pixelGrid;
    }

    public void removeSmallestVerticalSeam() {
        seamRemover.removeSmallestVerticalSeam(this);
    }

    public void removeSmallestHorizontalSeam() {
        seamRemover.removeSmallestHorizontalSeam(this);
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setEnergyGrid(int[][] energyGrid) {
        this.energyGrid = energyGrid;
    }

    public void resetImage() {
        BufferedImage newPic = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                newPic.setRGB(j, i, pixelGrid[i][j].getRGB());
            }
        }
        image = newPic;
    }

    public BufferedImage getImage() {
        return image;
    }

}
