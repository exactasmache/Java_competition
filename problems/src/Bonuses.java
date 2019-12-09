import java.util.Arrays;
import java.util.TreeMap;

/* SRM 145 DIV 1 */
public class Bonuses {
	public int[] getDivision(int[] points) {
		
		int n = points.length;
		TreeMap<Integer, Integer> pnt2id = new TreeMap<Integer, Integer>();
		int[] percents = new int[n];
		int total = Arrays.stream(points).sum();

		for (int i = 0; i < n; ++i) {
			percents[i] = points[i] * 100 / total;
			pnt2id.put(points[i], i);
		}

		int rem = 100 - Arrays.stream(percents).sum();
		
		for (Integer e : pnt2id.descendingKeySet()) {
			int id = pnt2id.get(e);
			percents[id]++;
			rem--;
			if (rem == 0)
				break;
		}
		return percents;
	}
}