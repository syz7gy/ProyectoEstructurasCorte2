package co.edu.unbosque.util.algorithm;

import co.edu.unbosque.util.Edge;
import co.edu.unbosque.util.MyLinkedList;
import co.edu.unbosque.util.StackImp;
import co.edu.unbosque.util.Vertex;

public class DepthFirstSearch extends AbstractSearch {

	private StackImp<Vertex> stackOfNodes;
	private MyLinkedList<Vertex> visitedNodes;

	public DepthFirstSearch(Vertex sourceVertex, 
			Vertex destinationVertex) {
		super(sourceVertex, destinationVertex);
		stackOfNodes= new StackImp<>();
		visitedNodes= new MyLinkedList<>();
	}

	@Override
	public boolean runSearch() {
		if (this.sourceVertex.equals(this.destinationVertex)) {
			System.out.println("Nodo destino encontrado a 0 de profundidad");
			System.out.println(sourceVertex.getName());
			return true;
		}
		stackOfNodes.push(sourceVertex);
		System.out.println("Ruta a seguir para ubicar el nodo");
		while (stackOfNodes.size() != 0) {
			Vertex actual = stackOfNodes.pop();
			if (actual.equals(this.destinationVertex)) {
				System.out.println(destinationVertex.getName());
				System.out.println("Nodo buscado encontrado");
				return true;
			} else {
				System.out.print(actual.getName() + "->");
				visitedNodes.addLast(actual);
				MyLinkedList<Edge> adyacents = actual.getEdges();
				while (!adyacents.isEmpty()) {
					stackOfNodes.push(adyacents.extract().getDestination());

				}

			}
		}
		return false;
	}

	public StackImp<Vertex> getStackOfNodes() {
		return stackOfNodes;
	}

	public void setStackOfNodes(StackImp<Vertex> stackOfNodes) {
		this.stackOfNodes = stackOfNodes;
	}

	public MyLinkedList<Vertex> getVisitedNodes() {
		return visitedNodes;
	}

	public void setVisitedNodes(MyLinkedList<Vertex> visitedNodes) {
		this.visitedNodes = visitedNodes;
	}

}
