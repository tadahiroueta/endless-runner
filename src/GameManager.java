import java.awt.*;
import java.util.*;

public class GameManager {
    private final SpaceShip hero;
    private boolean runGame;
    private ArrayList<SpaceJunk> blocks;
    private final int sizeFactor;

    public GameManager() {
        this.runGame = true;
        sizeFactor = 2;

        // here's the game screen
        StdDraw.setCanvasSize(500, 500);
        StdDraw.setXscale(0, 500);
        StdDraw.setYscale(0, 500);

        this.hero = new SpaceShip(
                250, 250, 15, 15, "Ship1.gif"
        );
        int x = 0;
        int y = 400;
        this.blocks = new ArrayList<SpaceJunk>();
        for (int i = 0; i < 3; i++) {
            this.blocks.add(new SpaceJunk(
                    25 + x,
                    y,
                    15,
                    200,
                    "SpaceJunk.gif"
            ));
            this.blocks.add(new SpaceJunk(
                    475 + x,
                    y,
                    15,
                    200,
                    "SpaceJunk.gif"
            ));
            x = (int) (Math.random() * 300 - 150);
            y += 200;
        }
    }

    public void run() {
        while(this.runGame) {
            StdDraw.clear();
            this.hero.keepTime();

            // up
            if (StdDraw.isKeyPressed(87) || StdDraw.isKeyPressed(38)) {
                this.hero.moveY(10);
            }

            // left
            if (StdDraw.isKeyPressed(65) || StdDraw.isKeyPressed(37)) {
                this.hero.moveX(-10);
            }

            // down
            if (StdDraw.isKeyPressed(83) || StdDraw.isKeyPressed(40)) {
                this.hero.moveY(-10);
            }

            // right
            if (StdDraw.isKeyPressed(68) || StdDraw.isKeyPressed(39)) {
                this.hero.moveX(10);
            }

            // mouse click
            if (StdDraw.isMousePressed()) {
                this.hero.powerJump(this.blocks);
            }

            drawGamePieces();
            collision();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void drawGamePieces() {
        this.hero.drawPiece();
        for(GamePiece block : this.blocks) {
            block.drawPiece();
            block.moveY(-8);
        }
        for (int i = 0; i < 6; i += 2) {
            if(this.blocks.get(i + 1).returnY() < 0) {
                int x = (int) (Math.random() * 300 - 150);
                int y = (int) (Math.random() * 200 + 500);
                this.blocks.get(i).setY(y);
                this.blocks.get(i + 1).setY(y);
                this.blocks.get(i).moveX(x);
                this.blocks.get(i + 1).moveX(x);
            }
        }
    }
    
    public void collision() {
        for (SpaceJunk eachBlock : this.blocks) {
            if (
                    this.hero.getLowerBound() < eachBlock.getUpperBound() &&
                    this.hero.getUpperBound() > eachBlock.getLowerBound() &&
                    this.hero.getLeftBound() < eachBlock.getRightBound() &&
                    this.hero.getRightBound() > eachBlock.getLeftBound() &&

                    !eachBlock.getIsDestroyed()
            ) { this.runGame = false; }
        }
    }
}
