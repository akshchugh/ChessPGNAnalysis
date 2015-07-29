class Chess {
	private Cell[][] grid;

	public Chess() {
		this.grid = new Cell[8][8];
		initializeGrid();
	}

	private void initializeGrid() {
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
		
		int row = preProcessDataRow(move, playerColor);
		int col = preProcessDataCol(move, playerColor);
		Piece piece = preProcessDataPiece(move, playerColor);
		int rowPositionIndex = preProcessDataRowPositionIndex(move);
		int colPositionIndex = preProcessDataColPositionIndex(move);
		
		// call putPiece
		// call locateRemoveMovingPiece
	}

	private int preProcessDataRow(String move, char playerColor) {
		
		int rowIndex; 
		lastChar = move.substring(move.length() - 1));
		if (lastChar == 'O' && playerColor == 'B'){
			rowIndex = 8;
		}
		else if (lastChar == 'O' && playerColor == 'W'){
			rowIndex = 1;
		}
		else {
			rowIndex = Character.getNumericValue(lastChar);
		}
		return rowIndex;
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
		
		if (Character.isLowerCase(move[0])){
			piece_name = PieceName.P;
		}
		else {
			piece_name = PieceName.move[0];	
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
		// TODO Auto-generated method stub
		// call removePiece
	}

	private void removePiece(int row, int col) {
		grid[row][col].setPiece(null);
	}

	public void displayBoard() {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid.length; j++) {
				System.out.print(grid[i][j]+" ");
			}
			System.out.println();
		}
		
	}

}
