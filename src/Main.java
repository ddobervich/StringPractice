import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Main {
	private static final String FILE_PATH = "mobydick.txt";

	public static void main(String[] args) {
		// Get the file as a String
		String raw_text = getFileAsString(FILE_PATH);

		// ----------------------------------------------------------------------------------
		// Do any pre-processing here (e.g. remove punctuation, collapse
		// whitespace, etc).
		String text = raw_text.replaceAll("[\\s]+", " "); // collapse whitespace
		String noPunctuationText = text.replaceAll("[^a-zA-Z -]", ""); // remove
																		// punctuation
		// ----------------------------------------------------------------------------------

		// Split the text into parts
		String[] sentences = text.split("[.!?]+\\s+"); // splits when it sees a
														// . ! or ? followed by
														// whitespace
		String[] words = noPunctuationText.split(" "); // splits on one space
		String[] letters = text.split(""); // splits at every character
		// ----------------------------------------------------------------------------------

		// YOU WRITE CODE HERE

		// Problem 1
		String longest = findLongestWord(words);
		System.out.println("Longest word is: " + longest);

		// Problem 2
		longest = findLongestWordWithoutE(words);
		System.out.println("The longest word without an e is: " + longest);

		// Problem 4
		// ... etc ...
	}

	private static String getFileAsString(String filename) {
		// Load file
		ClassLoader classLoader = ClassLoader.getSystemClassLoader();
		File file = new File(classLoader.getResource(filename).getFile());

		// Read File Content
		String content = "ERROR"; // default value that gets overwritten
		try {
			content = new String(Files.readAllBytes(file.toPath()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return content;
	}

}
