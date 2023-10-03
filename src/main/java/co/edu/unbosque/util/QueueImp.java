package co.edu.unbosque.util;
import java.io.Serializable;
import java.util.Iterator;

public class QueueImp<T> implements Queue<T>,Iterable<T>,Serializable{
	
	private static final long serialVersionUID = 7180501740512462807L;
	private DequeList<T> infos;
	
	public QueueImp() {
		infos=new DequeList<>();
	}

	public DequeList<T> getInfos() {
		return infos;
	}

	public void setInfos(DequeList<T> infos) {
		this.infos = infos;
	}

	@Override
	public void enqueue(T info) {
		infos.insertLast(info);
		
	}

	@Override
	public T dequeue() {
		return infos.removeFirst();
	}

	@Override
	public int size() {
		return infos.size();
	}

	@Override
	public T peek() {
		return infos.getHead().getInfo();
	}
	
	public DNode<T> getData(T info){
		return infos.get(info);
	}
	
	public T get(int i){
		return infos.getByIndex(i);
	}
	
	@Override
	public String toString() {
		StringBuffer buf=new StringBuffer();
		buf.append("Front [");
		DNode<T> aux=infos.getHead();
		for (int i = 0; i < infos.size(); i++) {
			buf.append(aux.getInfo());
			if(aux==infos.getTail())break;
			else buf.append("<->");
			aux=aux.getNext();
		}
		buf.append("] Back");
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
