import java.util.HashMap;
import java.util.Map;

class Chess {
	private Cell[][] grid;
	private Map<String, String> whitePiecePositions;
	private Map<String, String> blackPiecePositions;

	public Chess() {
		this.grid = new Cell[8][8];
		this.whitePiecePositions = new HashMap<String, String>();
		this.blackPiecePositions = new HashMap<String, String>();
		initializeGrid();
	}

	private void initializeGrid() {
		Piece pawn = new Piece(PieceName.P, PieceColor.B);
		Piece pieceObject;
		Cell cell;

		for (int i = 0; i < 8; i++) {
			pieceObject = new Piece(PieceName.P, PieceColor.W);
			cell = new Cell(pieceObject);
			grid[1][i] = cell;
		}
		for (int i = 0; i < 8; i++) {
			pieceObject = new Piece(PieceName.P, PieceColor.B);
			cell = new Cell(pieceObject);
			grid[6][i] = cell;
		}
		for (int i = 2; i < 6; i++) {
			for (int j = 0; j < 8; j++) {
				cell = new Cell();
				grid[i][j] = cell;
			}
		}

		pieceObject = new Piece(PieceName.R, PieceColor.W);
		cell = new Cell(pieceObject);
		grid[0][0] = cell;
		whitePiecePositions.put(pieceObject.getName().toString() + " 1", "0 0");
		pieceObject = new Piece(PieceName.R, PieceColor.W);
		cell = new Cell(pieceObject);
		grid[0][7] = cell;
		whitePiecePositions.put(pieceObject.getName().toString() + " 2", "0 7");
		pieceObject = new Piece(PieceName.R, PieceColor.B);
		cell = new Cell(pieceObject);
		grid[7][0] = cell;
		blackPiecePositions.put(pieceObject.getName().toString() + " 1", "7 0");
		pieceObject = new Piece(PieceName.R, PieceColor.B);
		cell = new Cell(pieceObject);
		grid[7][7] = cell;
		blackPiecePositions.put(pieceObject.getName().toString() + " 2", "7 7");

		pieceObject = new Piece(PieceName.N, PieceColor.W);
		cell = new Cell(pieceObject);
		grid[0][1] = cell;
		whitePiecePositions.put(pieceObject.getName().toString() + " 1", "0 1");
		pieceObject = new Piece(PieceName.N, PieceColor.W);
		cell = new Cell(pieceObject);
		grid[0][6] = cell;
		whitePiecePositions.put(pieceObject.getName().toString() + " 2", "0 6");
		pieceObject = new Piece(PieceName.N, PieceColor.B);
		cell = new Cell(pieceObject);
		grid[7][1] = cell;
		blackPiecePositions.put(pieceObject.getName().toString() + " 1", "7 1");
		pieceObject = new Piece(PieceName.N, PieceColor.B);
		cell = new Cell(pieceObject);
		grid[7][6] = cell;
		blackPiecePositions.put(pieceObject.getName().toString() + " 2", "7 6");

		pieceObject = new Piece(PieceName.B, PieceColor.W);
		cell = new Cell(pieceObject);
		grid[0][2] = cell;
		whitePiecePositions.put(pieceObject.getName().toString() + " 1", "0 2");
		pieceObject = new Piece(PieceName.B, PieceColor.W);
		cell = new Cell(pieceObject);
		grid[0][5] = cell;
		whitePiecePositions.put(pieceObject.getName().toString() + " 2", "0 5");
		pieceObject = new Piece(PieceName.B, PieceColor.B);
		cell = new Cell(pieceObject);
		grid[7][2] = cell;
		blackPiecePositions.put(pieceObject.getName().toString() + " 1", "7 2");
		pieceObject = new Piece(PieceName.B, PieceColor.B);
		cell = new Cell(pieceObject);
		grid[7][5] = cell;
		blackPiecePositions.put(pieceObject.getName().toString() + " 2", "7 5");

		pieceObject = new Piece(PieceName.Q, PieceColor.W);
		cell = new Cell(pieceObject);
		grid[0][3] = cell;
		whitePiecePositions.put(pieceObject.getName().toString(), "0 3");
		pieceObject = new Piece(PieceName.Q, PieceColor.B);
		cell = new Cell(pieceObject);
		grid[7][3] = cell;
		blackPiecePositions.put(pieceObject.getName().toString(), "7 3");

		pieceObject = new Piece(PieceName.K, PieceColor.W);
		cell = new Cell(pieceObject);
		grid[0][4] = cell;
		whitePiecePositions.put(pieceObject.getName().toString(), "0 4");
		pieceObject = new Piece(PieceName.K, PieceColor.B);
		cell = new Cell(pieceObject);
		grid[7][4] = cell;
		blackPiecePositions.put(pieceObject.getName().toString(), "7 4");

	}

