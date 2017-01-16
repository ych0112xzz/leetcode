package leetcode;

/**
 * @author yangcheng E-mail:ych0112xzz@bupt.edu.cn
 */

public class ReverseInteger {
	public static void main(String[] agrs) {
		int x = -12340;
		int result = revInteger(x);
		System.out.println(result);
	}

	public static int revInteger(int x) {
		int MAX = Integer.MAX_VALUE;
		int MIN = Integer.MIN_VALUE;
//		System.out.println(MAX);
//		System.out.println(MIN);
		if (x == 0 || x == MIN || x == MAX) {
			return 0;

		} else {
			int num = Math.abs(x);
			System.out.println(num);
			int result = 0;
			while (num > 0) {
				if(result > (MAX - num % 10) /10){//10result+num%10>MAX判断溢出
					return 0;
				}
				int d = num % 10;
				result = result * 10 + d;
				num /= 10;
			}
			//
//			if(result>MAX){
//				return 0;
//			}
			if (x < 0) {
				return result * (-1);
			} else {
				return result;
			}
		}

	}

}
