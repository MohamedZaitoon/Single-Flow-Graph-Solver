package sfg.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Path <T,S> {

	private static Integer dummy = 1; 
	public List<T> path;
	public List<S> gain;
	Integer overAllGain = null;
	public Path() {
		this.path = new ArrayList<T>();
		this.gain = new ArrayList<S>();
	}
	public Path(ArrayList<T> p) {
		this.path = p;
	}
	public void addVertex(T v) {
		this.path.add(v);
	}
	public void addGain(S g) {
		this.gain.add(g);
	}
	@SuppressWarnings({ "unchecked"})
	public S getGain() {
		if(gain.get(0) instanceof Integer) {
			if(overAllGain != null) return (S) overAllGain;
			Integer x = 1;
			ArrayList<Integer> m = (ArrayList<Integer>) gain;
			for(Integer c : m) {
				x *= c;
			}
			overAllGain = x;
			return (S)x;
		}else {
			String s = "";
			ArrayList<String> m = (ArrayList<String>) gain;
			for(String c : m) {
				s += c;
			}
			return (S)s;
		}
		
	}
	public String toString() {
		String s = "path : ";
		for(T i: path)s += i.toString()+" ";
		/*s+=" gain ";
		for(S i: gain)s += i.toString()+" ";*/
		return s;
		
	}
	public boolean isIntersect(Path<T, S> p2) {
		boolean flag = false;
		HashMap<Integer,Integer> freq = new HashMap<>();
		int sp1 = path.size();
		int sp2 = p2.path.size();
		int n = (sp1 > sp2?sp1:sp2);
		Integer temp = null;
		for(int i = 0; i < n; i++) {
			if(i < sp1) {
				temp = (Integer) this.path.get(i);
				if(freq.get(temp) == null)freq.put(temp, dummy);
				else flag = true;
			}
			
			if(i < sp2) {
				temp = (Integer) p2.path.get(i);
				if(freq.get(temp) == null)freq.put(temp, dummy);
				else flag = true;
			}
			if(flag ) break;
		}
		return flag;
	}
}
