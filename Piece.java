class Piece {
	private PieceName name;
	private PieceColor color;

	public Piece(PieceName name, PieceColor color) {
		this.name = name;
		this.color = color;
	}

	public PieceName getName() {
		return name;
	}

	public PieceColor getColor() {
		return color;
	}

	@Override
	public String toString() {
		return "Piece [name = " + name + ", color = " + color + "]";
	}

}
