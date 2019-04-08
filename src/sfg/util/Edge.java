package sfg.util;

public class Edge<T,S> {
	//id of the second vertex
	final T vertex;
	//weight between two vertices
	final S weight;
	
	public Edge(final T _vertex, final S _weight) {
		this.vertex = _vertex;
		this.weight = _weight;
	}
}
