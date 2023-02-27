public class RandomPlayer extends Player
{
    public RandomPlayer(String name, char mark) {
        super(name, mark);
    }

    @Override
    public void makeMove()
    {
        RandomGenerator markBoard = new RandomGenerator();
        int r, c;
        while(true)
        {
            r=markBoard.discrete(0,2);
            c=markBoard.discrete(0, 2);

            if(board.getMark(r, c)==' ')
            {
                board.addMark(r, c, mark);
                break;
            }
        }
    }
}
