
public class Solution {
	// 计算两遍
	long sum;

	// +-2这种是错误的写法，所以返回的是0；
	public int myAtoi(String str) {
		int sign = 1;
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (ch == ' ')
				continue;
			else if (ch == '-' || ch == '+') {
				sign = (ch - '-' == 0) ? -1 : 1;
				return getNum(i + 1, str, sign);
			} else if (Character.isDigit(ch))
				return getNum(i, str, sign);
			else {
				return 0;
			}

		}
		return (int) sum;
	}

	private int getNum(int i, String str, int sign) {
		// TODO Auto-generated method stub
		while (i < str.length()) {
			char ch = str.charAt(i++);
			if (!Character.isDigit(ch))
				break;
			sum = sum * 10 + ch - '0';
			if (sum * sign > Integer.MAX_VALUE)
				return Integer.MAX_VALUE;
			if (sum * sign < Integer.MIN_VALUE)
				return Integer.MIN_VALUE;
		}

		return (int) sum * sign;
	}

	public static void main(String[] args) {
		String str = "+-2";
		System.out.println(new Solution().myAtoi(str));
	}
}
