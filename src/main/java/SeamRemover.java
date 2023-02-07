import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class SeamRemover {
    private EnergyGridGenerator energyGridGenerator = new EnergyGridGenerator();

    public SeamRemover() {
    }

    public void removeSmallestVerticalSeam(ImageObject imageObject) {
        VerticalSeamCreator verticalSeamCreator = new VerticalSeamCreator();
        int[] smallestSeam = verticalSeamCreator.createSmallestVerticalSeam(imageObject.getEnergyGrid());
        Color[][] pixelGrid = imageObject.getPixelGrid();
        if (smallestSeam.length != pixelGrid.length) {
            //exception
//            return null;
        } else {
            int gridWidth = pixelGrid[0].length;
            for (int i = 0; i < smallestSeam.length; i++) {
                Color[] newRow = new Color[gridWidth - 1];
                for (int j = 0; j < gridWidth - 1; j++) {
                    if (j < smallestSeam[i]) {
                        newRow[j] = pixelGrid[i][j];
                    } else {
                        newRow[j] = pixelGrid[i][j + 1];
                    }
                }
                pixelGrid[i] = newRow;
            }
        }
        imageObject.setPixelGrid(pixelGrid);
        imageObject.setHeight(pixelGrid.length);
        imageObject.setWidth(pixelGrid[0].length);
        int[][] energyGrid = energyGridGenerator.generateEnergyGrid(pixelGrid);
        imageObject.setEnergyGrid(energyGrid);
    }


    public void removeSmallestHorizontalSeam(ImageObject imageObject) {
        HorizontalSeamCreator horizontalSeamCreator = new HorizontalSeamCreator();
        int[] smallestSeam = horizontalSeamCreator.createSmallestHorizontalSeam(imageObject.getEnergyGrid());
        Color[][] pixelGrid = imageObject.getPixelGrid();
        ArrayInverter arrayInverter = new ArrayInverter();
        pixelGrid = arrayInverter.invert2DColorArray(pixelGrid);
        if (smallestSeam.length != pixelGrid.length) {
            //exception
//            return null;
        } else {
            int gridWidth = pixelGrid[0].length;
            for (int i = 0; i < smallestSeam.length; i++) {
                Color[] newRow = new Color[gridWidth - 1];
                for (int j = 0; j < gridWidth - 1; j++) {
                    if (j < smallestSeam[i]) {
                        newRow[j] = pixelGrid[i][j];
                    } else {
                        newRow[j] = pixelGrid[i][j + 1];
                    }
                }
                pixelGrid[i] = newRow;
            }
        }
        pixelGrid = arrayInverter.invert2DColorArray(pixelGrid);
        imageObject.setPixelGrid(pixelGrid);
        imageObject.setHeight(pixelGrid.length);
        imageObject.setWidth(pixelGrid[0].length);
        int[][] energyGrid = energyGridGenerator.generateEnergyGrid(pixelGrid);
        imageObject.setEnergyGrid(energyGrid);
    }
}
