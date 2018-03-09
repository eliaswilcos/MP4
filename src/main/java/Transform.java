
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
    static final int DEFAULT_RESIZE_AMOUNT = 2;
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
        RGBAPixel[][] temp = new RGBAPixel[originalImage.length * amount][originalImage[0].length];
        RGBAPixel[][] copy = new RGBAPixel[originalImage.length][originalImage[0].length];
        int width = originalImage.length;
        int height = originalImage[0].length;
        int tempWidth = amount * width;
        for (int i = 0; i < height; i++) {
            int start = 0;
            for (int j = 0; j < width; j++) {
                for (int k = 0; k < amount; k++) {
                    temp[start][i] = new RGBAPixel(originalImage[j][i]);
                    start++;
                }
            }
        }
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                copy[i][j] = new RGBAPixel(temp[i + ((tempWidth - width) / 2)][j]);
            }
        }
        return copy;
        /*
        if (amount == 0) {
            return null;
        }
        RGBAPixel[][] copy = new RGBAPixel[originalImage.length][originalImage[0].length];
        for (int i = 0; i < originalImage.length; i++) {
            for (int j = 0; j < originalImage[i].length; j++) {
                copy[i][j] = RGBAPixel.getFillValue();
            }
        }
        int width = originalImage.length;
        int start = width / 2 - 1;
        for (int i = start; i >= 0; i--) {
            for (int j = 0; j < originalImage[0].length; j++) {
                for (int k = 0; k < amount; k++) {
                    if (k > start) {
                        break;
                    }
                    copy[i][start - k] = new RGBAPixel(originalImage[i][j]);
                }
            }
        }
        *//**
         * right half
         *//*
        start = width / 2;
        for (int i = start; i < width; i++) {
            for (int j = 0; j < originalImage[0].length; i++) {
                for (int k = 0; k < amount; k++) {
                    if (originalImage[0].length <= start + k) {
                        break;
                    }
                    copy[i][start + k] = new RGBAPixel(originalImage[i][j]);
                }
            }
        }
        return copy;*/
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
        RGBAPixel[][] temp = new RGBAPixel[originalImage.length][originalImage[0].length * amount];
        RGBAPixel[][] copy = new RGBAPixel[originalImage.length][originalImage[0].length];
        int width = originalImage.length;
        int height = originalImage[0].length;
        int tempHeight = amount * height;
        for (int i = 0; i < width; i++) {
            int start = 0;
            for (int j = 0; j < height; j++) {
                for (int k = 0; k < amount; k++) {
                    temp[i][start] = new RGBAPixel(originalImage[i][j]);
                    start++;
                }
            }
        }
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                copy[i][j] = new RGBAPixel(temp[i][j + ((tempHeight - height) / 2)]);
            }
        }
        return copy;
        /*if (amount == 0) {
            return null;
        }
        RGBAPixel[][] temp = new RGBAPixel[originalImage.length][amount * originalImage[0].length];
        RGBAPixel[][] copy = new RGBAPixel[originalImage.length][originalImage[0].length];
        for (int i = 0; i < originalImage.length; i++) {
            for (int j = 0; j < originalImage[i].length; j++) {
                copy[i][j] = RGBAPixel.getFillValue();
            }
        }
        int height = originalImage[0].length;
        int start = height / 2 - 1;
        *//**
         * top half
         *//*
        for (int i = 0; i < originalImage.length; i++) {
            for (int j = height / 2 - 1; j >= 0; j--) {
                for (int k = 0; k < amount; k++) {
                    if (start - k < 0) {
                        break;
                    }
                    copy[start - k][j] = new RGBAPixel(originalImage[i][j]);
                }
            }
        }
        *//**
         * bottom half
         *//*
        start = height / 2;
        for (int i = 0; i < originalImage.length; i++) {
            for (int j = height / 2; j < height; j++) {
                for (int k = 0; k < amount; k++) {
                    if (start + k >= originalImage.length) {
                        break;
                    }
                    copy[start + k][j] = new RGBAPixel(originalImage[i][j]);
                }
            }
        }
        return copy;*/
    }
    /**
     * flip diagonal.
     * @param originalImage original image
     * @return copy
     */
    public static RGBAPixel[][] flipDiagonal(final RGBAPixel[][] originalImage) {
        int limit = originalImage.length;
        if (originalImage.length > originalImage[0].length) {
            RGBAPixel[][] copy = new RGBAPixel[limit][limit];
            limit = originalImage[0].length;
            for (int i = (originalImage.length - limit) / 2;
                 i < (originalImage.length - limit) / 2 + limit; i++) {
                for (int j = 0; j < limit; j++) {
                    copy[j][i - (originalImage.length - limit) / 2] =
                            new RGBAPixel(originalImage[i][j]);
                }
            }
            return copy;
        } else if (originalImage.length == limit) {
            RGBAPixel[][] copy = new RGBAPixel[limit][limit];
            for (int i = (originalImage[0].length - limit) / 2;
                 i < (originalImage[0].length - limit) / 2 + limit; i++) {
                for (int j = 0; j < limit; j++) {
                    copy[i - (originalImage[0].length - limit) / 2][j] =
                            new RGBAPixel(originalImage[j][i]);
                }
            }
            return copy;
        }
        RGBAPixel[][] copy = new RGBAPixel[limit][limit];
        for (int i = 0; i < limit; i++) {
            for (int j = 0; j < limit; j++) {
                copy[j][i] = new RGBAPixel(originalImage[i][j]);
            }
        }
        return copy;
    }
    /**
     * flip horizontal.
     * @param originalImage original image
     * @return copy
     */
    public static RGBAPixel[][] flipVertical(final RGBAPixel[][] originalImage) {
        RGBAPixel[][] copy = new RGBAPixel[originalImage.length][originalImage[0].length];
        int height = originalImage[0].length;
        for (int i = 0; i < originalImage.length; i++) {
            for (int j = 0; j < originalImage[i].length; j++) {
                copy[i][height - j - 1] = new RGBAPixel(originalImage[i][j]);
            }
        }
        return copy;
    }
    /**
     * flip vertical.
     * @param originalImage original image
     * @return copy
     */
    public static RGBAPixel[][] flipHorizontal(final RGBAPixel[][] originalImage) {
        RGBAPixel[][] copy = new RGBAPixel[originalImage.length][originalImage[0].length];
        int width = originalImage.length;
        for (int i = 0; i < originalImage.length; i++) {
            for (int j = 0; j < originalImage[i].length; j++) {
                copy[width - i - 1][j] = new RGBAPixel(originalImage[i][j]);
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
        RGBAPixel[][] temp = flipDiagonal(originalImage);
        RGBAPixel[][] copy = new RGBAPixel[originalImage.length][originalImage[0].length];
        for (int i = 0; i < originalImage.length; i++) {
            for (int j = 0; j < originalImage[i].length; j++) {
                copy[i][j] = RGBAPixel.getFillValue();
            }
        }
        int limit = originalImage.length;
        if (originalImage.length > originalImage[0].length) {
            limit = originalImage[0].length;
            for (int i = (originalImage.length - limit) / 2;
                 i < (originalImage.length - limit) / 2 + limit; i++) {
                for (int j = 0; j < limit; j++) {
                    copy[i][j] = new RGBAPixel(temp[i - (originalImage.length - limit) / 2][j]);
                }
            }
        } else {
            limit = originalImage.length;
            for (int i = 0; i < limit; i++) {
                for (int j = (originalImage[0].length - limit) / 2;
                     j < (originalImage[0].length - limit) / 2 + limit; j++) {
                    copy[i][j] = new RGBAPixel(temp[i][j - (originalImage[0].length - limit) / 2]);
                }
            }
        }
        copy = flipVertical(copy);
        return copy;
    }
    /**
     * rotate right.
     * @param originalImage original image
     * @return copy
     */
    public static RGBAPixel[][] rotateRight(final RGBAPixel[][] originalImage) {
        RGBAPixel[][] temp = flipDiagonal(originalImage);
        RGBAPixel[][] copy = new RGBAPixel[originalImage.length][originalImage[0].length];
        for (int i = 0; i < originalImage.length; i++) {
            for (int j = 0; j < originalImage[i].length; j++) {
                copy[i][j] = RGBAPixel.getFillValue();
            }
        }
        int limit = originalImage.length;
        if (originalImage.length > originalImage[0].length) {
            limit = originalImage[0].length;
            for (int i = (originalImage.length - limit) / 2;
                 i < (originalImage.length - limit) / 2 + limit; i++) {
                for (int j = 0; j < limit; j++) {
                    copy[i][j] = new RGBAPixel(temp[i - (originalImage.length - limit) / 2][j]);
                }
            }
        } else {
            limit = originalImage.length;
            for (int i = 0; i < limit; i++) {
                for (int j = (originalImage[0].length - limit) / 2;
                     j < (originalImage[0].length - limit) / 2 + limit; j++) {
                    copy[i][j] = new RGBAPixel(temp[i][j - (originalImage[0].length - limit) / 2]);
                }
            }
        }
        copy = flipHorizontal(copy);
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
