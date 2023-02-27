
// This class creates a game board and uses variables from another class

public class Board implements Constants
{
	// The board that will be displayed on the console
	private char theBoard[][];
	private int markCount;

	// Default constructor that makes a 3x3 char array which is the board
	public Board()
	{
		markCount = 0;
		theBoard = new char[3][];
		for (int i = 0; i < 3; i++)
		{
			theBoard[i] = new char[3];
			for (int j = 0; j < 3; j++)
				theBoard[i][j] = SPACE_CHAR;
		}
	}

	// Returns the mark (O or X) position on the board in terms of row and col
	public char getMark(int row, int col) {
		return theBoard[row][col];
	}

	// Returns T/F if the board is full (all 9 marks have been placed)
	public boolean isFull() {
		return markCount == 9;
	}

	// Returns T if player X won otherwise returns F
	public boolean xWins()
	{
		if (checkWinner(LETTER_X) == 1)
			return true;
		else
			return false;
	}

	// Returns T if player O won otherwise returns F
	public boolean oWins()
	{
		if (checkWinner(LETTER_O) == 1)
			return true;
		else
			return false;
	}

	// Prints the board which shows all the rows, columns, and marks
	public void display()
	{
		displayColumnHeaders();
		addHyphens();
		for (int row = 0; row < 3; row++)
		{
			addSpaces();
			System.out.print("    row " + row + ' ');
			for (int col = 0; col < 3; col++)
				System.out.print("|  " + getMark(row, col) + "  ");
			System.out.println("|");
			addSpaces();
			addHyphens();
		}
	}

	// Adds the mark(O or X) on the array and keeps track of mark count
	public void addMark(int row, int col, char mark)
	{
		theBoard[row][col] = mark;
		markCount++;
	}
	public void removeMark(int row, int col)
	{
		theBoard[row][col] = SPACE_CHAR;
		markCount--;
	}

	// Makes the board empty by replacing the elements of the 3D array with SPACE_CHAR
	public void clear()
	{
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				theBoard[i][j] = SPACE_CHAR;
		markCount = 0;
	}

	// The method checks to see if there is a winner by going through the array vertically, horizontally,
	// and diagonally to see if there are 3 marks in a row. If there is a winner then the method returns 0
	int checkWinner(char mark)
	{
		int row, col;
		int result = 0;

		for (row = 0; result == 0 && row < 3; row++)
		{
			int row_result = 1;
			for (col = 0; row_result == 1 && col < 3; col++)
				if (theBoard[row][col] != mark)
					row_result = 0;
			if (row_result != 0)
				result = 1;
		}

		for (col = 0; result == 0 && col < 3; col++)
		{
			int col_result = 1;
			for (row = 0; col_result != 0 && row < 3; row++)
				if (theBoard[row][col] != mark)
					col_result = 0;
			if (col_result != 0)
				result = 1;
		}

		if (result == 0)
		{
			int diag1Result = 1;
			for (row = 0; diag1Result != 0 && row < 3; row++)
				if (theBoard[row][row] != mark)
					diag1Result = 0;
			if (diag1Result != 0)
				result = 1;
		}

		if (result == 0)
		{
			int diag2Result = 1;
			for (row = 0; diag2Result != 0 && row < 3; row++)
				if (theBoard[row][3 - 1 - row] != mark)
					diag2Result = 0;
			if (diag2Result != 0)
				result = 1;
		}
		return result;
	}

	// Prints the column headers with their index
	void displayColumnHeaders()
	{
		System.out.print("          ");
		for (int j = 0; j < 3; j++)
			System.out.print("|col " + j);
		System.out.println();
	}

	// Prints hyphens 3 times when called for horizontal part of the board
	void addHyphens()
	{
		System.out.print("          ");
		for (int j = 0; j < 3; j++)
			System.out.print("+-----");
		System.out.println("+");
	}

	// Adds empty spaces and vertical lines
	void addSpaces()
	{
		System.out.print("          ");
		for (int j = 0; j < 3; j++)
			System.out.print("|     ");
		System.out.println("|");
	}
}
