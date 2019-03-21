package sfg.util;

import java.util.ArrayList;

public class NTLoop{
	public ArrayList<Path<Integer, Integer>> loops;
	Integer overAllGain = null;
	public NTLoop(int size){
		this.loops = new ArrayList<>(size);
	}
	public NTLoop(){
		this.loops = new ArrayList<>();
	}
	public void addLoop(Path<Integer,Integer> p) {
		loops.add(p);
	}
	@SuppressWarnings("rawtypes")
	public Integer getGain() {
		if(overAllGain != null) return overAllGain;
		Integer x = 1;
		for(Path p : loops) {
			x *= (Integer) p.getGain();
		}
		overAllGain = x;
		return x;
	}
	public Path<Integer,Integer> getmergedLoop(){
		if(loops.size() == 1) return loops.get(0);
		Path<Integer, Integer> p = new Path<>();
		for(Path<Integer, Integer> i:loops) {
			for(Integer j : i.path) {
				p.addVertex(j);
			}
		}
		return p;
		
	}
	
	
	@SuppressWarnings("rawtypes")
	public String toString() {
		String s = "";
		for(Path i : loops) s+= " "+i.toString();
		return s;
	}

	
}
