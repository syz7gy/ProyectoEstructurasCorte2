package co.edu.unbosque.util;

import java.io.Serializable;

public class DNode<T>implements Serializable{
	
	private static final long serialVersionUID = -6514900595215135659L;
	private DNode<T> previous,next;
	private T info;
	
	public DNode() {}

	public DNode(DNode<T> previous, DNode<T> next, T info) {
		this.previous = previous;
		this.next = next;
		this.info = info;
	}
	
	public DNode(T info) {
		this(null,null,info);
	}

	@Override
	public String toString() {
		String prev=(previous==null||previous.info==null?"null":previous.getInfo().toString());
		String nex=(next==null||next.info==null?"null":next.getInfo().toString());
		return "DNode [previous=" + prev + ", next=" + nex + ", info=" + info + "]";
	}

	public DNode<T> getPrevious() {
		return previous;
	}

	public void setPrevious(DNode<T> previous) {
		this.previous = previous;
	}

	public DNode<T> getNext() {
		return next;
	}

	public void setNext(DNode<T> next) {
		this.next = next;
	}

	public T getInfo() {
		return info;
	}

	public void setInfo(T info) {
		this.info = info;
	}

}
