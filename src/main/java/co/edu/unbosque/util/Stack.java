package co.edu.unbosque.util;

public interface Stack<T> {
	
	public void push(T info);
	public T pop();
	public int size();		
	public T peek();
	public boolean isEmpty();
	
}

