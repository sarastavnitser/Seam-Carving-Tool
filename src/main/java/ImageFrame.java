import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class ImageFrame extends JFrame {

    private final JLabel imageLabel;
    private ImageObject imageObject;
    private File currentFile;

    public ImageFrame() {

        setLayout(new BorderLayout());

        // This is where the image will be stored.
        imageLabel = new JLabel();

        JPanel northPanel = new JPanel();
        northPanel.setLayout(new FlowLayout());
        JButton resizeButton = new JButton("Resize");
        resizeButton.addActionListener(event -> {
            // This will set the image based on the current size of the label
            setSeamImageSize(imageLabel.getWidth(), imageLabel.getHeight());
        });
        northPanel.add(resizeButton);
        JButton loadButton = new JButton("Load");
        northPanel.add(loadButton);
        loadButton.addActionListener(event -> {
            try {
                chooseFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        JButton resetButton = new JButton("Reset");
        northPanel.add(resetButton);
        resetButton.addActionListener(event -> {
            try {
                resetImage();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        add(northPanel, BorderLayout.NORTH);
        add(imageLabel, BorderLayout.CENTER);

        BufferedImage image;
        try {
            image = ImageIO.read(ImageFrame.class.getResourceAsStream("Broadway_tower_edit.jpg"));
            currentFile = new File(ImageFrame.class.getResource("Broadway_tower_edit.jpg").getPath());
            loadSeamImage(image);
            setSize(image.getWidth(null), image.getHeight(null));
            pack();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        setTitle("Seam Carving");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    private  void resetImage() throws IOException {
        loadSeamImage(ImageIO.read(currentFile));
        loadSeamImage(ImageIO.read(currentFile));
    }

    private void chooseFile() throws IOException {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(this);

        if (result == JFileChooser.APPROVE_OPTION)
        {
            currentFile = new File(fileChooser.getSelectedFile().getAbsolutePath());
            try {
                loadSeamImage(ImageIO.read(currentFile));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        this.resetImage();
    }

    public void loadSeamImage(BufferedImage image) {

        // add code here to load the image into your seam carver code


        setSize(image.getWidth(null), image.getHeight(null));
        pack();
        imageObject = new ImageObject(image);
        imageLabel.setIcon(new ImageIcon(imageObject.getImage()));
    }

    private void setSeamImageSize(int width, int height) {
        // generate a newImage with the new width and height
        int difHeight = imageObject.getHeight() - height;
        int difWidth = imageObject.getWidth() - width;
        for(int i = 0; i < difHeight; i ++){
            imageObject.removeSmallestHorizontalSeam();
        }
        for (int i = 0; i < difWidth; i ++){
            imageObject.removeSmallestVerticalSeam();
        }
        imageObject.resetImage();

        imageLabel.setIcon(new ImageIcon(imageObject.getImage()));
    }

    public static void main(String[] args) {
        new ImageFrame().setVisible(true);
    }

}