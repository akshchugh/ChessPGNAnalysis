class Piece {
	private PieceName name;
	private char color;

	public Piece(PieceName name, char color) {
		this.name = name;
		this.color = color;
	}

	public PieceName getName() {
		return name;
	}

	public char getColor() {
		return color;
	}

	@Override
	public String toString() {
		return "Piece [name = " + name + ", color = " + color + "]";
	}

}