	public void nextMove(String move, char playerColor) {

		int row = preProcessDataRow(move, playerColor);
		int col = preProcessDataCol(move);
		Piece piece = preProcessDataPiece(move, playerColor);
		int rowPositionIndex = preProcessDataRowPositionIndex(move);
		int colPositionIndex = preProcessDataColPositionIndex(move);
		boolean isCaptured = preProcessDataCapture(move);

		putPiece(piece, row, col);
		locateRemoveMovingPiece(piece, row, col, rowPositionIndex, colPositionIndex,isCaptured);
	}

	private int preProcessDataCol(String move) {
		int columnIndex = 0;
		char lastChar = move.charAt(move.length() - 1);
		char columnChar = move.charAt(move.length() - 2);
		if (lastChar == 'O') {
			if (move.length() == 3) {
				columnIndex = 6;
			} else if (move.length() == 5) {
				columnIndex = 2;
			}
		} else {
			columnIndex = columnChar - 'a';
		}
		return columnIndex;
	}

	private int preProcessDataRow(String move, char playerColor) {
		int rowIndex;
		char lastChar = move.charAt(move.length() - 1);

		if (lastChar == 'O' && playerColor == 'B') {
			rowIndex = 7;
		} else if (lastChar == 'O' && playerColor == 'W') {
			rowIndex = 0;
		} else {
			rowIndex = Character.getNumericValue(lastChar) - 1;
		}
		return rowIndex;
	}

	private boolean charInRange(char toCheck, char min, char max) {
		return (toCheck >= min && toCheck <= max);
	}

	private int preProcessDataColPositionIndex(String move) {

		int colPosition = -1;
		char colPositionChar = move.charAt(1);
		if (move.length() == 4) {
			if (charInRange(colPositionChar, 'a', 'h')) {
				colPosition = colPositionChar - 'a';
			}
		}
		return colPosition;
	}

	private int preProcessDataRowPositionIndex(String move) {
		int rowPosition = -1;
		if (move.length() == 4) {
			if (Character.isDigit(move.charAt(1))) {
				rowPosition = Character.getNumericValue(move.charAt(1)) - 1;
			}
		}
		return rowPosition;
	}

	private Piece preProcessDataPiece(String move, char playerColor) {
		PieceName piece_name;
		PieceColor piece_color;
		if (Character.isLowerCase(move.charAt(0))) {
			piece_name = PieceName.P;
		} else {
			piece_name = PieceName.valueOf(move.charAt(0) + "");
		}

		if (playerColor == 'W') {
			piece_color = PieceColor.W;
		} else {
			piece_color = PieceColor.B;
		}
		Piece piece = new Piece(piece_name, piece_color);
		return piece;
	}

	private boolean preProcessDataCapture(String move){
		if(move.charAt(1) == 'x'){
			return true;
		}
		return false;
	}

	private void putPiece(Piece piece, int row, int col) {
		grid[row][col] = new Cell(piece);
	}

