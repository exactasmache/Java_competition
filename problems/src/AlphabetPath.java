import java.util.HashMap;

class Pair<T0, T1> {
	private T0 p0;
	private T1 p1;

	public Pair(T0 a, T1 b) {
		p0 = a;
		p1 = b;
	}

	public T0 get0() {
		return p0;
	}

	public T1 get1() {
		return p1;
	}

}

public class AlphabetPath {
	private String _abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	HashMap<Character, Pair<Integer, Integer>> _abc2pos;

	public AlphabetPath() {
		_abc2pos = new HashMap<Character, Pair<Integer, Integer>>();
	}

	private String ret(Boolean status) {
		if (status)
			return "YES";
		return "NO";
	}


	public String doesItExist(String[] letterMaze) {
		for (int j = 0; j < letterMaze.length; j ++) {
			String e = letterMaze[j];
			for (int i = 0; i < e.length(); i++) {
				if(e.charAt(i) != '.') {
					_abc2pos.put(e.charAt(i), new Pair<Integer, Integer>(i, j));
//					System.out.println(e.charAt(i) + " --> (" + i + ", " + j + ")  --  ");
				}
			}
		}

		for (int i = 0; i < _abc.length()-1; i++) {
			Pair<Integer, Integer> pi = _abc2pos.get(_abc.charAt(i));
			Pair<Integer, Integer> pi_1 = _abc2pos.get(_abc.charAt(i+1));
			
//			System.out.println(_abc.charAt(i) + " --> (" + pi.get0() + ", " + pi.get1() + ")");
//			System.out.println(_abc.charAt(i+1) + " --> (" + pi_1.get0() + ", " + pi_1.get1() + ")");
			if (Math.abs(pi.get0() - pi_1.get0()) + Math.abs(pi.get1() - pi_1.get1()) != 1) {
				return ret(false);
			}
		}
		return ret(true);
	}
}
