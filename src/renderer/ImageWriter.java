package renderer;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageWriter
{
    private int _imageWidth; // image Width
    private int _imageHeight; // image Height
    private int _Ny, _Nx;
    final String PROJECT_PATH = System.getProperty("user.dir");
    private BufferedImage _image;
    private String _imageName;

    // ***************** Constructors ********************** //
    /*************************************************
     * FUNCTION
     * ImageWriter
     * MEANING
     * Initializing fields.
     **************************************************/
    public ImageWriter(String imageName, int width, int height, int Ny, int Nx) {
        _Nx = Nx;
        _Ny = Ny;
        _imageWidth = width;
        _imageHeight = height;
        _imageName = imageName;
        _image = new BufferedImage(_imageWidth, _imageHeight, BufferedImage.TYPE_INT_RGB);
    }
    /*************************************************
     * FUNCTION
     * ImageWriter
     * PARAMETERS
     * ImageWriter
     * MEANING
     * copy Constructor.
     **************************************************/
    public ImageWriter(ImageWriter imageWriter) {
        _Nx = imageWriter._Nx;
        _Ny = imageWriter._Ny;
        _imageWidth = imageWriter.getWidth();
        _imageHeight = imageWriter.getHeight();
        _imageName = imageWriter._imageName;
        _image = new BufferedImage(_imageWidth, _imageHeight, BufferedImage.TYPE_INT_RGB);
    }

    // ***************** Getters/Setters ********************** //
    public int getWidth() { return _imageWidth; }
    public int getHeight() { return _imageHeight; }
    public int getNy() { return _Ny; }
    public int getNx() { return _Nx; }
    public void setNy(int _Ny) { this._Ny = _Ny; }
    public void setNx(int _Nx) { this._Nx = _Nx; }

    // ***************** Operations ******************** //
    /*************************************************
     * FUNCTION
     * writeToimage
     * MEANING
     * Write the image to a file.
     **************************************************/
    public void writeToimage() {
        File outFile = new File(PROJECT_PATH + "/" + _imageName + ".jpg");
        try
        {
            ImageIO.write(_image, "jpg", outFile);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    /*************************************************
     * FUNCTION
     * writePixel
     * PARAMETERS
     * 2 ints - indexes of a pixel.
     * 3 ints - color.
     * MEANING
     * write one pixel to the buffer.
     **************************************************/
    public void writePixel(int xIndex, int yIndex, int r, int g, int b) {
        int rgb = new Color(r, g, b).getRGB();
        _image.setRGB(xIndex, yIndex, rgb);
    }
    /*************************************************
     * FUNCTION
     * writePixel
     * PARAMETERS
     * 2 ints - indexes of a pixel.
     * int[] - array of red, green, blue.
     * MEANING
     * write one pixel to the buffer.
     **************************************************/
    public void writePixel(int xIndex, int yIndex, int[] rgbArray) {
        int rgb = new Color(rgbArray[0], rgbArray[1], rgbArray[2]).getRGB();
        _image.setRGB(xIndex, yIndex, rgb);
    }
    /*************************************************
     * FUNCTION
     * writePixel
     * PARAMETERS
     * 2 ints - indexes of a pixel.
     * Color - color.
     * MEANING
     * write one pixel to the buffer.
     **************************************************/
    public void writePixel(int xIndex,int yIndex,Color color) {
        _image.setRGB(xIndex, yIndex, color.getRGB());
    }
}