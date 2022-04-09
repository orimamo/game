import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class GameScene extends JPanel {

    private Robot player;
    private ArrayList<CustomRectangle> obstacles;
    private ImageIcon pj;

    public GameScene (int x, int y, int width, int height) {
        this.setBackground(Color.RED);
        this.setBounds(x, y, width, height);
        this.player = new Robot();
        this.obstacles = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 2; i++) {
            CustomRectangle obstacle = new CustomRectangle(
                    random.nextInt(width),
                    random.nextInt(height),
                    100,
                    100,
                    Color.GREEN);
            if (!this.player.checkCollision(obstacle)) {
                this.obstacles.add(obstacle);
            }
        }
        this.pj = new ImageIcon("pj.png");
        this.mainGameLoop();

    }

    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        graphics.setColor(Color.BLUE);
        this.player.paint(graphics);
        for (CustomRectangle obstacle : this.obstacles) {
            obstacle.paint(graphics);
        }
        this.pj.paintIcon(this, graphics, 0, 0);
    }

    public void mainGameLoop () {
        new Thread(() -> {
            this.setFocusable(true);
            this.requestFocus();
            PlayerController playerController = new PlayerController(this);
            this.addKeyListener(playerController);

            while (true) {
                repaint();
                try {
                    Random random = new Random();
                    for (CustomRectangle obstacle : this.obstacles) {
                        int direction = random.nextInt(3);
                        if (direction == 0) {
                            obstacle.moveUp();
                        } else if (direction == 1) {
                            obstacle.moveDown();
                        } else if (direction == 2) {
                            obstacle.moveLeft();
                        } else if (direction == 3) {
                            obstacle.moveRight();
                        }
                        if (this.player.checkCollision(obstacle)) {
                            this.player.kill();
                        }
                    }
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public Robot getPlayer () {
        return this.player;
    }


}
