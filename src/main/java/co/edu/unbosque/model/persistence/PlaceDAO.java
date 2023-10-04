package co.edu.unbosque.model.persistence;

import co.edu.unbosque.model.PersonDTO;
import co.edu.unbosque.model.PlaceDTO;
import co.edu.unbosque.util.MyDoubleLinkedList;
import co.edu.unbosque.util.MyLinkedList;

public class PlaceDAO implements CRUDOperation {

	private MyDoubleLinkedList<PlaceDTO> listOfPlaces;
	private PlaceDTO currentPlace;

	public PlaceDAO() {
		listOfPlaces = initList();
		currentPlace = new PlaceDTO();
	}

	public MyDoubleLinkedList<PlaceDTO> getListOfPlaces() {
		return listOfPlaces;
	}

	public void setListOfPlaces(MyDoubleLinkedList<PlaceDTO> listOfPlaces) {
		this.listOfPlaces = listOfPlaces;
	}
	
	public MyDoubleLinkedList<PlaceDTO> initList() {
		MyDoubleLinkedList<PlaceDTO> places = new MyDoubleLinkedList<PlaceDTO>();
		String[] names = {"Banco", "Centro Comercial", "Cine", "Universidad", "Supermercado", "Tienda de ropa", "Restaurante", "Biblioteca"};
		for (int i = 0; i<names.length; i++) {
			PlaceDTO newPlace = new PlaceDTO(names[i], new MyLinkedList<PersonDTO>());
			places.add(i + 1, newPlace);
		}
		return places;
	}
	
	public void addPerson(String name, PersonDTO newPerson) {
		PlaceDTO currentPlace = null;
		for(int i = 0; 1<listOfPlaces.size(); i++) {
			currentPlace = listOfPlaces.getData(i);
			if(currentPlace.getName().equals(name)) {
				break;
			}
		}
		currentPlace.getListOfVisiters().add(newPerson);
	}

	@Override
	public void create(Object o) {
		int index = listOfPlaces.size() + 1;
		currentPlace = (PlaceDTO) o;
		listOfPlaces.add(index, currentPlace);
	}

	@Override
	public void create(String... args) {
		int index = listOfPlaces.size() + 1;
		listOfPlaces.add(index, new PlaceDTO(args[0], new MyLinkedList<PersonDTO>()));
	}

	@Override
	public String readAll() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < listOfPlaces.size(); i++) {
			sb.append(listOfPlaces.getData(i));
		}
		return sb.toString();
	}
	
	public String showNames() {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<listOfPlaces.size(); i++) {
			sb.append(listOfPlaces.getData(i).getName() + ", ");
		}
		return sb.toString();
	}

	@Override
	public boolean updateById(int i, Object o) {
		try {
			currentPlace = (PlaceDTO) o;
			listOfPlaces.set(i, currentPlace);
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
			searchName: for (int i = 0; i < listOfPlaces.size(); i++) {
				index++;
				if (listOfPlaces.get(i).getInfo().getName().equals(name)) {
					break searchName;
				}
			}
			currentPlace = (PlaceDTO) o;
			listOfPlaces.set(index, currentPlace);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public int deleteById(int i) {
		try {
			listOfPlaces.remove(i);
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
			searchName: for(int i = 0; i<listOfPlaces.size(); i++) {
				index++;
				if(listOfPlaces.get(i).getInfo().getName().equals(name)) {
					break searchName;
				}
			}
			listOfPlaces.remove(index);
			return 0;
		} catch (IndexOutOfBoundsException e) {
			e.printStackTrace();
			return -1;
		}
	}

}
