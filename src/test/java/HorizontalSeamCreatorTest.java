import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HorizontalSeamCreatorTest {

    @Test
    void createSmallestHorizontalSeam() {
        //given
        int[][] energyGrid = new int[][]{
                {88930, 88930, 88930, 88930},
                {88930, 44675, 49979, 88930},
                {88930, 22123, 88930, 88930},
                {88930, 88930, 88930, 88930}};

        int[] targetSmallestHorizontalSeam = new int[]{1, 2, 1, 0};

        //when
        HorizontalSeamCreator horizontalSeamCreator = new HorizontalSeamCreator();
        int[] actualSmallestHorizontalSeam = horizontalSeamCreator.createSmallestHorizontalSeam(energyGrid);

        //then
        assertArrayEquals(targetSmallestHorizontalSeam, actualSmallestHorizontalSeam);
    }
}