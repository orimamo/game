import java.awt.*;

public class Robot {
    private CustomRectangle head;
    private CustomRectangle neck;
    private CustomRectangle body;
    private boolean alive;

    public Robot () {
        this.head = new CustomRectangle(100, 80, 80, 80, Color.BLUE);
        int neckWidth = this.head.getWidth() / 3;
        int neckX = ((this.head.getWidth() - neckWidth) / 2) + this.head.getX();
        this.neck = new CustomRectangle(neckX, this.head.getBottom(), neckWidth, neckWidth, Color.CYAN);
        int bodyWidth = this.head.getWidth() * 2;
        int bodyX = this.head.getX() + (this.head.getWidth() / 2) - (bodyWidth / 2);
        this.body = new CustomRectangle(bodyX, this.neck.getBottom(), bodyWidth, bodyWidth, Color.BLACK);
        this.alive = true;
    }

    public void paint (Graphics graphics) {
        if (this.alive) {
            this.head.paint(graphics);
            this.neck.paint(graphics);
            this.body.paint(graphics);
        }
    }

    public void moveRight () {
        this.head.moveRight();
        this.neck.moveRight();
        this.body.moveRight();
    }

    public void moveLeft () {
        this.head.moveLeft();
        this.neck.moveLeft();
        this.body.moveLeft();
    }

    public void moveUp () {
        this.head.moveUp();
        this.neck.moveUp();
        this.body.moveUp();
    }

    public void moveDown () {
        this.head.moveDown();
        this.neck.moveDown();
        this.body.moveDown();
    }

    public boolean checkCollision (CustomRectangle obstacle) {
        boolean collision = false;
        Rectangle bodyRect = new Rectangle(
                this.body.getX(),
                this.body.getY(),
                this.body.getWidth(),
                this.body.getHeight()
        );
        Rectangle obstacleRect = new Rectangle(
                obstacle.getX(),
                obstacle.getY(),
                obstacle.getWidth(),
                obstacle.getHeight()
        );
        if (bodyRect.intersects(obstacleRect)) {
            collision = true;
        }
        return collision;
    }


    public void kill () {
        this.alive = false;
    }



}
