package co.edu.unbosque.util;

import java.util.ArrayList;

public class Graph {

	private MyLinkedList<Vertex> listNodes;

	public Graph() {
		listNodes = new MyLinkedList<Vertex>();
	}

	public MyLinkedList<Vertex> getListNodes() {
		return listNodes;
	}

	public void setListNodes(MyLinkedList<Vertex> listNodes) {
		this.listNodes = listNodes;
	}

	public void addVertex(Vertex newV) {
		listNodes.add(newV);
	}

	@Override
	public String toString() {

		return "La listad de nodos en el grafo es:\n" + listNodes + "\n";
	}

	public Vertex getVertex(String nombre) {
		Node<Vertex> current = listNodes.getFirst();
		while (current != null) {
			Vertex vertex = current.getInfo();
			if (vertex.getName().equals(nombre)) {
				return vertex;
			}
			current = current.getNext();
		}
		return null;
	}

	/*
	 * for (Vertex vertex : listNodes.) { if (vertex.getName().equals(nombre)) {
	 * return vertex; } } return null;
	 * 
	 * for (int i = 0; i < listNodes.size(); i++) { String vertex =
	 * listNodes.get(i).getInfo().getName(); if (vertex.equals(nombre)) { return
	 * vertex; } } return null; }
	 */

}
