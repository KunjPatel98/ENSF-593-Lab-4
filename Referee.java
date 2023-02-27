// Class that starts/runs the game and makes a player for X and a player for O

public class Referee
{
    private Player oPlayer;
    private Player xPlayer;
    private Board board;

    // Default constructor
    public Referee() {}

    // Sets the board so referee can use it
    public void setBoard(Board board)
    {
        this.board = board;
    }

    // Sets the O player
    public void setoPlayer(Player oPlayer)
    {
        this.oPlayer = oPlayer;
    }

    // Sets the X player
    public void setxPlayer(Player xPlayer)
    {
        this.xPlayer = xPlayer;
    }

    // Sets the O and X players, displays the board and lets the X player go first
    public void runTheGame()
    {
        oPlayer.setOpponent(xPlayer);
        xPlayer.setOpponent(oPlayer);
        board.display();
        xPlayer.play();
    }
}
