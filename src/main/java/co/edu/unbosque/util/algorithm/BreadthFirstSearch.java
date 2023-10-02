package co.edu.unbosque.util.algorithm;

import co.edu.unbosque.util.Edge;
import co.edu.unbosque.util.MyLinkedList;
import co.edu.unbosque.util.QueueImp;
import co.edu.unbosque.util.Vertex;

public class BreadthFirstSearch extends AbstractSearch{
	

	
	public BreadthFirstSearch(Vertex sourceVertex, Vertex destinationVertex) {
		super(sourceVertex, destinationVertex);
		
		
	}
	
	
	@Override
	public boolean runSearch() {
		if(sourceVertex.equals(destinationVertex)) {
			System.out.println("El objetivo fue encontrado en la anchura 0");
			System.out.println(sourceVertex.getName());
			return true;
		}
		QueueImp<Vertex> queueOfNodes = new QueueImp<Vertex>();
		MyLinkedList<Vertex> visitedNodes = new MyLinkedList<Vertex>();
		System.out.println("Ruta para seguir y llegar al destino: ");
		queueOfNodes.enqueue(sourceVertex);
		visitedNodes.addLast(sourceVertex);
		while (queueOfNodes.size()!=0) {
			Vertex actual = queueOfNodes.dequeue();
			if(actual.equals(destinationVertex)) {
				System.out.println(actual.getName());
				System.out.println("Nodo destino encontrado");
				return true;
			} else {
				System.out.println(actual.getName()+"->");
				if(actual.getEdges().isEmpty()) {
					continue;
				} else {
					MyLinkedList<Edge> adjacents = actual.getEdges();
					while (!adjacents.isEmpty()) {
						queueOfNodes.enqueue(adjacents.extract().getDestination());
					}
				}
			} 
			visitedNodes.addLast(actual);
		}
		return false;
	}

}
