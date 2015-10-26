import java.util.Hashtable;

public class Solution {
	public boolean isIsomorphic(String s, String t) {
		Hashtable<Character, Character> ht = new Hashtable<Character, Character>();
		if (s.length() != t.length())
			return false;
		for (int i = 0; i < s.length(); i++) {
			if (ht.containsKey(s.charAt(i))) {
				if (!new Character(t.charAt(i)).equals(ht.get(s.charAt(i))))
					return false;
			} else
				ht.put(s.charAt(i), t.charAt(i));
		}

		// 注意的是需要来两遍，一次就会出现错误，ab，aa这样的错误；
		Hashtable<Character, Character> ht1 = new Hashtable<Character, Character>();

		for (int i = 0; i < s.length(); i++) {
			if (ht1.containsKey(t.charAt(i))) {
				if (!new Character(s.charAt(i)).equals(ht1.get(t.charAt(i))))
					return false;
			} else
				ht1.put(t.charAt(i), s.charAt(i));
		}

		return true;
	}

	public static void main(String[] args) {
		String s = "ab";
		String t = "ba";
		System.out.println(new Solution().isIsomorphic(s, t));
	}
}
