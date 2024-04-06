package files;
import java.io.*;

public class FileUtils {

	public static String readFile(String fileName) {

		try {

			File file = new File(fileName);
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line;
			StringBuilder stringBuilder = new StringBuilder();

			while ((line = bufferedReader.readLine()) != null) {
				stringBuilder.append(line + "\n");
			}
			fileReader.close();
			return stringBuilder.toString();

		} catch (IOException e) {
			System.out.println("Error message: " + e.getMessage());	
		}

		return null;
	}
	
	public static void saveFile(String fileName, String encodedData)  {

		try {
			
			File file = new File(fileName);
			FileWriter fileWriter = new FileWriter(file);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			
			bufferedWriter.write(encodedData);
			bufferedWriter.close();

		} catch (IOException e) {
			System.out.println("Error message: " + e.getMessage());	
		}
		
	}
}
