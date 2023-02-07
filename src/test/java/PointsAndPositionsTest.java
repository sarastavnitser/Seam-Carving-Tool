import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PointsAndPositionsTest {

    @Test
    void setPointsAndPositions() {
        //given
        int[][] energyGrid = new int[][]{
                {88930, 88930, 88930, 88930},
                {88930, 44675, 49979, 88930},
                {88930, 22123, 88930, 88930},
                {88930, 88930, 88930, 88930}};
        int height = energyGrid.length;
        int width = energyGrid[0].length;
        PointsAndPositions pointsAndPositions = new PointsAndPositions(energyGrid, height, width);

        //when
        int[] targetPoints = new int[]{244658, 244658, 244658, 311465};
        int[][] targetPositions = new int[][]{{0, 0, 1, 1}, {1, 0, 1, 1}, {2, 1, 1, 1}, {3, 2, 2, 2}};
        int[] actualPoints = pointsAndPositions.getPoints();
        int[][] actualPositions = pointsAndPositions.getPositions();

        //then
        assertArrayEquals(targetPoints, actualPoints);
        assertArrayEquals(targetPositions, actualPositions);

    }
}