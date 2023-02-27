import java.util.Scanner;

// This class allows players to place a mark and take turns to do so
abstract class Player
{
    // Name of the player(Mike or Judy)
    protected String name;

    // Using the scanner for input on where to place the mark
    protected Scanner scan = new Scanner(System.in);
    // X or O
    protected char mark;
    protected Board board;
    protected Player opponent;

    // Constructor which sets the name of the player and mark
    protected Player(String name, char mark)
    {
        this.name = name;
        this.mark = mark;
    }

    // sets the opponent
    protected void setOpponent(Player opponent)
    {
        this.opponent = opponent;
    }

    // Checks to see if someone won, then if the board is full, then allows player to make a move.
    // Then displays the board and allows the opponent to make a move
    protected void play()
    {
     checkWin();
     checkFull();
     makeMove();
     board.display();
     opponent.play();
    }

    // Getting input for row and col, then checks to see if they are valid and lastly adds the mark
    protected void makeMove()
    {
        System.out.println(name+ ", what row should your next "+ mark +" be placed?");
        int r= scan.nextInt();
        System.out.println(name+ ", what column should your next "+ mark +" be placed?");
        int c= scan.nextInt();
        outOfBounds(r,c);
        board.addMark(r, c, mark);
    }

    // Sets the board so class player can use it
    protected void setBoard(Board board)
    {
        this.board = board;
    }

    // Checking to see if there are 9 mark on the board in total and exits if that is the case
    protected void checkFull()
    {
        if(board.isFull())
        {
        System.out.println("Game is a tie");
        scan.close();
        System.exit(0);
        }
    }

    // Checks to see if a player/opponent won the game and exits if that is the case
    protected void checkWin()
    {
        if(board.oWins() || board.xWins())
        {
            System.out.println(opponent.name + " is the winner! End of game...");
            scan.close();
            System.exit(0);
        }
    }

    // Checking to see if input is valid (in the board or on an empty spot)
    protected void outOfBounds(int r, int c)
    {
        if((c>2 || c<0) || (r>2 || r<0))
        {
            System.out.println("Invalid entry, please make a valid entry.\n");
            makeMove();
        }
        else if (board.getMark(r, c)!=' ')
        {
            System.out.println("That spot is taken, please select another spot \n");
            makeMove();
        }
    }
    protected char getMark() {
        return mark;
    }
}
