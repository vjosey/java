package com.skillstorm.files;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * FILE IO:
 * 
 * InputStream -> read in data into Java OutputStream -> write data to a file
 * 
 * FileInputStream / FileOutputStream -> raw bytes 
 * FileReader / FileWriter -> characters 
 * Scanner / PrintWriter -> line-by-line
 * 
 * ObjectInputStream / ObjectOutputStream -> objects (serialization)
 * 
 * @author PWalsh
 *
 */
public class ReadingAndWritingComponent {

	public List<Trainee> read() {
		File file = new File("trainees.txt");
		// store the trainees
		LinkedList<Trainee> result = new LinkedList<>();
		try (Scanner scanner = new Scanner(file)) {
			//System.out.println(scanner.delimiter());
			scanner.useDelimiter(",");
			// parse each line
			while (scanner.hasNextLine()) {
				Trainee trainee = new Trainee(scanner.next().trim(), scanner.next().trim(), 
						Integer.parseInt(scanner.next().trim()));
				// add to list
				result.add(trainee);
				// advance to next line
				scanner.nextLine();
			}
		} catch (FileNotFoundException e) {
			System.out.println(e);
		}
		// return trainees
		return result;
	}

	public void write(List<Trainee> trainees) {
		File file = new File("output.txt");
		try(PrintWriter writer = new PrintWriter(file)){
			for (Trainee trainee : trainees) {
				// if file doesn't exist, writing makes the file
				writer.println(trainee);
			}	
		}catch (Exception e) {
			System.out.println(e);
		}
	}
	
	// append to the file
	public void write(Trainee trainee) {
		File file = new File("output.txt"); // does not create file
							// Decorator 			writes characters		append?
		try(PrintWriter writer = new PrintWriter(new FileOutputStream(file, true))){
			writer.println(trainee);
		}catch (Exception e) {
			System.out.println(e);
		}	
	}

	
}








