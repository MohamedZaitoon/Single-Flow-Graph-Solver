package sfg.util;

import org.junit.Test;

public class UnitTesting {

	@Test
	public void firstSFGTest() {
		Graph g = new Graph();
		g.addEdge(0, 1, 1);
		g.addEdge(1, 2, 1);
		g.addEdge(1, 3, 1);
		g.addEdge(1, 4, 1);
		g.addEdge(2, 1, -1);
		g.addEdge(2, 3, 1);
		g.addEdge(3, 2, -1);
		g.addEdge(3, 4, 1);
		g.addEdge(3, 3, -1);
		g.addEdge(4, 5, 1);
		
		SolverGraph sg = new SolverGraph(g);
		Double tf = sg.calculateOverAllTF(0, 5);
		System.out.println("#1 "+tf);
		assert( tf >= 1.25 &&tf <= 1.3);
	}
	@Test
	public void SecondeSFGTest() {
		Graph g = new Graph();
		g.addEdge(0, 1, 1);
		g.addEdge(0, 2, 1);
		g.addEdge(1, 2, 1);
		g.addEdge(2, 3, 1);
		g.addEdge(3, 2, -1);
		g.addEdge(3, 1, -1);
		g.addEdge(3, 4, 1);

		
		SolverGraph sg = new SolverGraph(g);
		Double tf = sg.calculateOverAllTF(0, 4);
		System.out.println("#2 "+tf);
		assert( tf >= 0.66666666 && tf <=0.67);
	}
	
	@Test
	public void ThirdSFGTest() {
		Graph g = new Graph();
		g.addEdge(0, 1, 1);
		g.addEdge(1, 2, 1);
		g.addEdge(1, 3, 1);
		g.addEdge(2, 1, -1);
		g.addEdge(2, 3, 1);
		g.addEdge(3, 4, 1);
		g.addEdge(4, 3, -1);
		g.addEdge(4, 1, -1);
		g.addEdge(4, 5, 1);

		
		SolverGraph sg = new SolverGraph(g);
		Double tf = sg.calculateOverAllTF(0, 5);
		System.out.println("#3 "+tf);
		assert( tf >= 0.33333333 && tf <=0.34);
	}
	
	@Test
	public void FourthSFGTest() {
		Graph g = new Graph();
		g.addEdge(0, 1, 1);
		g.addEdge(1, 2, 1);
		g.addEdge(1, 4, 1);
		g.addEdge(2, 3, 1);
		g.addEdge(3, 2, -1);
		g.addEdge(3, 5, 1);
		g.addEdge(4, 5, 1);
		g.addEdge(4, 4, -1);
		g.addEdge(5, 1, -1);
		g.addEdge(5, 3, -1);
		g.addEdge(5, 6, 1);

		
		SolverGraph sg = new SolverGraph(g);
		Double tf = sg.calculateOverAllTF(0, 6);
		System.out.println("#4 "+tf);
		assert( tf >= 0.4 && tf <=0.5);
	}
	
	@Test
	public void FivethSFGTest() {
		Graph g = new Graph();
		g.addEdge(0, 1, 1);
		g.addEdge(1, 2, 1);
		g.addEdge(2, 7, 1);
		g.addEdge(2, 3, 1);
		g.addEdge(3, 4, 1);
		g.addEdge(4, 5, 1);
		g.addEdge(5, 6, 1);
		g.addEdge(5, 2, -1);
		g.addEdge(6, 7, 1);
		g.addEdge(7, 4, -1);
		g.addEdge(7, 1, -1);
		g.addEdge(7, 8, 1);

		
		SolverGraph sg = new SolverGraph(g);
		Double tf = sg.calculateOverAllTF(0, 8);
		System.out.println("#5 "+tf);
		assert( tf >= 0.5 && tf <=0.5);
	}
	
	@Test
	public void SixthSFGTest() {
		Graph g = new Graph();
		g.addEdge(0, 1, 1);
		g.addEdge(1, 2, 1);
		g.addEdge(2, 3, 1);
		g.addEdge(3, 4, 1);
		g.addEdge(3, 6, 1);
		g.addEdge(4, 5, 1);
		g.addEdge(5, 4, -1);
		g.addEdge(5, 6, 1);
		g.addEdge(5, 7, 1);
		g.addEdge(6, 7, 1);
		g.addEdge(6, 2, -1);
		g.addEdge(7, 5, -1);
		g.addEdge(7, 1, -1);
		g.addEdge(7, 8, 1);

		
		SolverGraph sg = new SolverGraph(g);
		Double tf = sg.calculateOverAllTF(0, 8);
		System.out.println("#6 "+tf);
		assert( tf >= 0.33333 && tf <=0.4);
	}
	
	@Test
	public void SeventhSFGTest() {
		Graph g = new Graph();
		g.addEdge(0, 1, 1);
		g.addEdge(1, 2, 1);
		g.addEdge(2, 3, 1);
		g.addEdge(2, 1, -1);
		g.addEdge(3, 4, 1);
		g.addEdge(4, 3, -1);
		g.addEdge(4, 5, 1);
		g.addEdge(5, 6, 1);
		g.addEdge(6, 5, -1);
		g.addEdge(6, 7, 1);

		
		SolverGraph sg = new SolverGraph(g);
		Double tf = sg.calculateOverAllTF(0, 7);
		System.out.println("#7 "+tf);
		assert( tf >= 0.125 && tf <=0.13);
	}
	
	@Test
	public void eightthSFGTest() {
		Graph g = new Graph();
		g.addEdge(0, 1, 1);
		g.addEdge(1, 2, 1);
		g.addEdge(2, 3, 1);
		g.addEdge(2, 1, -1);
		g.addEdge(3, 4, 1);
		g.addEdge(4, 3, -1);
		g.addEdge(4, 5, 1);
		g.addEdge(5, 6, 1);
		g.addEdge(6, 5, -1);
		g.addEdge(6, 7, 1);
		g.addEdge(7, 8, 1);
		g.addEdge(8, 7, -1);
		g.addEdge(8, 9, 1);

		
		SolverGraph sg = new SolverGraph(g);
		Double tf = sg.calculateOverAllTF(0, 9);
		System.out.println("#8 "+tf);
		assert( tf >= 0.0625 && tf <=0.1);
	}

}
