class Piece {
	private char name;
	private char colour;

	public Piece(char name, char colour) {
		this.name = name;
		this.colour = colour;
	}

	public char getName() {
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
