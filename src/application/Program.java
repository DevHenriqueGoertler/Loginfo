package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import entities.UserLog;

public class Program {
	
	public static void main(String[] args) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
		Scanner sc =  new Scanner(System.in);
		Set<UserLog> userLog = new TreeSet<>();
		
		System.out.print("Enter the file full path: ");
		File path = new File(sc.next());
		
		while (!path.exists()) {
			System.out.println("File does not exist");
			System.out.print("Enter a valid path: ");
			path = new File(sc.next());
		}
		sc.close();
		try (BufferedReader br = new BufferedReader(new FileReader(path))){
			
			String log = br.readLine();
			while (log != null) {
				String[] vect = log.split(" ");
				userLog.add(new UserLog(vect[0], sdf.parse(vect[1])));
				log = br.readLine();
			}
		
			System.out.println("Total users: " + userLog.size());
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (ParseException e) {
			System.out.println(e.getMessage());
		}
	}
}
