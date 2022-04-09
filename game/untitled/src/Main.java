import javax.swing.*;

public class Main extends JFrame {

    public static final int WINDOW_WIDTH = 1000;
    public static final int WINDOW_HEIGHT = 600;

    public static void main(String[] args) {
        new Main();
    }

    public Main () {
        GameScene gameScene = new GameScene(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
        this.add(gameScene);
//        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);
    }

}
