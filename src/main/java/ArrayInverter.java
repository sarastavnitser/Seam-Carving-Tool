import java.awt.*;
import java.util.Arrays;

public class ArrayInverter {
    public ArrayInverter() {
    }
    public int[][] invert2DIntArray(int[][] array) {
        int rows = array.length;
        int cols = array[0].length;
        int[][] newArray = new int[cols][rows];
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                newArray[i][j] = array[j][i];
            }
        }
        return newArray;
    }
    public Color[][] invert2DColorArray(Color[][] array) {
        int rows = array.length;
        int cols = array[0].length;
        Color[][] newArray = new Color[cols][rows];
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                newArray[i][j] = array[j][i];
            }
        }
        return newArray;
    }
}
