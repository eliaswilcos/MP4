import java.util.Arrays;
import java.util.Objects;

/**
 * Transform Class.
 */
public class Transform {
    /**
     * default color shift.
     */
    static int DEFAULT_COLOR_SHIFT;
    /**
     * default position shift.
     */
    static int DEFAULT_POSITION_SHIFT;
    /**
     * default resize amount
     */
    static int DEFAULT_RESIZE_AMOUNT;
    /**
     * default constructor
     */
    public Transform() {
    }
    /**
     * expand horizontal
     * @param originalImage original image
     * @param amount amount
     */
    public static RGBAPixel[][] expandHorizontal(final RGBAPixel[][] originalImage, final int amount) {
    }
    /**
     * expand vertical
     * @param originalImage original image
     * @param amount amount
     */
    public static RGBAPixel[][] expandVertical(final RGBAPixel[][] originalImage, final int amount) {
    }
    /**
     * flip horizontal
     * @param originalImage original image
     */
    public static RGBAPixel[][] flipHorizontal(final RGBAPixel[][] originalImage) {
        RGBAPixel[][] copy = new RGBAPixel[originalImage.length][originalImage[0].length];
        int width = originalImage[0].length;
        for (int i = 0; i < originalImage.length; i++) {
            for (int j = 0; j < originalImage[i].length; j++) {
                copy[width - i - 1][j] = originalImage[i][j];
            }
        }
    }
    /**
     * flip vertical
     * @param originalImage original image
     */
    public static RGBAPixel[][] flipVertical(final RGBAPixel[][] originalImage) {
        RGBAPixel[][] copy = new RGBAPixel[originalImage.length][originalImage[0].length];
        int height = originalImage.length;
        for (int i = 0; i < originalImage.length; i++) {
            for (int j = 0; j < originalImage[i].length; j++) {
                copy[i][height - j - 1] = originalImage[i][j];
            }
        }
    }
    /**
     * green screen
     * @param originalImage original image
     */
    public static RGBAPixel[][] greenScreen(final RGBAPixel[][] originalImage) {
    }
    /**
     * less alpha
     * @param originalImage original image
     * @param amount amount
     */
    public static RGBAPixel[][] lessAlpha(final RGBAPixel[][] originalImage, final int amount) {
    }
    /**
     * less blue
     * @param originalImage original image
     * @param amount amount
     */
    public static RGBAPixel[][] lessBlue(final RGBAPixel[][] originalImage, final int amount) {
    }
    /**
     * less green
     * @param originalImage original image
     * @param amount amount
     */
    public static RGBAPixel[][] lessGreen(final RGBAPixel[][] originalImage, final int amount) {
    }
    /**
     * less red
     * @param originalImage original image
     * @param amount amount
     */
    public static RGBAPixel[][] lessRed(final RGBAPixel[][] originalImage, final int amount) {
    }
    /**
     * more alpha
     * @param originalImage original image
     * @param amount amount
     */
    public static RGBAPixel[][] moreAlpha(final RGBAPixel[][] originalImage, final int amount) {
    }
    /**
     * more blue
     * @param originalImage original image
     * @param amount amount
     */
    public static RGBAPixel[][] moreBlue(final RGBAPixel[][] originalImage, final int amount) {
    }
    /**
     * more green
     * @param originalImage original image
     * @param amount amount
     */
    public static RGBAPixel[][] moreGreen(final RGBAPixel[][] originalImage, final int amount) {
    }
    /**
     * more red
     * @param originalImage original image
     * @param amount amount
     */
    public static RGBAPixel[][] moreRed(final RGBAPixel[][] originalImage, final int amount) {
    }
    /**
     * mystery
     * @param originalImage original image
     */
    public static RGBAPixel[][] mystery(final RGBAPixel[][] originalImage) {
    }
    /**
     * rotate left
     * @param originalImage original image
     */
    public static RGBAPixel[][] rotateLeft(final RGBAPixel[][] originalImage) {
    }
    /**
     * rotate right
     * @param originalImage original image
     */
    public static RGBAPixel[][] rotateRight(final RGBAPixel[][] originalImage) {
    }
    /**
     * shift down
     * @param originalImage original image
     * @param amount amount
     */
    public static RGBAPixel[][] shiftDown(final RGBAPixel[][] originalImage, final int amount) {
    }
    /**
     * shift left
     * @param originalImage original image
     * @param amount amount
     */
    public static RGBAPixel[][] shiftLeft(final RGBAPixel[][] originalImage, final int amount) {
    }
    /**
     * shift right
     * @param originalImage original image
     * @param amount amount
     */
    public static RGBAPixel[][] shiftRight(final RGBAPixel[][] originalImage, final int amount) {
    }
    /**
     * shift up
     * @param originalImage original image
     * @param amount amount
     */
    public static RGBAPixel[][] shiftUp(final RGBAPixel[][] originalImage, final int amount) {
    }
    /**
     * shrink horizontal
     * @param originalImage original image
     * @param amount amount
     */
    public static RGBAPixel[][] shrinkHorizontal(final RGBAPixel[][] originalImage, final int amount) {
    }
    /**
     * shrink vertical
     * @param originalImage original image
     * @param amount amount
     */
    public static RGBAPixel[][] shrinkVertical(final RGBAPixel[][] originalImage, final int amount) {
    }
}