	public void locateRemoveMovingPiece(Piece piece, int row, int col, int rowPositionIndex, int colPositionIndex,
			boolean isCaptured) {
		switch (piece.getName()) {
		case K:
		case Q:
			locateRemoveKingOrQueen(piece, row, col);
			break;
		case R:
			locateRemoveRook(piece, row, col, rowPositionIndex, colPositionIndex);
			break;
		case B:
			locateRemoveBishop(piece, row, col, rowPositionIndex, colPositionIndex);
			break;
		case N:
			break;
		case P:
			break;
		}
	}
	private boolean isPossibleBishopMove(int newrow, int newcol, int oldrow , int oldcol) {
		if(Math.abs(newrow-oldrow) != Math.abs(newcol-oldcol)) {
			return false;
		}
		else {
			if(newrow>oldrow && newcol>oldcol) {
				for(int i=1;i<=(newrow-oldrow);i++) {
					if(grid[oldrow+i][oldcol+i]!=null)
						return false;
				}
					
			}
			else if (newrow>oldrow && newcol<oldcol) {
				for(int i=1;i<=(newrow-oldrow);i++) {
					if(grid[oldrow+i][oldcol-i]!=null)
						return false;
				}
			}
			else if (newrow<oldrow && newcol>oldcol) {
				for(int i=1;i<=(newcol-oldcol);i++) {
					if(grid[oldrow-i][oldcol+i]!=null)
						return false;
				}
			}
			else {
				for(int i=1;i<=(oldcol-newcol);i++) {
					if(grid[oldrow-i][oldcol-i]!=null)
						return false;
				}
			}	
		}
		return true;
	}
	private void locateRemoveBishop(Piece piece, int row, int col,int rowPositionIndex,int colPositionIndex) {
		String position1="", position2="";
		String [] s1,s2;
		int delRow=0,delCol=0;
		if( rowPositionIndex == -1 && colPositionIndex == -1){
			if (piece.getColor().equals(PieceColor.W)) {
				position1 = whitePiecePositions.get(piece.getName().toString())+ " 1";
				position2 = whitePiecePositions.get(piece.getName().toString())+ " 2";
				s1 = position1.split(" ");
				if(isPossibleBishopMove(row,col,Integer.parseInt(s1[0]),Integer.parseInt(s1[1]))) {
				    delRow = Integer.parseInt(s1[0]);
					delCol = Integer.parseInt(s1[1]);
					
					
				}
				else {
					s2 = position2.split(" ");
					delRow = Integer.parseInt(s2[0]);
					delCol = Integer.parseInt(s2[1]);
				}
			}
			else {
				position1 = blackPiecePositions.get(piece.getName().toString())+ " 1";
				position2 = blackPiecePositions.get(piece.getName().toString())+ " 2";
				s1 = position1.split(" ");
				if(Math.abs(Integer.parseInt(s1[0])-row) == Math.abs(Integer.parseInt(s1[1])-col)) {
					delRow = Integer.parseInt(s1[0]);
					delCol = Integer.parseInt(s1[1]);
					
				}
				else {
					s2 = position2.split(" ");
					delRow = Integer.parseInt(s2[0]);
					delCol = Integer.parseInt(s2[1]);
				}
			}
		}
		String s3 [] = position1.split(" ");
		int delRow1 = Integer.parseInt(s3[0]);
		int delCol1 = Integer.parseInt(s3[1]);
		s3 = position2.split(" ");
		int delRow2 = Integer.parseInt(s3[0]);
		int delCol2 = Integer.parseInt(s3[1]);
		if (rowPositionIndex != -1) {
			delRow = rowPositionIndex == delRow1 ? delRow1 : delRow2;
			delCol = rowPositionIndex == delRow1 ? delCol1 : delCol2;
			removePiece(delRow, delCol);
			return;
		}
		if (colPositionIndex != -1) {
			delRow = colPositionIndex == delCol1 ? delRow1 : delRow2;
			delCol = colPositionIndex == delCol1 ? delCol1 : delCol2;
			removePiece(delRow, delCol);
			return;
		}
		removePiece(delRow,delCol);		
	}

	private void locateRemoveRook(Piece piece, int row, int col, int rowPositionIndex, int colPositionIndex) {
		String position1;
		String position2;
		if (piece.getColor().equals(PieceColor.W)) {
			position1 = whitePiecePositions.get(piece.getName().toString() + " " + 1);
			position2 = whitePiecePositions.get(piece.getName().toString() + " " + 2);
			// whitePiecePositions.put(piece.getName().toString(), row + " " +
			// col);
		} else {
			position1 = blackPiecePositions.get(piece.getName().toString() + " " + 1);
			position2 = blackPiecePositions.get(piece.getName().toString() + " " + 2);
			// blackPiecePositions.put(piece.getName().toString(), row + " " +
			// col);
		}
		String[] s = position1.split(" ");
		int delRow1 = Integer.parseInt(s[0]);
		int delCol1 = Integer.parseInt(s[1]);
		s = position2.split(" ");
		int delRow2 = Integer.parseInt(s[0]);
		int delCol2 = Integer.parseInt(s[1]);
		int delRow = 0;
		int delCol = 0;
		if (rowPositionIndex != -1) {
			delRow = rowPositionIndex == delRow1 ? delRow1 : delRow2;
			delCol = rowPositionIndex == delRow1 ? delCol1 : delCol2;
			removePiece(delRow, delCol);
			return;
		}
		if (colPositionIndex != -1) {
			delRow = colPositionIndex == delCol1 ? delRow1 : delRow2;
			delCol = colPositionIndex == delCol1 ? delCol1 : delCol2;
			removePiece(delRow, delCol);
			return;
		}
		if (isMovePossible) {
			
		} else {
			
		}

		removePiece(delRow, delCol);
	}

	
	private void locateRemoveKingOrQueen(Piece piece, int row, int col) {
		String position;
		if (piece.getColor().equals(PieceColor.W)) {
			position = whitePiecePositions.get(piece.getName().toString());
			whitePiecePositions.put(piece.getName().toString(), row + " " + col);
		} else {
			position = blackPiecePositions.get(piece.getName());
			blackPiecePositions.put(piece.getName().toString(), row + " " + col);
		}
		String[] s = position.split(" ");
		int delRow = Integer.parseInt(s[0]);
		int delCol = Integer.parseInt(s[1]);
		removePiece(delRow, delCol);
	}

	private void removePiece(int row, int col) {
		grid[row][col].setPiece(null);
	}

	public void displayBoard() {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid.length; j++) {
				System.out.print(grid[i][j].getPiece() + " ");
			}
			System.out.println();
		}
		System.out.println(whitePiecePositions);
	}

}
