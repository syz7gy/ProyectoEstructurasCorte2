package co.edu.unbosque.model.persistence;

import java.sql.SQLException;

import co.edu.unbosque.model.PersonDTO;
import co.edu.unbosque.util.DBConnection;
import co.edu.unbosque.util.MyLinkedList;
import co.edu.unbosque.util.QueueImp;

public class PersonDAO implements CRUDOperation{
	
	private QueueImp<PersonDTO> queueOfPeople;
	private DBConnection dbcon;
	
	public PersonDAO() {
		queueOfPeople = new QueueImp<PersonDTO>();
		dbcon = new DBConnection();
		
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


	@Override
	public void create(Object o) {
		PersonDTO temp = (PersonDTO) o;
		dbcon.initConnection();
		try {

			dbcon.setPrepareStatement(
			dbcon.getConnect().prepareStatement("INSERT INTO person VALUES (?, ?, ?, ?, ?, ?);"));
			dbcon.getPrepareStatement().setInt(1, 0);
			dbcon.getPrepareStatement().setString(2, temp.getName());
	        dbcon.getPrepareStatement().setString(3, temp.getBirth());
			dbcon.getPrepareStatement().setLong(4, temp.getDocument());
			dbcon.getPrepareStatement().setString(5, temp.getNationality());
			dbcon.getPrepareStatement().setString(6, temp.getListOfDiseases().toString());

			dbcon.getPrepareStatement().executeUpdate();
			dbcon.closeConnection();

		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}

	public void create(int id, String name, String birth, long document, String nationality,
			MyLinkedList<String> listOfDiseases) {

		PersonDTO newPerson = new PersonDTO(id, name, birth, document, nationality,
				listOfDiseases);
		dbcon.initConnection();
		queueOfPeople.enqueue(newPerson);
	}
	@Override
	public boolean updateById(int i, Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateBYName(String name, Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int deleteById(int i) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteByName(String name) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void create(String... args) {
		// TODO Auto-generated method stub
		
	}

}
