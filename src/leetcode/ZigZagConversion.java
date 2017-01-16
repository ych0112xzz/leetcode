package leetcode;

import java.util.Arrays;

public class ZigZagConversion {

	public static void main(String[] args) {
		String s = "0123456789";
		int nRows = 2;
		String result = convert(nRows, s);
		System.out.println(result);
	}

	public static String convert(int nRows, String s) {

		String[] results = new String[nRows];
		String result = "";
		Arrays.fill(results, "");
		int row = 0;
		boolean dir = false;
		if (nRows == 1) {
			return s;
		}
		if (nRows == 2) {
			for (int i = 0; 2 * i < s.length(); i++) {
				results[0] += s.charAt(2 * i);
				if (2 * i + 1 < s.length()) {
					results[1] += s.charAt(2 * i + 1);
				}

			}
			return results[0] + results[1];
		}
		for (int i = 0; i < s.length(); i++) {

			// results[row] +=s.charAt(i);
			if (row < nRows && !dir) {
				results[row] += s.charAt(i);
				row += 1;
			} else if (row >= nRows) {
				dir = true;
				row = row - 2;
				results[row] += s.charAt(i);
			} else if (dir) {
				row = row - 1;
				results[row] += s.charAt(i);
			}
			if (row == 0) {
				dir = false;
				row += 1;
			}
		}
		for (int i = 0; i < results.length; i++) {
			result += results[i];
			System.out.println(results[i]);
		}

		return result;

	}

}
