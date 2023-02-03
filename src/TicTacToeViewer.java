import javax.swing.*;
import java.awt.*;

public class TicTacToeViewer extends JFrame {
    // TODO: Complete this class
    private Image aquariumImage;
    private Image[] gameIcons;
    private final int WINDOW_WIDTH = 1000;
    private final int WINDOW_HEIGHT = 1000;
    private TicTacToe t;

    public TicTacToeViewer(TicTacToe t) {
        this.t = t;
        //Array of images is for efficiency purposes, so each square doesn't need a copy of the same images
        gameIcons = new Image[2];
        gameIcons[0] = new ImageIcon("Resources/X.png").getImage();
        gameIcons[1] = new ImageIcon("Resources/O.png").getImage();

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("The Board");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);
    }

    public Image[] getImages() {
        return gameIcons;
    }

    public TicTacToe getT() {
        return t;
    }

    public void paint(Graphics g) {
        // TODO: Write the paint method.
        //creating white background
        g.setColor(Color.white);
        g.fillRect(0, 0, 1000, 1000);
        //calls draw on each square in the grid
        for (int i = 0; i < t.getBoard().length; i++) {
            for (int j = 0; j < t.getBoard()[0].length; j++) {
                t.getBoard()[i][j].draw(g, this);
            }
        }
    }
}

