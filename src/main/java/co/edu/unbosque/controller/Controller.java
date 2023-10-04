package co.edu.unbosque.controller;

import java.util.Date;
import java.util.Random;

import co.edu.unbosque.model.PersonDTO;
import co.edu.unbosque.model.persistence.PersonDAO;
import co.edu.unbosque.model.persistence.PlaceDAO;
import co.edu.unbosque.util.Edge;
import co.edu.unbosque.util.Graph;
import co.edu.unbosque.util.MyLinkedList;
import co.edu.unbosque.util.Vertex;
import co.edu.unbosque.view.Console;

public class Controller {

	private Console con;
	private PersonDAO perDao;
	private PlaceDAO plDao;

	public Controller() {
		perDao = new PersonDAO();
		plDao = new PlaceDAO();
		con = new Console();
		execute();

	}

	public void execute() {

		mainMenu: while (true) {
			con.printLine("Seleccionar opcion:");
			con.printLine(
					"1) Encolar paciente \n2) Despachar paciente \n3) Mostrar primer paciente \n4) Mostrar todos los pacientes "
					+ "\n5) Mostrar lugares ");
			con.printLine("6) Cerrar");
			int opcion = con.nextInt();

			switch (opcion) {
			case 1: {
				Graph grafito = new Graph();
				MyLinkedList<String> listOfDiseases = new MyLinkedList<String>();
				con.printLine("Nombre:");
				String name = con.next();
				con.printLine("Nacimiento: ");
				String fecha = con.next();
				String[] spaces = fecha.split("-");
				int year = Integer.parseInt(spaces[0]);
				int month = Integer.parseInt(spaces[1]);
				int day = Integer.parseInt(spaces[2]);
				java.sql.Date birth = new java.sql.Date(year, month, day);
				con.printLine("Documento: ");
				String doc = con.next();
				con.printLine("Nacionalidad:");
				String naci = con.next();
				con.printLine("Cuántas enfermedades posee?");
				int numEn = con.nextInt();
				for (int i = 0; i < numEn; i++) {
					con.printLine("Digite la enfermedad que posee:");
					String disease = con.next();
					listOfDiseases.add(disease);
				}
				PersonDTO newPerson = new PersonDTO(name, birth, doc, naci, listOfDiseases);

				if (perDao.getQueueOfPeople().size() < 1) {
					Vertex person = new Vertex(name);
					grafito.addVertex(person);
					perDao.enqueue(newPerson);
					int cantidadLugares = 5;
					for(int i = 0; i<=5; i++) {
						con.printLine("Indique a los ultimos 5 de los siguientes lugares que ha visitado (Faltan " + cantidadLugares + "):");
						con.printLine(plDao.showNames());
						cantidadLugares--;
						String placeName = con.next();
						plDao.addPerson(placeName, newPerson);
					}
				} else {
					Vertex person = new Vertex(name);
					Random randomNum = new Random(perDao.getQueueOfPeople().size());
					int r = randomNum.nextInt();
					PersonDTO ranPerson = perDao.getQueueOfPeople().get(r);
					Vertex destination = new Vertex();
					perDao.enqueue(newPerson);
					int cantidadLugares = 5;
					for(int i = 1; i<5; i++) {
						con.printLine("Indique a los ultimos 5 de los siguientes lugares que ha visitado (Faltan " + cantidadLugares + "):");
						con.printLine(plDao.showNames());
						String placeName = con.next();
						plDao.addPerson(placeName, newPerson);
						cantidadLugares--;
					}
					perDao.getQueueOfPeople().getData(newPerson);
					Random randomSelect = new Random(3);
					double randomWeight = randomSelect.nextDouble();
					person.addEdge(new Edge(person, destination, randomWeight));
				}
				con.printLine("Parámetros del paciente satisfechos. \nPciente ingresado con exito");
				break;
			}
			case 2: {
				if (perDao.getQueueOfPeople().size() == 0) {
					con.printLine("No hay pacientes a los cuales despachar");
				} else if(perDao.getQueueOfPeople()!=null) {
					con.printLine("Indique la cantidad de pacientes a despachar:");
					int amount = con.nextInt();
					if(amount<=perDao.getQueueOfPeople().size()) {
						dequeuePacient: for (int i = 0; i<amount; i++) {
							perDao.dequeue();
							if (perDao.getQueueOfPeople()==null) {
								con.printLine("No quedan pacientes por despachar");
								break dequeuePacient;
							}
						}
					} else {
						con.printLine("El numero es mayor a la cantidad de pacientes disponibles. "
								+ "\nVolviendo al menu principal");
						continue mainMenu;
					}
					
				}
				break;
			}
			case 3: {
				con.printLine(perDao.readFirst());
				break;
			}
			case 4: {
				con.printLine(perDao.readAll());
				break;
			}
			case 5: {
				con.printLine(plDao.readAll());
				break;
			}
			case 6: {
				System.exit(0);
			}
			}
		}

	}

}
