package cs319;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.AbstractListModel;
import javax.swing.ListModel;

public class DataModel extends AbstractListModel<String> {
	private static final long serialVersionUID = 1L;
	private static ArrayList<String> companies;

	DataModel() throws FileNotFoundException {
		readFile();
	}
	
	public int getSize() {
		return companies.size();
	}

	public String getElementAt(int index) {
		return companies.get(index);
	}
	
	public File getFile() {
		return new File("/Users/christophersmith/workspace/lab2/src/cs319/companies.txt");
	}
	
	public void readFile() throws FileNotFoundException {
		companies = new ArrayList<String>();
		
		File file = getFile();
		Scanner sc = new Scanner(file);
		
		while(sc.hasNext()){
			String s = sc.next();
			companies.add(s);
		}
		
		sc.close();
	}
	
	public void addToFile(String companyName) throws IOException {
		readFile();
		companies.add(companyName);
		writeToFile();
	}
	
	public void removeFromFile(int index) throws IOException {
		readFile();
		companies.remove(index);
		writeToFile();
	}
	
	public void writeToFile() throws IOException {
		File file = getFile();
		FileWriter writer = new FileWriter(file);
		
		for (int i = 0; i < companies.size(); i++) {
			writer.write(companies.get(i));
			writer.write("\n");
		}
		
		writer.close();
	}
}
