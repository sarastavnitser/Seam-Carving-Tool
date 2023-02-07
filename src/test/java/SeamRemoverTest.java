import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class SeamRemoverTest {

    @Test
    void removeSmallestVerticalSeam() {
        //given
        BufferedImage image;
        try {
            image = ImageIO.read(ImageFrame.class.getResourceAsStream("camera-icon.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ImageObject imageObject = new ImageObject(image);
        int lenBefore = imageObject.getPixelGrid()[0].length;

        //when
        SeamRemover seamRemover = new SeamRemover();
        seamRemover.removeSmallestVerticalSeam(imageObject);
        int lenAfter = imageObject.getPixelGrid()[0].length;

        //then
        assertEquals(lenBefore,lenAfter + 1);
    }

    @Test
    void removeSmallestHorizontalSeam() {
        //given
        BufferedImage image;
        try {
            image = ImageIO.read(ImageFrame.class.getResourceAsStream("camera-icon.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ImageObject imageObject = new ImageObject(image);
        int lenBefore = imageObject.getPixelGrid().length;

        //when
        SeamRemover seamRemover = new SeamRemover();
        seamRemover.removeSmallestHorizontalSeam(imageObject);
        int lenAfter = imageObject.getPixelGrid().length;

        //then
        assertEquals(lenBefore,lenAfter + 1);
    }
}