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
     * default resize amount.
     */
    static int DEFAULT_RESIZE_AMOUNT;
    /**
     * default constructor.
     */
    public Transform() {
    }
    /**
     * expand horizontal.
     * @param originalImage original image
     * @param amount amount
     * @return copy
     */
    public static RGBAPixel[][] expandHorizontal(final RGBAPixel[][] originalImage,
                                                 final int amount) {
        RGBAPixel[][] copy = new RGBAPixel[originalImage.length][originalImage[0].length];
        int width = originalImage[0].length;
        int start = width / 2;
        /**
         * left half
         */
        for (int i = width / 2; i >= 0; i--) {
            for (int j = 0; j < originalImage.length; j++) {
                for (int k = 0; k < amount; k++) {
                    copy[j][start - k] = originalImage[j][i];
                }
            }
            start = start - amount;
            if (start < 0) {
                break;
            }
        }
        /**
         * right half
         */
        int even = 0;
        if (width % 2 == 0) {
            even = 1;
        }
        for (int i = width / 2 - even; i < width; i++) {
            for (int j = 0; j < originalImage.length; j++) {
                for (int k = 0; k < amount; k++) {
                    copy[j][start + k] = originalImage[j][i];
                }
            }
            start = start + amount;
            if (start > width - 1) {
                break;
            }
        }
        return copy;
    }
    /**
     * expand vertical.
     * @param originalImage original image
     * @param amount amount
     * @return copy
     */
    public static RGBAPixel[][] expandVertical(final RGBAPixel[][] originalImage,
                                               final int amount) {
        RGBAPixel[][] copy = new RGBAPixel[originalImage.length][originalImage[0].length];
        int height = originalImage.length;
        int start = height / 2;
        /**
         * top half
         */
        for (int i = height / 2; i >= 0; i--) {
            for (int j = 0; j < originalImage[i].length; j++) {
                for (int k = 0; k < amount; k++) {
                    copy[start - k][j] = originalImage[i][j];
                }
            }
            start = start - amount;
            if (start < 0) {
                break;
            }
        }
        /**
         * bottom half
         */
        int even = 0;
        if (height % 2 == 0) {
            even = 1;
        }
        for (int i = height / 2 - even; i < height; i++) {
            for (int j = 0; j < originalImage[i].length; j++) {
                for (int k = 0; k < amount; k++) {
                    copy[start + k][j] = originalImage[i][j];
                }
            }
            start = start + amount;
            if (start > height - 1) {
                break;
            }
        }
        return copy;
    }
    /**
     * flip horizontal.
     * @param originalImage original image
     * @return copy
     */
    public static RGBAPixel[][] flipHorizontal(final RGBAPixel[][] originalImage) {
        RGBAPixel[][] copy = new RGBAPixel[originalImage.length][originalImage[0].length];
        int width = originalImage[0].length;
        for (int i = 0; i < originalImage.length; i++) {
            for (int j = 0; j < originalImage[i].length; j++) {
                copy[width - i - 1][j] = originalImage[i][j];
            }
        }
        return copy;
    }
    /**
     * flip vertical.
     * @param originalImage original image
     * @return copy
     */
    public static RGBAPixel[][] flipVertical(final RGBAPixel[][] originalImage) {
        RGBAPixel[][] copy = new RGBAPixel[originalImage.length][originalImage[0].length];
        int height = originalImage.length;
        for (int i = 0; i < originalImage.length; i++) {
            for (int j = 0; j < originalImage[i].length; j++) {
                copy[i][height - j - 1] = originalImage[i][j];
            }
        }
        return copy;
    }
    /**
     * green screen.
     * @param originalImage original image
     * @return copy
     */
    public static RGBAPixel[][] greenScreen(final RGBAPixel[][] originalImage) {
        RGBAPixel[][] copy = new RGBAPixel[originalImage.length][originalImage[0].length];
        for (int i = 0; i < originalImage.length; i++) {
            for (int j = 0; j < originalImage[i].length; j++) {
                if (originalImage[i][j].getGreen() > originalImage[i][j].getRed()
                        && originalImage[i][j].getGreen() > originalImage[i][j].getBlue()
                        && originalImage[i][j].getGreen() > originalImage[i][j].getAlpha()) {
                    copy[i][j] = RGBAPixel.getFillValue();
                } else {
                    copy[i][j] = originalImage[i][j];
                }
            }
        }
        return copy;
    }
    /**
     * less alpha.
     * @param originalImage original image
     * @param amount amount
     * @return copy
     */
    public static RGBAPixel[][] lessAlpha(final RGBAPixel[][] originalImage, final int amount) {
    }
    /**
     * less blue.
     * @param originalImage original image
     * @param amount amount
     * @return copy
     */
    public static RGBAPixel[][] lessBlue(final RGBAPixel[][] originalImage, final int amount) {
    }
    /**
     * less green.
     * @param originalImage original image
     * @param amount amount
     * @return copy
     */
    public static RGBAPixel[][] lessGreen(final RGBAPixel[][] originalImage, final int amount) {
    }
    /**
     * less red.
     * @param originalImage original image
     * @param amount amount
     * @return copy
     */
    public static RGBAPixel[][] lessRed(final RGBAPixel[][] originalImage, final int amount) {
    }
    /**
     * more alpha.
     * @param originalImage original image
     * @param amount amount
     * @return copy
     */
    public static RGBAPixel[][] moreAlpha(final RGBAPixel[][] originalImage, final int amount) {
    }
    /**
     * more blue.
     * @param originalImage original image
     * @param amount amount
     * @return copy
     */
    public static RGBAPixel[][] moreBlue(final RGBAPixel[][] originalImage, final int amount) {
    }
    /**
     * more green.
     * @param originalImage original image
     * @param amount amount
     * @return copy
     */
    public static RGBAPixel[][] moreGreen(final RGBAPixel[][] originalImage, final int amount) {
    }
    /**
     * more red.
     * @param originalImage original image
     * @param amount amount
     * @return copy
     */
    public static RGBAPixel[][] moreRed(final RGBAPixel[][] originalImage, final int amount) {
    }
    /**
     * mystery.
     * @param originalImage original image
     * @return copy
     */
    public static RGBAPixel[][] mystery(final RGBAPixel[][] originalImage) {
    }
    /**
     * rotate left.
     * @param originalImage original image
     * @return copy
     */
    public static RGBAPixel[][] rotateLeft(final RGBAPixel[][] originalImage) {
    }
    /**
     * rotate right.
     * @param originalImage original image
     * @return copy
     */
    public static RGBAPixel[][] rotateRight(final RGBAPixel[][] originalImage) {
    }
    /**
     * shift down.
     * @param originalImage original image
     * @param amount amount
     * @return copy
     */
    public static RGBAPixel[][] shiftDown(final RGBAPixel[][] originalImage, final int amount) {
    }
    /**
     * shift left.
     * @param originalImage original image
     * @param amount amount
     * @return copy
     */
    public static RGBAPixel[][] shiftLeft(final RGBAPixel[][] originalImage, final int amount) {
    }
    /**
     * shift right.
     * @param originalImage original image
     * @param amount amount
     * @return copy
     */
    public static RGBAPixel[][] shiftRight(final RGBAPixel[][] originalImage, final int amount) {
    }
    /**
     * shift up.
     * @param originalImage original image
     * @param amount amount
     * @return copy
     */
    public static RGBAPixel[][] shiftUp(final RGBAPixel[][] originalImage, final int amount) {
    }
    /**
     * shrink horizontal.
     * @param originalImage original image
     * @param amount amount
     * @return copy
     */
    public static RGBAPixel[][] shrinkHorizontal(final RGBAPixel[][] originalImage,
                                                 final int amount) {
    }
    /**
     * shrink vertical.
     * @param originalImage original image
     * @param amount amount
     * @return copy
     */
    public static RGBAPixel[][] shrinkVertical(final RGBAPixel[][] originalImage,
                                               final int amount) {
    }
}