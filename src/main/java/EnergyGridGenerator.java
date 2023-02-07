import java.awt.*;

public class EnergyGridGenerator {

    public EnergyGridGenerator() {
    }

    public int[][] generateEnergyGrid(Color[][] pixelGrid) {
        int[][] energyGrid;
        int height = pixelGrid.length;
        int width = pixelGrid[0].length;
        int maxEnergy = 0;
        energyGrid = new int[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (i == 0 || j == 0 || i == height - 1 || j == width - 1) {
                    continue;
                } else {
                    int energy = (int) (Math.pow(pixelGrid[i - 1][j].getRed() - pixelGrid[i + 1][j].getRed(), 2) +
                            Math.pow(pixelGrid[i - 1][j].getGreen() - pixelGrid[i + 1][j].getGreen(), 2) +
                            Math.pow(pixelGrid[i - 1][j].getBlue() - pixelGrid[i + 1][j].getBlue(), 2) +
                            Math.pow(pixelGrid[i][j + 1].getRed() - pixelGrid[i][j - 1].getRed(), 2) +
                            Math.pow(pixelGrid[i][j + 1].getGreen() - pixelGrid[i][j - 1].getGreen(), 2) +
                            Math.pow(pixelGrid[i][j + 1].getBlue() - pixelGrid[i][j - 1].getBlue(), 2));

                    energyGrid[i][j] = energy;
                    if (maxEnergy < energy) {
                        maxEnergy = energy;
                    }
                }
            }
        }
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (i == 0 || j == 0 || i == height - 1 || j == width - 1) {
                    energyGrid[i][j] = maxEnergy;
                }

            }
        }
        return energyGrid;
    }
}
