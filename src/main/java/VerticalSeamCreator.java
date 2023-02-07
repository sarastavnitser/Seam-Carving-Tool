import java.util.Arrays;

public class VerticalSeamCreator {
    public VerticalSeamCreator() {
    }

    public int[] createSmallestVerticalSeam(int[][] energyGrid) {
        int height = energyGrid.length;
        int width = energyGrid[0].length;
        PointsAndPositions pointsAndPositions = new PointsAndPositions(energyGrid, height, width);
        int[] points = pointsAndPositions.getPoints();
        int[][] positions = pointsAndPositions.getPositions();
        int minPoint = points[0];
        int minEndPos = 0;
        for (int i = 0; i < points.length; i++) {
            if (points[i] < minPoint) {
                minPoint = points[i];
                minEndPos = i;
            }
        }
        int[] smallestSeam = new int[height];
        int currPos = minEndPos;
        for (int i = height - 1; i >= 0; i--) {
            smallestSeam[i] = currPos;
            currPos = positions[currPos][i];
        }
        return smallestSeam;
    }
}
