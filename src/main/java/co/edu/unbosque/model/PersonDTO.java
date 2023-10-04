package co.edu.unbosque.model;

import java.util.Date;

import co.edu.unbosque.util.MyLinkedList;

public class PersonDTO {
	
	private int id; 
	private String name;

	private String birth;
	private long document;
	private String nationality;
	private MyLinkedList<String> listOfDiseases;
	
	public PersonDTO() {
		this.listOfDiseases = new MyLinkedList<String>();
	}


	public PersonDTO( int id, String name, String birth, long document, String nationality,

			MyLinkedList<String> listOfDiseases) {
		super();
		this.id = id;
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

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {

		this.birth = birth;
	}

	

	public long getDocument() {
		return document;
	}

	public void setDocument(long document) {
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


	public String toString1() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("id: " + name);
		sb.append(" | Name: " + name);
		sb.append(" | Birth date: " + birth);
		sb.append(" | Document: " + document);
		sb.append(" | Nationality: " + nationality);
		sb.append(" | Diseases: " + listOfDiseases.toString() + "\n");
		return sb.toString();
	}

	@Override
	public String toString() {
		return "PersonDTO [listOfDiseases=" + listOfDiseases + "]";
	}

}

