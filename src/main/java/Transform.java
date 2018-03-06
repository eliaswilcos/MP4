
/**
 * Transform Class.
 */
public class Transform {
    /**
     * default color shift.
     */
    static final int DEFAULT_COLOR_SHIFT = 1;
    /**
     * default position shift.
     */
    static final int DEFAULT_POSITION_SHIFT = 1;
    /**
     * default resize amount.
     */
    static final int DEFAULT_RESIZE_AMOUNT = 1;
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
        if (amount == 0) {
            return null;
        }
        RGBAPixel[][] copy = new RGBAPixel[originalImage.length][originalImage[0].length];
        int width = originalImage[0].length;
        int start = width / 2;
        /**
         * left half
         */
        for (int i = width / 2; i >= 0; i--) {
            for (int j = 0; j < originalImage.length; j++) {
                for (int k = 0; k < amount; k++) {
                    if (k > start) {
                        break;
                    }
                    copy[j][start - k] = new RGBAPixel(originalImage[i][j]);
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
                    copy[j][start + k] = new RGBAPixel(originalImage[i][j]);
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
        if (amount == 0) {
            return null;
        }
        RGBAPixel[][] copy = new RGBAPixel[originalImage.length][originalImage[0].length];
        int height = originalImage.length;
        int start = height / 2;
        /**
         * top half
         */
        for (int i = height / 2; i >= 0; i--) {
            for (int j = 0; j < originalImage[i].length; j++) {
                for (int k = 0; k < amount; k++) {
                    if (k > start) {
                        break;
                    }
                    copy[start - k][j] = new RGBAPixel(originalImage[i][j]);
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
                    copy[start + k][j] = new RGBAPixel(originalImage[i][j]);
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
                copy[width - i - 1][j] = new RGBAPixel(originalImage[i][j]);
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
                copy[i][height - j - 1] = new RGBAPixel(originalImage[i][j]);
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
                if (originalImage[i][j].getGreen() > RGBAPixel.MAX_CHANNEL_VALUE / 2) {
                    copy[i][j] = RGBAPixel.getFillValue();
                } else {
                    copy[i][j] = new RGBAPixel(originalImage[i][j]);
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
        RGBAPixel[][] copy = new RGBAPixel[originalImage.length][originalImage[0].length];
        for (int i = 0; i < originalImage.length; i++) {
            for (int j = 0; j < originalImage[i].length; j++) {
                copy[i][j] = new RGBAPixel(originalImage[i][j]);
                if (amount < copy[i][j].getAlpha()) {
                    copy[i][j].setAlpha(copy[i][j].getAlpha() - amount);
                } else {
                    copy[i][j].setAlpha(0);
                }
            }
        }
        return copy;
    }
    /**
     * less blue.
     * @param originalImage original image
     * @param amount amount
     * @return copy
     */
    public static RGBAPixel[][] lessBlue(final RGBAPixel[][] originalImage, final int amount) {
        RGBAPixel[][] copy = new RGBAPixel[originalImage.length][originalImage[0].length];
        for (int i = 0; i < originalImage.length; i++) {
            for (int j = 0; j < originalImage[i].length; j++) {
                copy[i][j] = new RGBAPixel(originalImage[i][j]);
                if (amount < copy[i][j].getBlue()) {
                    copy[i][j].setBlue(copy[i][j].getBlue() - amount);
                } else {
                    copy[i][j].setBlue(0);
                }
            }
        }
        return copy;
    }
    /**
     * less green.
     * @param originalImage original image
     * @param amount amount
     * @return copy
     */
    public static RGBAPixel[][] lessGreen(final RGBAPixel[][] originalImage, final int amount) {
        RGBAPixel[][] copy = new RGBAPixel[originalImage.length][originalImage[0].length];
        for (int i = 0; i < originalImage.length; i++) {
            for (int j = 0; j < originalImage[i].length; j++) {
                copy[i][j] = new RGBAPixel(originalImage[i][j]);
                if (amount < copy[i][j].getGreen()) {
                    copy[i][j].setGreen(copy[i][j].getGreen() - amount);
                } else {
                    copy[i][j].setGreen(0);
                }
            }
        }
        return copy;
    }
    /**
     * less red.
     * @param originalImage original image
     * @param amount amount
     * @return copy
     */
    public static RGBAPixel[][] lessRed(final RGBAPixel[][] originalImage, final int amount) {
        RGBAPixel[][] copy = new RGBAPixel[originalImage.length][originalImage[0].length];
        for (int i = 0; i < originalImage.length; i++) {
            for (int j = 0; j < originalImage[i].length; j++) {
                copy[i][j] = new RGBAPixel(originalImage[i][j]);
                if (amount < copy[i][j].getRed()) {
                    copy[i][j].setRed(copy[i][j].getRed() - amount);
                } else {
                    copy[i][j].setRed(0);
                }
            }
        }
        return copy;
    }
    /**
     * more alpha.
     * @param originalImage original image
     * @param amount amount
     * @return copy
     */
    public static RGBAPixel[][] moreAlpha(final RGBAPixel[][] originalImage, final int amount) {
        RGBAPixel[][] copy = new RGBAPixel[originalImage.length][originalImage[0].length];
        for (int i = 0; i < originalImage.length; i++) {
            for (int j = 0; j < originalImage[i].length; j++) {
                copy[i][j] = new RGBAPixel(originalImage[i][j]);
                if (amount + copy[i][j].getAlpha() >= RGBAPixel.MAX_CHANNEL_VALUE) {
                    copy[i][j].setAlpha(RGBAPixel.MAX_CHANNEL_VALUE);
                } else {
                    copy[i][j].setAlpha(copy[i][j].getAlpha() + amount);
                }
            }
        }
        return copy;
    }
    /**
     * more blue.
     * @param originalImage original image
     * @param amount amount
     * @return copy
     */
    public static RGBAPixel[][] moreBlue(final RGBAPixel[][] originalImage, final int amount) {
        RGBAPixel[][] copy = new RGBAPixel[originalImage.length][originalImage[0].length];
        for (int i = 0; i < originalImage.length; i++) {
            for (int j = 0; j < originalImage[i].length; j++) {
                copy[i][j] = new RGBAPixel(originalImage[i][j]);
                if (amount + copy[i][j].getBlue() >= RGBAPixel.MAX_CHANNEL_VALUE) {
                    copy[i][j].setBlue(RGBAPixel.MAX_CHANNEL_VALUE);
                } else {
                    copy[i][j].setBlue(copy[i][j].getBlue() + amount);
                }
            }
        }
        return copy;
    }
    /**
     * more green.
     * @param originalImage original image
     * @param amount amount
     * @return copy
     */
    public static RGBAPixel[][] moreGreen(final RGBAPixel[][] originalImage, final int amount) {
        RGBAPixel[][] copy = new RGBAPixel[originalImage.length][originalImage[0].length];
        for (int i = 0; i < originalImage.length; i++) {
            for (int j = 0; j < originalImage[i].length; j++) {
                copy[i][j] = new RGBAPixel(originalImage[i][j]);
                if (amount + copy[i][j].getGreen() >= RGBAPixel.MAX_CHANNEL_VALUE) {
                    copy[i][j].setGreen(RGBAPixel.MAX_CHANNEL_VALUE);
                } else {
                    copy[i][j].setGreen(copy[i][j].getGreen() + amount);
                }
            }
        }
        return copy;
    }
    /**
     * more red.
     * @param originalImage original image
     * @param amount amount
     * @return copy
     */
    public static RGBAPixel[][] moreRed(final RGBAPixel[][] originalImage, final int amount) {
        RGBAPixel[][] copy = new RGBAPixel[originalImage.length][originalImage[0].length];
        for (int i = 0; i < originalImage.length; i++) {
            for (int j = 0; j < originalImage[i].length; j++) {
                copy[i][j] = new RGBAPixel(originalImage[i][j]);
                if (amount + copy[i][j].getRed() >= RGBAPixel.MAX_CHANNEL_VALUE) {
                    copy[i][j].setRed(RGBAPixel.MAX_CHANNEL_VALUE);
                } else {
                    copy[i][j].setRed(copy[i][j].getRed() + amount);
                }
            }
        }
        return copy;
    }
    /**
     * mystery.
     * @param originalImage original image
     * @return copy
     */
    public static RGBAPixel[][] mystery(final RGBAPixel[][] originalImage) {
        return null;
    }
    /**
     * rotate left.
     * @param originalImage original image
     * @return copy
     */
    public static RGBAPixel[][] rotateLeft(final RGBAPixel[][] originalImage) {
        RGBAPixel[][] copy = new RGBAPixel[originalImage.length][originalImage[0].length];
        int squareW;
        if (originalImage.length > originalImage[0].length) {
            int k = 0;
            int large = originalImage.length;
            squareW = originalImage[0].length;
            for (int i = (large - squareW) / 2; i < (large - squareW) / 2 + squareW; i++) {
                for (int j = 0; j < originalImage[i].length; j++) {
                    copy[(large - squareW) / 2 + squareW - 1 - j][k]
                            = new RGBAPixel(originalImage[i][j]);
                }
                k++;
            }
        } else {
            int k = originalImage.length - 1;
            int large = originalImage[0].length;
            squareW = originalImage.length;
            for (int i = (large - squareW) / 2; i < (large - squareW) / 2 + squareW; i++) {
                for (int j = 0; j < originalImage[i].length; j++) {
                    copy[k][(large - squareW) / 2 + squareW - 1 - j]
                            = new RGBAPixel(originalImage[i][j]);
                }
                k--;
            }
        }
        return copy;
    }
    /**
     * rotate right.
     * @param originalImage original image
     * @return copy
     */
    public static RGBAPixel[][] rotateRight(final RGBAPixel[][] originalImage) {
        RGBAPixel[][] copy = new RGBAPixel[originalImage.length][originalImage[0].length];
        int squareW;
        if (originalImage.length > originalImage[0].length) {
            int k = originalImage.length - 1;
            int large = originalImage.length;
            squareW = originalImage[0].length;
            for (int i = (large - squareW) / 2; i < (large - squareW) / 2 + squareW; i++) {
                for (int j = 0; j < originalImage[i].length; j++) {
                    copy[(large - squareW) / 2 + squareW - 1 - j][k]
                            = new RGBAPixel(originalImage[i][j]);
                }
                k--;
            }
        } else {
            int k = 0;
            int large = originalImage[0].length;
            squareW = originalImage.length;
            for (int i = (large - squareW) / 2; i < (large - squareW) / 2 + squareW; i++) {
                for (int j = 0; j < originalImage[i].length; j++) {
                    copy[k][(large - squareW) / 2 + squareW - 1 - j]
                            = new RGBAPixel(originalImage[i][j]);
                }
                k++;
            }
        }
        return copy;
    }
    /**
     * shift down.
     * @param originalImage original image
     * @param amount amount
     * @return copy
     */
    public static RGBAPixel[][] shiftDown(final RGBAPixel[][] originalImage, final int amount) {
        RGBAPixel[][] copy = new RGBAPixel[originalImage.length][originalImage[0].length];
        if (amount >= originalImage[0].length) {
            for (int i = 0; i < originalImage.length; i++) {
                for (int j = 0; j < originalImage[i].length; j++) {
                    copy[i][j] = RGBAPixel.getFillValue();
                }
            }
            return copy;
        }
        for (int i = 0; i < originalImage.length; i++) {
            for (int j = 0; j < originalImage[i].length - amount; j++) {
                copy[i][j + amount] = new RGBAPixel(originalImage[i][j]);
            }
        }
        for (int i = 0; i < originalImage.length; i++) {
            if (amount == 0) {
                break;
            }
            for (int j = 0; j < amount; j++) {
                copy[i][j] = RGBAPixel.getFillValue();
            }
        }
        return copy;
    }
    /**
     * shift left.
     * @param originalImage original image
     * @param amount amount
     * @return copy
     */
    public static RGBAPixel[][] shiftLeft(final RGBAPixel[][] originalImage, final int amount) {
        RGBAPixel[][] copy = new RGBAPixel[originalImage.length][originalImage[0].length];
        if (amount >= originalImage.length) {
            for (int i = 0; i < originalImage.length; i++) {
                for (int j = 0; j < originalImage[i].length; j++) {
                    copy[i][j] = RGBAPixel.getFillValue();
                }
            }
            return copy;
        }
        for (int i = amount; i < originalImage.length; i++) {
            for (int j = 0; j < originalImage[i].length; j++) {
                copy[i - amount][j] = new RGBAPixel(originalImage[i][j]);
            }
        }
        for (int i = originalImage.length - amount; i < originalImage.length; i++) {
            if (amount == 0) {
                break;
            }
            for (int j = 0; j < originalImage[i].length; j++) {
                copy[i][j] = RGBAPixel.getFillValue();
            }
        }
        return copy;
    }
    /**
     * shift right.
     * @param originalImage original image
     * @param amount amount
     * @return copy
     */
    public static RGBAPixel[][] shiftRight(final RGBAPixel[][] originalImage, final int amount) {
        RGBAPixel[][] copy = new RGBAPixel[originalImage.length][originalImage[0].length];
        if (amount >= originalImage.length) {
            for (int i = 0; i < originalImage.length; i++) {
                for (int j = 0; j < originalImage[i].length; j++) {
                    copy[i][j] = RGBAPixel.getFillValue();
                }
            }
            return copy;
        }
        for (int i = 0; i < originalImage.length - amount; i++) {
            for (int j = 0; j < originalImage[i].length; j++) {
                copy[i + amount][j] = new RGBAPixel(originalImage[i][j]);
            }
        }
        for (int i = 0; i < amount; i++) {
            if (amount == 0) {
                break;
            }
            for (int j = 0; j < originalImage[i].length; j++) {
                copy[i][j] = RGBAPixel.getFillValue();
            }
        }
        return copy;
    }
    /**
     * shift up.
     * @param originalImage original image
     * @param amount amount
     * @return copy
     */
    public static RGBAPixel[][] shiftUp(final RGBAPixel[][] originalImage, final int amount) {
        RGBAPixel[][] copy = new RGBAPixel[originalImage.length][originalImage[0].length];
        if (amount >= originalImage[0].length) {
            for (int i = 0; i < originalImage.length; i++) {
                for (int j = 0; j < originalImage[i].length; j++) {
                    copy[i][j] = RGBAPixel.getFillValue();
                }
            }
            return copy;
        }
        for (int i = 0; i < originalImage.length; i++) {
            for (int j = amount; j < originalImage[i].length; j++) {
                copy[i][j - amount] = new RGBAPixel(originalImage[i][j]);
            }
        }
        for (int i = 0; i < originalImage.length; i++) {
            if (amount == 0) {
                break;
            }
            for (int j = originalImage[i].length - amount; j < originalImage[i].length; j++) {
                copy[i][j] = RGBAPixel.getFillValue();
            }
        }
        return copy;
    }
    /**
     * shrink horizontal.
     * @param originalImage original image
     * @param amount amount
     * @return copy
     */
    public static RGBAPixel[][] shrinkHorizontal(final RGBAPixel[][] originalImage,
                                                 final int amount) {
        return null;
    }
    /**
     * shrink vertical.
     * @param originalImage original image
     * @param amount amount
     * @return copy
     */
    public static RGBAPixel[][] shrinkVertical(final RGBAPixel[][] originalImage,
                                               final int amount) {
        return null;
    }
}
