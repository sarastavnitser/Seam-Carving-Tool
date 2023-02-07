import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class EnergyGridGeneratorTest {
    @Test
    public void generateEnergyGrid() {
        //given
        EnergyGridGenerator e = new EnergyGridGenerator();
        Color[][] pixelGrid = new Color[][]{
                {
                        new Color(106, 111, 242),
                        new Color(96, 150, 166),
                        new Color(240, 83, 160),
                        new Color(139, 152, 163)
                },
                {
                        new Color(200, 132, 134),
                        new Color(218, 134, 17),
                        new Color(133, 185, 8),
                        new Color(251, 80, 222)
                },
                {
                        new Color(143, 18, 99),
                        new Color(195, 156, 58),
                        new Color(182, 80, 136),
                        new Color(25, 143, 148)
                },
                {
                        new Color(162, 90, 27),
                        new Color(148, 74, 100),
                        new Color(148, 241, 228),
                        new Color(83, 155, 92)
                }
        };

        int[][] targetEnergyGrid = new int[][]{
                {88930, 88930, 88930, 88930},
                {88930, 44675, 49979, 88930},
                {88930, 22123, 88930, 88930},
                {88930, 88930, 88930, 88930}};
        //when
        int[][] generatedEnergyGrid = e.generateEnergyGrid(pixelGrid);
        //then
        assertArrayEquals(targetEnergyGrid, generatedEnergyGrid);
    }

}
