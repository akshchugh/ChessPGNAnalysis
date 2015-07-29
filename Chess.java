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
		Piece pieceObject;
		Cell cell;
		for(int i=0;i<8;i++) {
			pieceObject=new Piece(PieceName.P,PieceColor.W);
			cell= new Cell(pieceObject);
			grid[1][i]=cell;
		}
		for(int i=0;i<8;i++) {
			pieceObject=new Piece(PieceName.P,PieceColor.B);
			cell= new Cell(pieceObject);
			grid[6][i]=cell;
		}	
		for(int i=2;i<6;i++) {
			for(int j=0;j<8;j++) {
				cell= new Cell();
				grid[i][j]=cell;
			}
		}
		pieceObject=new Piece(PieceName.R,PieceColor.W);
		cell= new Cell(pieceObject);
		grid[0][0]=cell;
		pieceObject=new Piece(PieceName.R,PieceColor.W);
		cell= new Cell(pieceObject);
		grid[0][7]=cell;
		pieceObject=new Piece(PieceName.R,PieceColor.B);
		cell= new Cell(pieceObject);
		grid[7][0]=cell;
		pieceObject=new Piece(PieceName.R,PieceColor.B);
		cell= new Cell(pieceObject);
		grid[7][7]=cell;
		
		pieceObject=new Piece(PieceName.N,PieceColor.W);
		cell= new Cell(pieceObject);
		grid[0][1]=cell;
		pieceObject=new Piece(PieceName.N,PieceColor.W);
		cell= new Cell(pieceObject);
		grid[0][6]=cell;
		pieceObject=new Piece(PieceName.N,PieceColor.B);
		cell= new Cell(pieceObject);
		grid[7][1]=cell;
		pieceObject=new Piece(PieceName.N,PieceColor.B);
		cell= new Cell(pieceObject);
		grid[7][6]=cell;
		
		pieceObject=new Piece(PieceName.B,PieceColor.W);
		cell= new Cell(pieceObject);
		grid[0][2]=cell;
		pieceObject=new Piece(PieceName.B,PieceColor.W);
		cell= new Cell(pieceObject);
		grid[0][5]=cell;
		pieceObject=new Piece(PieceName.B,PieceColor.B);
		cell= new Cell(pieceObject);
		grid[7][2]=cell;
		pieceObject=new Piece(PieceName.B,PieceColor.B);
		cell= new Cell(pieceObject);
		grid[7][5]=cell;
		
		pieceObject=new Piece(PieceName.Q,PieceColor.W);
		cell= new Cell(pieceObject);
		grid[0][3]=cell;
		pieceObject=new Piece(PieceName.Q,PieceColor.B);
		cell= new Cell(pieceObject);
		grid[7][3]=cell;
		
		pieceObject=new Piece(PieceName.K,PieceColor.W);
		cell= new Cell(pieceObject);
		grid[0][4]=cell;
		pieceObject=new Piece(PieceName.K,PieceColor.B);
		cell= new Cell(pieceObject);
		grid[7][4]=cell;
		
		
		
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
		
		PieceName piece_name ;
		PieceColor piece_color ;
		
		if (Character.isLowerCase(move.charAt(0))){
			piece_name = PieceName.P;
		}
		else {
			piece_name = PieceName.valueOf(move.charAt(0)+"");	
		}
		
		if (playerColor == 'W'){
			piece_color = PieceColor.W;
		}
		else {
			piece_color = PieceColor.B;
		}
		
		Piece piece = new Piece(piece_name,piece_color);
		
		return piece;
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
				System.out.print(grid[i][j].getPiece() + " ");
			}
			System.out.println();
		}

	}

}
