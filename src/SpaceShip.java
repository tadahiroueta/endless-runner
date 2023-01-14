import java.util.*;

public class SpaceShip extends ImageGamePiece {
    private int timer;

    public SpaceShip(int centerX, int centerY, int height, int width, String picture) {
        super(centerX, centerY, height, width, picture);
        this.timer = 30;
    }

    public void keepTime() {
        this.timer++;
    }

    public void powerJump(ArrayList<SpaceJunk> blocks) {
        final int timerThreshold = 30;
        if (this.timer >= timerThreshold) {
            int x = (int) StdDraw.mouseX();
            int y = (int) StdDraw.mouseY();

            super.setX(x);
            super.setY(y);

            this.timer = 0;
            for (SpaceJunk each: blocks) {
                each.destroy(x, y);
            }
        }
    }
}
