public class GamePiece {
    private int centerX, centerY, height, width;
    private int[] color;

    public GamePiece(int centerX, int centerY, int height, int width, int[] color) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.height = height;
        this.width = width;
        this.color = color;
    }

    public int returnX() {
        return centerX;
    }

    public int returnY() {
        return centerY;
    }

    public void moveX(int changeInX) {
        this.centerX += changeInX;
    }

    public void moveY(int changeInY) {
        this.centerY += changeInY;
    }

    public void setX(int centerX) {
        this.centerX = centerX;
    }

    public void setY(int centerY) {
        this.centerY = centerY;
    }

    public void drawPiece() {
        StdDraw.setPenColor(color[0], color[1], color[2]);
        StdDraw.filledRectangle(centerX, centerY, width, height);
    }

    public int getUpperBound() {
        return centerY + height;
    }

    public int getLowerBound() {
        return centerY - height;
    }

    public int getRightBound() {
        return centerX + width;
    }

    public int getLeftBound() {
        return centerX - width;
    }
}
