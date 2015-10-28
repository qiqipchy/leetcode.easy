import java.util.Arrays;

public class Solution {
	public int[] plusOne(int[] digits) {
		if (digits[digits.length - 1] != 9) {
			digits[digits.length - 1]++;
			return digits;
		}
		int i = digits.length - 1;
		while (i >= 0 && digits[i] == 9) {
			digits[i] = 0;
			i--;
		}
		// 这里不是i==0,而是i>=0；
		if (i >= 0) {
			digits[i]++;
			return digits;
		}
		int[] digitsOne = new int[digits.length + 1];
		System.arraycopy(digits, 0, digitsOne, 1, digits.length);
		digitsOne[0] = 1;
		return digitsOne;

	}

	public static void main(String[] args) {
		int[] digits = { 1, 9 };
		System.out.println(Arrays.toString(new Solution().plusOne(digits)));
	}
}
