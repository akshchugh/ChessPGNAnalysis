class Piece {
	private PieceName name;
	private PieceColor colour;

	public Piece(PieceName name, PieceColor colour) {
		this.name = name;
		this.colour = colour;
	}

	public PieceName getName() {
		return name;
	}

	public PieceColor getColour() {
		return colour;
	}

	@Override
	public String toString() {
		return "Piece [name=" + name + ", colour=" + colour + "]";
	}

}
