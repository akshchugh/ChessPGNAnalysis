import java.util.HashMap;
import java.util.Map;

class Chess {
	private Cell[][] grid;
	private Map<PieceName, String> whitePiecePositions;
	private Map<PieceName, String> blackPiecePositions;

	public Chess() {
		this.grid = new Cell[8][8];
		this.whitePiecePositions = new HashMap<PieceName, String>();
		this.blackPiecePositions = new HashMap<PieceName, String>();
		initializeGrid();
	}

	private void initializeGrid() {
		Piece pawn = new Piece(PieceName.P, PieceColor.B);

	}

	public void nextMove(String move, char playerColor) {
		int row = preProcessDataRow(move);
		int col = preProcessDataCol(move);
		Piece piece = preProcessDataPiece(move, playerColor);
		int rowPositionIndex = preProcessDataRowPositionIndex(move);
		int colPositionIndex = preProcessDataColPositionIndex(move);

		// call putPiece
		// call locateRemoveMovingPiece
	}

	private int preProcessDataCol(String move) {
		// TODO Auto-generated method stub
		return 0;
	}

	private int preProcessDataColPositionIndex(String move) {
		// return -1 if not applicable
		return 0;
	}

	private int preProcessDataRowPositionIndex(String move) {
		// return -1 if not applicable
		return 0;
	}

	private Piece preProcessDataPiece(String move, char playerColor) {
		// TODO Auto-generated method stub
		return null;
	}

	private int preProcessDataRow(String move) {
		// TODO Auto-generated method stub
		return 0;
	}

	private void putPiece(Piece piece, int row, int col) {
		grid[row][col] = new Cell(piece);

	}

	private void locateRemoveMovingPiece(Piece piece, int row, int col, int rowPositionIndex, int colPositionIndex) {
		switch (piece.getName()) {
		case K:
			locateRemoveKing(piece, row, col);
			break;
		case Q:
			break;
		case R:
			break;
		case B:
			break;
		case N:
			break;
		case P:
			break;
		}
	}

	private void locateRemoveKing(Piece piece, int row, int col) {
		String position;
		if (piece.getColor().equals(PieceColor.W)) {
			position = whitePiecePositions.get(piece.getName());
		} else {
			position = blackPiecePositions.get(piece.getName());
		}
		String[] s = position.split(" ");
		int delRow = Integer.parseInt(s[0]);
		int delCol = Integer.parseInt(s[1]);
		removePiece(delRow, delCol);
	}

	private void locateRemoveKing() {
		// TODO Auto-generated method stub

	}

	private void removePiece(int row, int col) {
		grid[row][col].setPiece(null);
	}

	public void displayBoard() {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid.length; j++) {
				System.out.print(grid[i][j] + " ");
			}
			System.out.println();
		}

	}

}
