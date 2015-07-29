class Piece {
	private PieceName name;
	private char colour;

	public Piece(PieceName name, char colour) {
		this.name = name;
		this.colour = colour;
	}

	public PieceName getName() {
		return name;
	}

	public char getColour() {
		return colour;
	}

	@Override
	public String toString() {
		return "Piece [name=" + name + ", colour=" + colour + "]";
	}

}
