package co.edu.unbosque.model.persistence;

import java.util.Date;

import co.edu.unbosque.model.PersonDTO;
import co.edu.unbosque.util.MyDoubleLinkedList;
import co.edu.unbosque.util.MyLinkedList;

public class PersonDAO implements CRUDOperation{
	
	private MyDoubleLinkedList<PersonDTO> listOfPeople;
	
	public PersonDAO() {
		listOfPeople = new MyDoubleLinkedList<PersonDTO>();
	}

	@Override
	public void create(Object o) {
		int index = listOfPeople.size() + 1;
		listOfPeople.add(index, (PersonDTO) o);
		
	}

	@Override
	public void create(String... args) {
		int index = listOfPeople.size() + 1;
		String[] spaces = args[1].split("-");
		int year = Integer.parseInt(spaces[0]);
		int month = Integer.parseInt(spaces[1]);
		int day = Integer.parseInt(spaces[2]);
		Date birth = new Date(year, month, day);
		PersonDTO newPerson = new PersonDTO(args[0], birth, args[2], args[3], new MyLinkedList<String>());
		listOfPeople.add(index, newPerson);
		
	}

	@Override
	public String readAll() {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<listOfPeople.size(); i++) {
			sb.append(listOfPeople.get(i).toString());
		}
		return sb.toString();
	}

	@Override
	public boolean updateById(int i, Object o) {
		try {
			listOfPeople.set(i, (PersonDTO) o);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateBYName(String name, Object o) {
		try {
			int index = 0;
			searchName: for(int i = 0; i<listOfPeople.size(); i++) {
				index++;
				if(listOfPeople.get(i).getName().equals(name)) {
					break searchName;
				}
			}
			listOfPeople.set(index, (PersonDTO) o);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public int deleteById(int i) {
		try {
			listOfPeople.remove(i);
			return 0;
		} catch (IndexOutOfBoundsException e) {
			e.printStackTrace();
			return -1;
		}
	}

	@Override
	public int deleteByName(String name) {
		try {
			int index = 0;
			searchName: for(int i = 0; i<listOfPeople.size(); i++) {
				index++;
				if(listOfPeople.get(i).getName().equals(name)) {
					break searchName;
				}
			}
			listOfPeople.remove(index);
			return 0;
		} catch (IndexOutOfBoundsException e) {
			e.printStackTrace();
			return -1;
		}
	}

}
