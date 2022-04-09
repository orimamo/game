import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PlayerController implements KeyListener {

    private GameScene gameScene;

    public PlayerController (GameScene gameScene) {
        this.gameScene = gameScene;
    }

    public void keyTyped(KeyEvent keyEvent) {

    }

    public void keyReleased(KeyEvent keyEvent) {

    }

    public void keyPressed(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_RIGHT:
                this.gameScene.getPlayer().moveRight();
                break;
            case KeyEvent.VK_LEFT:
                this.gameScene.getPlayer().moveLeft();
                break;
            case KeyEvent.VK_UP:
                this.gameScene.getPlayer().moveUp();
                break;
            case KeyEvent.VK_DOWN:
                this.gameScene.getPlayer().moveDown();
                break;

        }
    }
}
