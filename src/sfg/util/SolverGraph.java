package sfg.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Stack;

public class SolverGraph {
	
	/**
	 * the graph that will be solved.
	 */
	private Graph g;
	/**
	 * forward paths from specific node to other one.
	 */
	private ArrayList<Path<Integer, Integer>> forwardPaths;
	/**
	 * All loops in graph (g)
	 */
	private ArrayList<Path<Integer, Integer>> loops;
	/**
	 * All 2 to n non-touching loops
	 */
	private ArrayList<ArrayList<NTLoop>> nonTouchingLoops;
	/**
	 * The second node to which we get and calculate the forward paths and their
	 * gain
	 */
	 private Integer des;
	 	
	 private Integer src;
	/**
	 * It is used to get path or loop during DFS recursion whether to Forward path
	 * or loop DFS
	 */
	private Stack<Integer> s;
	/**
	 * Make the vertex be visited when we recurs on this vertex
	 */
	boolean[] visited;
	/**
	 * used to prevent repeated loops.
	 */
	boolean[] explored;
	/**
	 * Adjacency matrix of graph.
	 */
	Integer[][] mat;
	/**
	 * Number of vertex in graph.
	 */
	
	int noVerticies;
	
	HashMap<Path<Integer, Integer>, Integer> deltaNGain;
	
	Integer delta;
	/**
	 * Constructor.
	 * 
	 * @param _g
	 */
	public SolverGraph(Graph _g) {
		this.g = _g;
		mat = g.getAdjMat();
		deltaNGain = new HashMap<>();
	}

	/**
	 * @param v1 beginning vertex
	 * @param v2 destination vertex
	 * @return forward paths from v1 to v2
	 */
	public ArrayList<Path<Integer, Integer>> getForwardPaths(Integer v1, Integer v2) {
		if (v1.equals(v2)) {
			return null;
		}
		noVerticies = g.adj.size();
		visited = new boolean[noVerticies];
		forwardPaths = new ArrayList<>();
		s = new Stack<>();
		des = v2;
		dfs(v1);
		return forwardPaths;

	}

	/**
	 * DFS for forward paths
	 * 
	 * @param v the current vertex on which we apply dfs
	 */
	private void dfs(Integer v) {
		if (v.equals(des)) {// base case -- found destination
			Path<Integer, Integer> p = getForwardPath();
			forwardPaths.add(p);
			return;
		}
		visited[v] = true;
		s.push(v);
		for (Edge<Integer, Integer> i : g.adj.get(v)) {
			if (!visited[(int) i.vertex]) {
				dfs(i.vertex);
				visited[(int) i.vertex] = false;
			}
		}
		visited[v] = false;
		s.pop();
	}

	/**
	 * Getting Forward path ,that is stored in stack.
	 * 
	 * @return
	 */
	private Path<Integer, Integer> getForwardPath() {
		Iterator<Integer> it = s.iterator();// this iterator is for iterating from first vertex to des
		Path<Integer, Integer> p = new Path<>();
		Integer prev = null;
		Integer temp = null;
		if (it.hasNext()) {
			prev = (Integer) it.next();
			p.addVertex(prev);
		}
		while (it.hasNext()) {
			temp = (Integer) it.next();
			p.addVertex(temp);
			p.addGain(mat[prev][temp]);
			prev = temp;
		}
		p.addVertex(des);
		p.addGain(mat[prev][des]);
		return p;
	}

	/**
	 * Getting all loops in graph.
	 * 
	 * @return
	 */
	public ArrayList<Path<Integer, Integer>> getLoops() {
		noVerticies = g.adj.size();
		visited = new boolean[noVerticies];
		explored = new boolean[noVerticies];
		loops = new ArrayList<>();
		s = new Stack<>();
		cDfs(0);
		return loops;
	}

	/**
	 * loop dfs
	 * @param v
	 * @return
	 */
	private void cDfs(Integer v) {
		if (visited[v]) {// base case
			if (explored[v])// to prevent getting repeated loop
				return;
			Path<Integer, Integer> p = getLoop(v);
			loops.add(p);
			return;
		} else {
			visited[v] = true;
			s.push(v);
			for (Edge<Integer, Integer> i : g.adj.get(v)) {
				cDfs(i.vertex);
			}
			s.pop();// backtracking
			visited[v] = false;
			explored[v] = true;// mark this vertex to not get any loop on it again
		}

	}

	/**
	 * get loop from the stack
	 * 
	 * @param v vertex that we found loop on it. ex. 1 2 4 1 ===> v = 1 on this case
	 * @return loop
	 */
	private Path<Integer, Integer> getLoop(Integer v) {
		Path<Integer, Integer> p = new Path<>();
		Stack<Integer> temp = new Stack<>();
		while (!s.peek().equals(v))
			temp.push(s.pop());
		Integer prev = v;
		p.addVertex(v);
		while (!temp.isEmpty()) {
			p.addVertex(temp.peek());
			p.addGain(mat[prev][temp.peek()]);
			prev = temp.peek();
			s.push(temp.pop());
		}
		p.addGain(mat[prev][v]);
		return p;
	}

