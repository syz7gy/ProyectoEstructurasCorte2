package co.edu.unbosque.model.persistence;

import java.util.Date;

import co.edu.unbosque.model.PersonDTO;
import co.edu.unbosque.util.MyDoubleLinkedList;
import co.edu.unbosque.util.MyLinkedList;
import co.edu.unbosque.util.QueueImp;

public class PersonDAO{
	
	private QueueImp<PersonDTO> queueOfPeople;
	
	public PersonDAO() {
		queueOfPeople = new QueueImp<PersonDTO>();
	}

	public QueueImp<PersonDTO> getQueueOfPeople() {
		return queueOfPeople;
	}

	public void setQueueOfPeople(QueueImp<PersonDTO> queueOfPeople) {
		this.queueOfPeople = queueOfPeople;
	}

	public void enqueue(Object o) {
		queueOfPeople.enqueue((PersonDTO) o);
	}

	@SuppressWarnings("deprecation")
	public void create(String... args) {
		String[] spaces = args[1].split("-");
		int year = Integer.parseInt(spaces[0]);
		int month = Integer.parseInt(spaces[1]);
		int day = Integer.parseInt(spaces[2]);
		java.sql.Date birth = new java.sql.Date(year, month, day);
		PersonDTO newPerson = new PersonDTO(args[0], birth, args[2], args[3], new MyLinkedList<String>());
		queueOfPeople.enqueue(newPerson);
	}

	public String readAll() {
		return queueOfPeople.toString();
	}
	
	public String readFirst() {
		return queueOfPeople.peek().toString();
	}

	public int dequeue() {
		try {
			queueOfPeople.dequeue();
			return 0;
		} catch (IndexOutOfBoundsException e) {
			e.printStackTrace();
			return -1;
		}
	}

}
