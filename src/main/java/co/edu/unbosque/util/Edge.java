package co.edu.unbosque.util;

public class Edge {
	
	private Vertex source;
	private Vertex destination;
	private double wight;
	
	public Edge() {
		// TODO Auto-generated constructor stub
	}
	
	public Edge(Vertex source, Vertex destination, double wight) {
		super();
		this.source = source;
		this.destination = destination;
		this.wight = wight;
	}

	public Vertex getSource() {
		return source;
	}

	public void setSource(Vertex source) {
		this.source = source;
	}

	public Vertex getDestination() {
		return destination;
	}

	public void setDestination(Vertex destination) {
		this.destination = destination;
	}

	public double getWight() {
		return wight;
	}

	public void setWight(double wight) {
		this.wight = wight;
	}

	@Override
	public String toString() {
		return "Edge [source=" + source.getName() + ", destination=" + destination.getName() + ", wight=" + wight + "]\n";
	}
	

}
