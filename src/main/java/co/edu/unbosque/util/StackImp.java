package co.edu.unbosque.util;
import java.io.Serializable;
import java.util.Iterator;

public class StackImp<T> implements Stack<T>,Iterable<T>,Serializable{
	
	private static final long serialVersionUID = -3380900614073063957L;
	private DequeList<T> infos;
	
	public StackImp() {
		infos=new DequeList<>();
	}

	@Override
	public void push(T info) {
		infos.insertLast(info);
	}

	@Override
	public T pop() {
		return infos.removeLast();
	}

	@Override
	public int size() {
		return infos.size();
	}

	@Override
	public T peek() {
		return infos.getTail().getInfo();
	}
	
	@Override
	public String toString() {
		StringBuffer buf=new StringBuffer();
		buf.append("Bottom [");
		DNode<T> aux=infos.getHead();
		for (int i = 0; i < infos.size(); i++) {
			buf.append(aux.getInfo());
			if(aux==infos.getTail())break;
			else buf.append("<->");
			aux=aux.getNext();
		}
		buf.append("] Top");
		return buf.toString();
	}

	@Override
	public Iterator<T> iterator() {
		return infos.iterator();
	}

	@Override
	public boolean isEmpty() {
		return infos.isEmpty();
	}

}
