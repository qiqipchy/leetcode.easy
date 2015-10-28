public class Solution {
	public String addBinary(String a, String b) {
		StringBuilder sb = new StringBuilder();
		if (a.length() < b.length()) {
			String temp = a;
			a = b;
			b = temp;
		}
		int add = 0;
		for (int i = b.length() - 1, k = a.length() - 1; i >= 0; i--, k--) {
			int cha = a.charAt(k) - '0';
			int chb = b.charAt(i) - '0';
			cha = cha + chb + add;
			if (cha >= 2) {
				cha = cha - 2;
				add = 1;
			} else
				add = 0;
			sb.append(cha);
		}
		for (int i = a.length() - 1 - b.length(); i >= 0; i--) {
			int cha = a.charAt(i) - '0';
			cha += add;
			if (cha >= 2) {
				cha = cha - 2;
				add = 1;
			} else
				add = 0;
			sb.append(cha);
		}
		if (add == 1)
			sb.append(add);
		return sb.reverse().toString();
	}

	public static void main(String[] args) {
		String a = "100";
		String b = "110010";
		System.out.println(new Solution().addBinary(a, b));
	}
}
