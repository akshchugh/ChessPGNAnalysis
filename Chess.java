class Chess {
	private Cell[][] grid;

	public Chess() {
		this.grid = new Cell[8][8];
		initializeGrid();
	}

	private void initializeGrid() {
		// TODO Auto-generated method stub

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
		// TODO Auto-generated method stub
		// call removePiece
	}

	private void removePiece(int row, int col) {
		grid[row][col].setPiece(null);
	}

}
