import java.util.Arrays;

public class PointsAndPositions {
    private int[] points;
    private int[][] positions;
    private int[][] energyGrid;
    private int height;
    private int width;

    public PointsAndPositions(int[][] energyGrid, int height, int width) {
        this.energyGrid = energyGrid;
        this.height = height;
        this.width = width;
        setPointsAndPositions();
    }

    private void setPointsAndPositions() {
        points = new int[energyGrid[0].length];
        positions = new int[energyGrid[0].length][energyGrid.length];
        int[] newPoints;
        for (int i = 0; i < height; i++) {
            newPoints = new int[width];
            for (int j = 0; j < width; j++) {
                if (i == 0) {
                    newPoints[j] = energyGrid[i][j];
                    positions[j][i] = j;
                } else if (j == 0) {
                    int posUp = j;
                    int posRight = j + 1;
                    int valUp = points[j];
                    int minVal = valUp;
                    int minPos = posUp;
                    int valRight = points[j + 1];
                    if (valRight < minVal) {
                        minVal = valRight;
                        minPos = posRight;
                    }
                    int thisEnergy = energyGrid[i][j];
                    positions[j][i] = minPos;
                    newPoints[j] = minVal + thisEnergy;
                } else if (j == width - 1) {
                    int posleft = j - 1;
                    int posUp = j;
                    int valLeft = points[j - 1];
                    int minVal = valLeft;
                    int minPos = posleft;
                    int valUp = points[j];
                    if (valUp < minVal) {
                        minVal = valUp;
                        minPos = posUp;
                    }
                    int thisEnergy = energyGrid[i][j];
                    positions[j][i] = minPos;
                    newPoints[j] = minVal + thisEnergy;
                } else {
                    int posleft = j - 1;
                    int posUp = j;
                    int posRight = j + 1;
                    int valLeft = points[j - 1];
                    int minVal = valLeft;
                    int minPos = posleft;
                    int valUp = points[j];
                    if (valUp < minVal) {
                        minVal = valUp;
                        minPos = posUp;
                    }
                    int valRight = points[j + 1];
                    if (valRight < minVal) {
                        minVal = valRight;
                        minPos = posRight;
                    }
                    int thisEnergy = energyGrid[i][j];
                    positions[j][i] = minPos;
                    newPoints[j] = minVal + thisEnergy;
                }
            }
            points = newPoints;
        }
    }

    public int[] getPoints() {
        return points;
    }

    public int[][] getPositions() {
        return positions;
    }

    public static void main(String[] args) {
        int[][] energyGrid = new int[][]{
                {88930, 88930, 88930, 88930},
                {88930, 44675, 49979, 88930},
                {88930, 22123, 88930, 88930},
                {88930, 88930, 88930, 88930}};
        PointsAndPositions pointsAndPositions = new PointsAndPositions(energyGrid, 4, 4);
        System.out.println(Arrays.toString(pointsAndPositions.getPoints()));
        System.out.println(Arrays.deepToString(pointsAndPositions.getPositions()));
    }
}
