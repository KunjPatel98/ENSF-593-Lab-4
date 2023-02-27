public class BlockingPlayer extends RandomPlayer
{

    public BlockingPlayer(String name, char mark)
    {
        super(name, mark);
    }

    @Override
    public void makeMove()
    {
        RandomGenerator markBoard = new RandomGenerator();
        int r, c;
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                if (testForBlocking(i, j) == true)
                {
                    board.addMark(i, j, mark);
                    return;
                }
            }
        }

        while (true)
        {
            r = markBoard.discrete(0, 2);
            c = markBoard.discrete(0, 2);
            if (board.getMark(r, c) == ' ')
            {
                board.addMark(r, c, mark);
                break;
            }
        }
    }

    public boolean testForBlocking(int r, int c)
    {
        char oppMark = opponent.getMark();
        if(board.getMark(r, c) == ' ')
        {
            board.addMark(r, c, oppMark);
            if(board.xWins() || board.oWins() == true)
            {
                board.removeMark(r,c);
                return true;
            }
            board.removeMark(r, c);
            return false;
        }
        return false;
    }
}


