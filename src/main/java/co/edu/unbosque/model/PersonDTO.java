package co.edu.unbosque.model;

import java.util.Date;

import co.edu.unbosque.util.MyLinkedList;

public class PersonDTO {
	
	private int id;
	private String name;
	private Date birth;
	private String document;
	private String nationality;
	private MyLinkedList<String> listOfDiseases;
	
	public PersonDTO() {
		this.listOfDiseases = new MyLinkedList<String>();
	}

	public PersonDTO(int id, String name, Date birth, String document, String nationality,
			MyLinkedList<String> listOfDiseases) {
		super();
		this.name = name;
		this.birth = birth;
		this.document = document;
		this.nationality = nationality;
		this.listOfDiseases = listOfDiseases;
	}

	


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public MyLinkedList<String> getListOfDiseases() {
		return listOfDiseases;
	}

	public void setListOfDiseases(MyLinkedList<String> listOfDiseases) {
		this.listOfDiseases = listOfDiseases;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("id: " + id);
		sb.append(" | Name: " + name);
		sb.append(" | Birth date: " + birth);
		sb.append(" | Document: " + document);
		sb.append(" | Nationality: " + nationality);
		sb.append(" | Diseases: " + listOfDiseases.toString() + "\n");
		return sb.toString();
	}
	

}
