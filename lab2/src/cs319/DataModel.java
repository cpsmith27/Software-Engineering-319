package cs319;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class DataModel extends javax.swing.AbstractListModel {
	

 private static ArrayList<String> list_companies=  new ArrayList<String>();
	
	public static void main(String[] args) throws FileNotFoundException {
		
		
		String s="/Users/christophersmith/workspace/lab2/src/cs319/companies.txt";
		ArrayList<String> arr= new ArrayList<String>();
		arr= readfiles(s);
		
		for (int i=0; i<arr.size();i++){
			System.out.println(arr.get(i));
		}
		
		
		
	}
	
	
	public static ArrayList<String> readfiles (String filename) throws FileNotFoundException{ 
	
	File file = new File(filename);
	
	Scanner sc = new Scanner(file);
	
	
	while(sc.hasNext()){
		String s = sc.next();
		list_companies.add(s);
		
	}
	
	
	
	return list_companies;
	

}
	
	
	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return list_companies.size();
	}

	@Override
	public Object getElementAt(int index) {
		// TODO Auto-generated method stub
		return list_companies.get(index);
	}
	
	
	

}
