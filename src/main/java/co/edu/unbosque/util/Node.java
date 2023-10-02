package co.edu.unbosque.util;

import java.io.Serializable;

public class Node <E> implements Serializable{
	
	private static final long serialVersionUID = -6680604507080958921L;
	private E info;
	private Node<E> next;
	
	public Node() {
		
	}

	public Node(E info, Node<E> next) {
		super();
		this.info = info;
		this.next = next;
	}
	//llama al constructor completo
	public Node(E info) {
		this(info,null);
	}

	public E getInfo() {
		return info;
	}

	public void setInfo(E info) {
		this.info = info;
	}

	public Node<E> getNext() {
		return next;
	}

	public void setNext(Node<E> next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return "Node [info=" + info + ", next=" + next + "]";
	}
	
	
	
	

}
