package sfg.util;

public class Pair<T,S> {
	//id of the second vertex
	final T vertex;
	//weight between two vertices
	final S weight;
	
	public Pair(final T _vertex, final S _weight) {
		this.vertex = _vertex;
		this.weight = _weight;
	}
}
