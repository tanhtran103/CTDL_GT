package lab5;

public class TicTacToe {
	private static final char EMPTY = ' ';
	private char[][] board;

	TicTacToe(char[][] board) {
		this.board = board;
	}

	public void printBoard(char[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}

	// This method checks all rows
	public boolean checkRows() {
		int row_count = 0;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if (board[i][j] != EMPTY)
					row_count++;
			}
			if (row_count == board.length) {
				return true;
			}
		}
		return false;
	}
	// This method checks all columns

	public boolean checkColumns() {
		int col_count = 0;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if (board[j][i] != EMPTY)
					col_count++;
			}
			if (col_count == board.length) {
				return true;
			}
		}
		return false;
	}

	// This method checks both diagonals
	public boolean checkDiagonals() {
		int mainDiagonal_count = 0;
		int secondDiagonal_count = 0;
		for (int i = 0; i < board.length; i++) {

			if (board[i][i] != EMPTY) {
				mainDiagonal_count++;
			}
			if (board[i][board.length - i - 1] != EMPTY) {
				secondDiagonal_count++;
			}

		}
		if (mainDiagonal_count == board.length || secondDiagonal_count == board.length) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		char[][] board = { { ' ', ' ', 'X' }, { ' ', 'X', ' ' }, { 'X', ' ', 'X' } };
		TicTacToe ticTacToe = new TicTacToe(board);
		ticTacToe.printBoard(board);
		System.out.println(ticTacToe.checkRows());
		System.out.println(ticTacToe.checkColumns());
		System.out.println(ticTacToe.checkDiagonals());
	}
}
