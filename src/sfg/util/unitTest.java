package sfg.util;

public class unitTest {

	
	public static void main(String[] args) {
		Graph g = new Graph();
		/*g.addEdge(0, 1,2);
		g.addEdge(0, 2,2);
		g.addEdge(0, 3,2);
		g.addEdge(1, 3,2);
		g.addEdge(1, 4,2);
		g.addEdge(1, 2,2);
		g.addEdge(2, 3,2);
		g.addEdge(3, 2,2);
		g.addEdge(3, 3,2);
		g.print();*/
		/*g.addEdge(0, 1,1);
		g.addEdge(1, 1,1);
		
		g.addEdge(1, 2,3);
		g.addEdge(2, 3,4);
		g.addEdge(3, 4,5);
		g.addEdge(3, 2,6);
		g.addEdge(2, 4,7);
		g.addEdge(3, 3,8);
		g.addEdge(2, 2,9);
		g.addEdge(1, 3,10);
		g.addEdge(1, 5,10);
		g.addEdge(5, 2,10);
		g.addEdge(4, 1,11);*/
		
	/*	g.addEdge(0, 1,1);
		g.addEdge(0, 3,1);
		
		g.addEdge(1, 0,1);
		g.addEdge(1, 2,1);
		g.addEdge(2, 1,1);
		g.addEdge(2, 2,1);
		g.addEdge(2, 3,1);
		g.addEdge(3, 2,1);
		g.addEdge(3, 1,1);
		g.addEdge(3, 0,1);*/
		
		
		/*g.addEdge(0, 1,1);
		g.addEdge(1, 2,1);
		g.addEdge(1, 3,1);
		g.addEdge(1, 6,1);
		g.addEdge(2, 1,1);
		g.addEdge(2, 3,1);
		g.addEdge(3, 2,1);
		g.addEdge(3, 4,1);
		g.addEdge(4, 3,1);
		g.addEdge(4, 5,1);
		g.addEdge(5, 4,1);
		g.addEdge(5, 6,1);
		g.addEdge(6, 5,1);
		g.addEdge(6, 7,1);
		g.addEdge(6, 6,1);
		g.addEdge(6, 4,1);
		g.addEdge(0, 0,1);
		g.addEdge(7, 7,1);*/
		/*g.addEdge(0, 1,1);
		g.addEdge(3, 0,-3);
		g.addEdge(0, 3,4);
		g.addEdge(1, 2,2);
		g.addEdge(2, 3,3);
		g.addEdge(2, 1,-5);*/
		g.addEdge(1, 2,1);
		g.addEdge(0, 1,1);
		g.addEdge(2, 3,5);
		g.addEdge(2, 6,10);
		g.addEdge(3, 4,10);
		g.addEdge(4, 5,2);
		g.addEdge(5, 7,1);
		g.addEdge(5, 4,-2);
		g.addEdge(4, 3,-1);
		g.addEdge(5, 2,-1);
		g.addEdge(6, 6,-1);
		g.addEdge(6, 5,2);

		SolverGraph sg = new SolverGraph(g);
//		g.print();
		/*System.out.println();
		ArrayList<Path<Integer,Integer>> a = (ArrayList<Path<Integer,Integer>>) sg.getForwardPaths(1, 5);
		if(a!= null)
		for(Path<Integer,Integer> p : a)System.out.println(p.toString());
		System.out.println("#############################");
		a = (ArrayList<Path<Integer,Integer>>) sg.getLoops();
		if(a!= null)
		for(Path<Integer,Integer> p : a)System.out.println(p.toString());
		*/System.out.println("#########################");
//		System.out.println(sg.getNonTouchingLoops());
//		System.out.println(sg.calculateDelta());
		String c = String.format("%.5g", sg.calculateOverAllTF(0,5));
		System.out.println(c);
		
		
	}
}
