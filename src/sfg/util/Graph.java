package sfg.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Graph {
	/**
	 * Adjacency list for representing the graph.
	 */
	public Map<Integer, ArrayList<Edge<Integer,Integer>>> adj;

	public Graph() {
		adj = new HashMap<Integer, ArrayList<Edge<Integer,Integer>>>();
	}

	public void addEdge(Integer v, Integer v2, Integer w) {
		if (adj.get(v) == null)
			adj.put(v, new ArrayList<>());
		if (adj.get(v2) == null)
			adj.put(v2, new ArrayList<>());
		adj.get(v).add(new Edge<Integer,Integer>(v2, w));

	}

	/**
	 * Get adjacency matrix
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Integer[][] getAdjMat(){
		int sz = adj.size();
		Integer[][] mat = new Integer[sz][sz];
		Set s  = adj.entrySet();
		Iterator it = s.iterator();
		while(it.hasNext()) {
			Map.Entry ent = (Entry) it.next();
			Integer v = (Integer) ent.getKey();
			ArrayList<Edge<Integer, Integer>> a = (ArrayList<Edge<Integer, Integer>>) ent.getValue();
			for(Edge<Integer, Integer> e : a) {
				mat[v][e.vertex] = e.weight;
			}
		}
		return mat;
	}

	 

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void print() {
		Set set = adj.entrySet();
		Iterator it = set.iterator();
		while (it.hasNext()) {
			Map.Entry ent = (Entry) it.next();
			System.out.print(ent.getKey() + "->");
			ArrayList<Edge<Integer, Integer>> l = (ArrayList<Edge<Integer, Integer>>) ent.getValue();
			for (Edge e : l) {
				System.out.print(e.vertex + " - ");
			}
			System.out.println();
		}
	}

}
