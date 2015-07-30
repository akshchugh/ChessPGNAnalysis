import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("C:/Training/ChessGame/src/input.txt");
		Scanner scanner = new Scanner(file);
		Chess chess = new Chess();
		while (scanner.hasNextLine()) {
			String string = scanner.nextLine();
			String[] s = string.split(" ");
			chess.nextMove(s[0], 'W');
			if (s.length > 1) {
				chess.nextMove(s[1], 'B');
			}
		}
		chess.displayBoard();
	}

}