	/**
	 * get non-touching loops
	 * 
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ArrayList<ArrayList<NTLoop>> getNonTouchingLoops() {
		nonTouchingLoops = new ArrayList<>();
		getLoops();
		// first level add
//		System.out.println("# 1");
		ArrayList<NTLoop> x = new ArrayList<>();
		for (Path i : loops) {
			NTLoop nl = new NTLoop();
			nl.addLoop(i);
			x.add(nl);
			
//			System.out.println(nl.toString());
		}
		if (x.isEmpty())
			return null;
		nonTouchingLoops.add(x);
		nNonToutchinLoops(1);
		return nonTouchingLoops;
	}
	/**
	 *recursive function to calculate n level non-touching loops.
	 * @param n n-th level
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void nNonToutchinLoops(int n) {
		ArrayList<NTLoop> x = new ArrayList<>();// store new level in x
		ArrayList<NTLoop> prevLevel = nonTouchingLoops.get(n - 1);// previous level
		int plSize = prevLevel.size();// prevLevel size
		for (int i = 0; i < plSize - 1; i++) {
			NTLoop k = prevLevel.get(i);// non-touching loops
			Path pk = k.loops.get(k.loops.size() - 1);// get last loop from this non-touching loops
			int sk = k.loops.size();
			for (int j = i + 1; j < plSize; j++) {
				NTLoop m = prevLevel.get(j);// next non-touching loops on this level
				int sm = m.loops.size();
				// n == 1 for getting 2 non-touching loop
				// check first loop of k & m  equal  and previous last loop either to continue or not 
				if (n == 1 ||
						(k.loops.get(0) == m.loops.get(0) && k.loops.get(sk - 2) == m.loops.get(sm - 2))) {
					Path p = m.loops.get(sm - 1);
					if (!pk.isIntersect(p)) {
						NTLoop newNTLoop = new NTLoop();
						newNTLoop.loops = (ArrayList<Path<Integer, Integer>>) k.loops.clone();
						newNTLoop.addLoop(p);
						x.add(newNTLoop);
//						System.out.println(newNTLoop);
					}
				} else {
					break;
				}
			}
		}
		if (x.isEmpty())//if there is not new level stop searching
			return;
		nonTouchingLoops.add(x);
		nNonToutchinLoops(n + 1);

	}

	public void calculateDeltaN() {
//		System.out.println("Delta");
		if(nonTouchingLoops == null || nonTouchingLoops.isEmpty())getNonTouchingLoops();
		if(forwardPaths == null || forwardPaths.isEmpty())getForwardPaths(src,des);
		HashMap<Path<Integer,Integer>,ArrayList<ArrayList<NTLoop>>> deltan= new HashMap<>();
		Path<Integer,Integer> p;
		Path<Integer,Integer> p2;
		int noLevel = nonTouchingLoops.size();
		Integer one = 1;
		for(int i = 0; i < forwardPaths.size(); i++) {
			p = forwardPaths.get(i);
//			System.out.println("path #"+i+" "+p.toString());
			deltan.put(p,new ArrayList<>());
			Integer gn = 1;
			one = 1;
			for(int j = 0; j < noLevel; j++) {
				deltan.get(p).add (new ArrayList<>());
//				System.out.println("#"+j);
				one *=-1;
				for(NTLoop k : nonTouchingLoops.get(j)) {
					p2 = k.getmergedLoop();
					if(!p.isIntersect(p2)) {
						deltan.get(p).add (new ArrayList<>());
						deltan.get(p).get(j).add(k);
						gn+=one*k.getGain();
//						System.out.println(k.toString());
					}
				}
			}
			deltaNGain.put(p, gn);
		}
	}
	public Integer calculateDelta() {
		int one = 1;
		delta = 1;
		for(int i = 0; i < nonTouchingLoops.size();i++) {
			ArrayList<NTLoop> a = nonTouchingLoops.get(i);
			one *=-1;
			for(NTLoop ntl : a) {
				delta += one * ntl.getGain();
			}
		}
		return delta;
	}
	
	public Double calculateOverAllTF(Integer input, Integer output) {
		if (input == null || output == null) return null;
		this.des = output;
		this.src = input;
		Double tf;
		calculateDeltaN();
		delta = calculateDelta();
		Integer summation =0;
		
		for(Path p : forwardPaths) {
			Integer t = deltaNGain.get(p);
			Integer fg = (Integer) p.getGain();
			summation += t * fg;
		}
		
		tf = summation.doubleValue()/delta.doubleValue();
		
		return tf;
	}
	
}
