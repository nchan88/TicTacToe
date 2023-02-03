import java.awt.*;

/**
 * A class written to support the TicTacToe Game.
 *
 * Each Square object is one position of the TicTacToe
 * board. It maintains information on the marker, its
 * location on the board, and whether it is part
 * of the winning set.
 *
 * @author: Nandhini Namasivayam
 * @version: Jan 2023
 */

public class Square {

    private String marker;
    private int row;
    private int col;
    private Image X_IMG, O_IMG;
    final private int SQUARE_DIM = 150;
    final private int MARGIN_LENGTH = 250;
    private boolean isWinningSquare;

    /**
     * Constructor to initialize one Square of the
     * TicTacToe board
     * @param row the row the square is in
     * @param col the column the square is in
     */
    public Square(int row, int col) {
        this.row = row;
        this.col = col;

        this.marker = TicTacToe.BLANK;
        this.isWinningSquare = false;
    }

    /******************** Getters and Setters ********************/
    public String getMarker() {
        return this.marker;
    }

    public void setMarker(String marker) {
        this.marker = marker;
    }

    public void setWinningSquare() {
        this.isWinningSquare = true;
    }

    /**
     * Checks if the square has the BLANK marker
     * @return True if the square is empty, False otherwise
     */
    public boolean isEmpty() {
        return this.marker.equals(TicTacToe.BLANK);
    }

    /**
     * @return the marker for the square
     */
    public String toString() {
        return this.marker;
    }

    public void draw(Graphics g, TicTacToeViewer t) {

        int ROW_POSITION = row * SQUARE_DIM + MARGIN_LENGTH;
        int COL_POSITION = col * SQUARE_DIM + MARGIN_LENGTH;

        g.setFont(new Font("Serif", Font.PLAIN, 50));
        g.setColor(Color.red);
        //prints out all the numbers on the sides of the grid
        g.drawString("0", MARGIN_LENGTH - 40, MARGIN_LENGTH + SQUARE_DIM / 2);
        g.drawString("1", MARGIN_LENGTH - 40, MARGIN_LENGTH + SQUARE_DIM / 2 + SQUARE_DIM);
        g.drawString("2", MARGIN_LENGTH - 40, MARGIN_LENGTH + SQUARE_DIM / 2 + SQUARE_DIM * 2);
        g.drawString("0", MARGIN_LENGTH + SQUARE_DIM / 2, MARGIN_LENGTH - 20);
        g.drawString("1", MARGIN_LENGTH + 3 * SQUARE_DIM / 2, MARGIN_LENGTH -20);
        g.drawString("2", MARGIN_LENGTH + 5 * SQUARE_DIM / 2, MARGIN_LENGTH - 20);

        //The viewer we pass in has a TicTacToe object in it, so we can use helpful methods like checkTie
        if(t.getT().checkTie())
        {
            g.setColor(Color.BLACK);
            g.setFont(new Font("Serif", Font.PLAIN, 50));
            g.drawString("It's a Tie!", MARGIN_LENGTH + 3 * SQUARE_DIM / 2 - 50, MARGIN_LENGTH + SQUARE_DIM * 6 / 2 + 50);
        }
        if(isWinningSquare)
        {
            //Prints a green background the same size as a square
            g.setColor(Color.GREEN);
            g.fillRect(col * SQUARE_DIM + MARGIN_LENGTH, row * SQUARE_DIM + MARGIN_LENGTH, SQUARE_DIM, SQUARE_DIM);
            g.setColor(Color.BLACK);
            g.setFont(new Font("Serif", Font.PLAIN, 50));
            g.drawString(this.marker + " Wins!", MARGIN_LENGTH + 3 * SQUARE_DIM / 2 - 50, MARGIN_LENGTH + SQUARE_DIM * 6 / 2 + 50);
        }
        g.setColor(Color.black);
        g.drawRect(row * SQUARE_DIM + MARGIN_LENGTH, col * SQUARE_DIM + MARGIN_LENGTH, SQUARE_DIM, SQUARE_DIM);
        //Prints marker's corresponding image
        if (this.marker.equals("X"))
        {
            g.drawImage(t.getImages()[0], COL_POSITION, ROW_POSITION, SQUARE_DIM, SQUARE_DIM, t);
        }
        if (this.marker.equals("O"))
        {
            g.drawImage(t.getImages()[1], COL_POSITION, ROW_POSITION, SQUARE_DIM, SQUARE_DIM, t);
        }

    }
}
