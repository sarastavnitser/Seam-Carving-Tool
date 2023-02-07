import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VerticalSeamCreatorTest {

    @Test
    void createSmallestVerticalSeam() {
        //given
        int[][] energyGrid = new int[][]{
                {88930, 88930, 88930, 88930},
                {88930, 44675, 49979, 88930},
                {88930, 22123, 88930, 88930},
                {88930, 88930, 88930, 88930}};

        int[] targetSmallestVerticalSeam = new int[]{0, 1, 1, 0};

        //when
        VerticalSeamCreator verticalSeamCreator = new VerticalSeamCreator();
        int[] actualSmallestVerticalSeam = verticalSeamCreator.createSmallestVerticalSeam(energyGrid);

        //then
        assertArrayEquals(targetSmallestVerticalSeam, actualSmallestVerticalSeam);

    }
}