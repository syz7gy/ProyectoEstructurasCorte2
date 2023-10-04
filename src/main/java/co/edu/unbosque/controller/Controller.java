package co.edu.unbosque.controller;

import java.util.Date;
import java.util.Random;

import co.edu.unbosque.model.PersonDTO;
import co.edu.unbosque.model.persistence.PersonDAO;
import co.edu.unbosque.model.persistence.PlaceDAO;
import co.edu.unbosque.util.DBConnection;
import co.edu.unbosque.util.Edge;
import co.edu.unbosque.util.Graph;
import co.edu.unbosque.util.MyLinkedList;
import co.edu.unbosque.util.Vertex;
import co.edu.unbosque.view.Console;

public class Controller {

	private Graph grafito;
	private MyLinkedList<String> listOfDiseases;
	private Console con;
	private PersonDAO perDao;
	private PlaceDAO plDao;
	private DBConnection dbcon;

	public Controller() {
		perDao = new PersonDAO();
		plDao = new PlaceDAO();
		grafito = new Graph();
		dbcon = new DBConnection();
		listOfDiseases = new MyLinkedList<String>();
		con = new Console();
		execute();

	}

	public void execute() {

		mainMenu: while (true) {
			con.printLine("Seleccionar opcion:");
			con.printLine(
					"1) Encolar paciente \n2) Despachar paciente \n3) Mostrar primer paciente \n4) Mostrar todos los pacientes \n5) Cerrar ");
			int opcion = con.nextInt();
			si : while(true) {
			switch (opcion) {
			case 1: {
				 
				con.printLine("Nombre:");
				String name = con.next();
				con.printLine("Nacimiento: ");
				String date = con.next();
				con.printLine("Documento: ");
				Long doc = con.nextLong();
				con.printLine("Nacionalidad:");
				String naci = con.next();
				con.printLine("Cuántas enfermedades posee?");
				int numEn = con.nextInt();
				for (int i = 0; i < numEn; i++) {
					con.printLine("Digite la enfermedad que posee:");
					String disease = con.next();
					listOfDiseases.add(disease);
				}
				con.printLine("Parámetros del paciente satisfechos. \nPciente ingresado con exito");

				perDao.create(new PersonDTO(0, name, date, doc, naci, listOfDiseases));
				PersonDTO newPerson = new PersonDTO(0,name, date, doc, naci, listOfDiseases);
				perDao.enqueue(newPerson);
				plDao.addPerson(newPerson);

				if (perDao.getQueueOfPeople().size() <= 1) {
					Vertex person = new Vertex(name);
					perDao.enqueue(newPerson);
					plDao.addPerson(newPerson);
				} else if (perDao.getQueueOfPeople().size() > 1) {
					Vertex person = new Vertex(name);
					Random randomNum = new Random(perDao.getQueueOfPeople().size());
					int r = randomNum.nextInt();
					PersonDTO ranPerson = perDao.getQueueOfPeople().get(r);
					Vertex destination = new Vertex();
					perDao.enqueue(newPerson);
					plDao.addPerson(newPerson);
					perDao.getQueueOfPeople().getData(newPerson);
					Random randomSelect = new Random(3);
					double randomWeight = randomNum.nextDouble();
					person.addEdge(new Edge(person, destination, randomWeight));
				}
				break si;
			}
			case 2: {
				if (perDao.getQueueOfPeople() == null) {
					con.printLine("No hay pacientes a los cuales despachar");
				} else {
					dequeuePacient: while (perDao.getQueueOfPeople() != null) {
						if (perDao.getQueueOfPeople() == null) {
							con.printLine("No quedan pacientes por despachar");
							break dequeuePacient;
						}
					}
				}
				break si;
			}
			case 4: {
				con.printLine(perDao.readAll());
				break si;
			}
			case 5: {
				System.exit(0);
			}
			}
			}
		}

	}

}
