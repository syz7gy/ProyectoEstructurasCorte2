package co.edu.unbosque.model;

import co.edu.unbosque.util.MyLinkedList;

public class PlaceDTO {
	
	private String name;
	private MyLinkedList<PersonDTO>  listOfVisitors;
	
	public PlaceDTO() {
		this.listOfVisitors = new MyLinkedList<PersonDTO>();
	}

	public PlaceDTO(String name, MyLinkedList<PersonDTO> listOfVisiters) {
		super();
		this.name = name;
		this.listOfVisitors = listOfVisiters;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MyLinkedList<PersonDTO> getListOfVisiters() {
		return listOfVisitors;
	}

	public void setListOfVisiters(MyLinkedList<PersonDTO> listOfVisiters) {
		this.listOfVisitors = listOfVisiters;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\nName: " +  name);
		sb.append("\nVisitors: " + listOfVisitors.toString() + "\n");
		return sb.toString();
	}
	
	

}
