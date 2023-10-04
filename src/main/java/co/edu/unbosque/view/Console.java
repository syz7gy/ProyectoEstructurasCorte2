package co.edu.unbosque.view;

import java.util.Scanner;

public class Console {
	
	private Scanner sc;
	
	public Console() {
		sc = new Scanner(System.in);
		sc.useDelimiter("\n");
	}
	
	public int nextInt() {
		return sc.nextInt();
	}
	
	public long nextLong() {
		return sc.nextLong();
	}
	
	public double nextDouble() {
		return sc.nextDouble();
	}
	
	public float nextFloat() {
		return sc.nextFloat();
	}
	
	public char nextChar() {
		return sc.next().charAt(0);
	}
	
	public String next() {
		return sc.next();
	}
	
	public String nextLine() {
		return sc.nextLine();
	}
	
	public void burnLine() {
		sc.next();
	}
	
	public void print(String message) {
		System.out.print(message);
	}
	
	public void printLine(String message) {
		System.out.println(message);
	}

}
