import java.util.HashMap;

public class Solution {
	public boolean wordPattern(String pattern, String str) {
		HashMap<Character, String> map = new HashMap<Character, String>();
		HashMap<String, Character> map1 = new HashMap<String, Character>();

		String[] array = str.split(" ");
		if (array.length != pattern.length())
			return false;
		// 使用两个map，只使用一个的话：abba和b b b b这种情况是可以的；
		for (int i = 0; i < pattern.length(); i++) {
			char ch = pattern.charAt(i);
			String string = array[i];
			if (!map.containsKey(ch)) {
				map.put(ch, string);
			} else if (!map.get(ch).equals(string))
				return false;
			if (!map1.containsKey(string))
				map1.put(string, ch);
			else if (!map1.get(string).equals(ch))
				return false;

		}
		return true;
	}

	public static void main(String[] args) {
		String pattern = "abba";
		String str = "hu hu hu hu";
		System.out.println(new Solution().wordPattern(pattern, str));
	}
}
