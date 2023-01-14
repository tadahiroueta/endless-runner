public class SpaceJunk extends ImageGamePiece {
    private boolean isDestroyed;

    public SpaceJunk(int centerX, int centerY, int height, int width, String picture) {
        super(centerX, centerY, height, width, picture);
        this.isDestroyed = false;
    }

    public void drawPiece() {
        if (!this.isDestroyed) { super.drawPiece(); }
        if (super.returnY() < 0) { isDestroyed = false; }
    }

    public void destroy(int x, int y) {
        if (
                x < super.getRightBound() &&
                x > super.getLeftBound() &&
                y < super.getUpperBound() &&
                y > super.getLowerBound()
        ) { this.isDestroyed = true; }
    }

    public boolean getIsDestroyed() {
        return isDestroyed;
    }
}
