public class Solution {
	public boolean isPalindrome(String s) {
		for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
			if (!Character.isAlphabetic(s.charAt(i))
					&& !Character.isDigit(s.charAt(i))) {
				j++;
				continue;
			} else if (!Character.isAlphabetic(s.charAt(j))
					&& !Character.isDigit(s.charAt(j))) {
				i--;
				continue;
			} else if (Character.toLowerCase(s.charAt(i)) != Character
					.toLowerCase(s.charAt(j)))
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		String s = "A man, a plan, a canal: Panama";
		System.out.println(new Solution().isPalindrome(s));
	}
}
