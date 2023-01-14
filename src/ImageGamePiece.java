public class ImageGamePiece extends GamePiece{
    private final String picture;
    private final double scaledHeight;
    private final double scaledWidth;

    public ImageGamePiece(int centerX, int centerY, int height, int width, String picture) {
        super(centerX, centerY, height, width, new int[] {0, 0, 0});
        final int scaleFactor = 2;
        this.scaledHeight = height * scaleFactor;
        this.scaledWidth = width * scaleFactor;
        this.picture = picture;
    }

    public void drawPiece() {
        StdDraw.picture(super.returnX(), super.returnY(), picture, scaledWidth, scaledHeight);
    }
}
