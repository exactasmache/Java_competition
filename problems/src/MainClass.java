import java.io.FileNotFoundException;
import java.util.List;

public class MainClass {

	public static void main(String args[]) {
//		testBinaryCode();
//		testAlphabetPath();
//		testTime();
//		testBonuses();
//		testDeleteArrays();
//		testSolutionWithFilter();
//		testNumWaysRecursive();
//		testNumWaysDynamic();
//		testBookReading();
		testNewProblem();
	}

	@SuppressWarnings("unused")
	private static void testAlphabetPath() {
		AlphabetPath ap = new AlphabetPath();
		String[] ap_input = { "ADEHI..Z", "BCFGJK.Y", ".PONML.X", ".QRSTUVW" };
		String ret = ap.doesItExist(ap_input);
		System.out.println(ret);
	}

	@SuppressWarnings("unused")
	private static void testBinaryCode() {
		BinaryCode bc = new BinaryCode();
		String[] ret = bc.decode("123210122");
		System.out.println(ret[0] + ", " + ret[1]);
	}

	@SuppressWarnings("unused")
	private static void testTime() {
		Time t = new Time();
		String ret = t.whatTime(3661);
		System.out.println(ret);
	}

	@SuppressWarnings("unused")
	private static void testBonuses() {
		Bonuses t = new Bonuses();
		int[] points = { 1, 2, 3, 4, 5 };
		int[] ret = t.getDivision(points);
		for (int r : ret)
			System.out.print(r + " ");
	}

	@SuppressWarnings("unused")
	private static void testDeleteArrays() {
		DeleteArrays da = new DeleteArrays();
		int a = 100000, b = 5, c = 8;
		long x = 424242, y = 474747, z = 123456789;
		long[] ret = da.doDelete(a, b, c, x, y, z);
		for (long r: ret)
			System.out.print(r + " ");
	}
	
	@SuppressWarnings("unused")
	private static void testSolutionWithMerge() {
		SuggestWithMerge sol = new SuggestWithMerge();
		String[] products = {"mobile","mouse","moneypot","monitor","mousepad","mache","casa"};
		String searchWord = "mouse";
		List<List<String>> ret = sol.suggestedProducts(products, searchWord);
		for (List<String> r: ret) {
			System.out.print("[");
			for (String s: r)
				System.out.print(s + ",");
			System.out.print("], ");
		}
	}
	
	@SuppressWarnings("unused")
	private static void testSolutionWithFilter() {
		SuggestWithFilter sol = new SuggestWithFilter();
		String[] products = {"mobile","mouse","moneypot","monitor","mousepad","mache","casa"};
		String searchWord = "mouse";
		List<List<String>> ret = sol.suggestedProducts(products, searchWord);
		for (List<String> r: ret) {
			System.out.print("[");
			for (String s: r)
				System.out.print(s + ",");
			System.out.print("], ");
		}
	}
	
	@SuppressWarnings("unused")
	private static void testNumWaysRecursive() {
		NumWaysRecursive sol = new NumWaysRecursive();
		int ret = sol.numWays(30, 2);
		System.out.println(ret);
	}
	

	@SuppressWarnings("unused")
	private static void testNumWaysDynamic() {
		NumWaysDynamic sol = new NumWaysDynamic();
		int ret = sol.numWays(60, 100);
		System.out.println(ret);
	}
	
	@SuppressWarnings("unused")
	private static void testBookReading() {
		try {
			BookReading.main();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unused")
	private static void testNewProblem() {
		NumWaysDynamic sol = new NumWaysDynamic();
		int ret = sol.numWays(60, 100);
		System.out.println(ret);
	}
	
}