import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
/*
 * 1、计算出相同的个数A；
 * 2、将剩余的元素集合起来，排好序；
 * 3、对s中剩余的元素进行个数统计，对g中剩余的元素进行个数统计；
 * 		统计的时候需要注意：不是每一个元素都需要被统计，只统计在对方串中出现的元素；
 * 4、对s和g中相同元素的频率取其较小值相加得到B
 */
public class Solution {
	public String getHint(String secret, String guess) {
		int A = 0, B = 0;
		HashMap<Character, Integer> map1 = new HashMap<Character, Integer>();
		HashMap<Character, Integer> map2 = new HashMap<Character, Integer>();
		List<Character> list1 = new ArrayList<Character>();
		List<Character> list2 = new ArrayList<Character>();

		for (int i = 0; i < guess.length(); i++) {
			char op1 = secret.charAt(i);
			char op2 = guess.charAt(i);
			if (op1 == op2) {
				A++;
				continue;
			}
			list1.add(op1);
			list2.add(op2);
		}
		// 注意为空的时候
		if (list1.size() == 0 && list2.size() == 0)
			return A + "A0B";
		Collections.sort(list1);
		Collections.sort(list2);

		countSameCharacterAndFrenquency(list1, list2, map1);
		countSameCharacterAndFrenquency(list2, list1, map2);

		// System.out.println(map1.size() + ":size:" + map2.size());
		Set<Character> set = map1.keySet();
		for (Character ch : set) {
			// System.out.println("map1:key--->" + ch + " value---->"
			// + map1.get(ch));
			// System.out.println("map2:key--->" + ch + " value---->"
			// + map1.get(ch));
			B += (map1.get(ch) > map2.get(ch) ? map2.get(ch) : map1.get(ch));
		}

		return A + "A" + B + "B";
	}

	private void countSameCharacterAndFrenquency(List<Character> list1,
			List<Character> list2, HashMap<Character, Integer> map1) {
		// TODO Auto-generated method stub
		for (int i = 0; i < list1.size() - 1; i++) {
			if (list2.contains((list1.get(i)))) {
				int cnt = 1;
				while ((i < list1.size() - 1)
						&& (list1.get(i) == list1.get(i + 1))) {
					i++;
					cnt++;
				}
				System.out.println(list1.get(i) + " " + cnt);
				map1.put(list1.get(i), cnt);
			}

		}
		char last1 = list1.get(list1.size() - 1);
		if (!map1.containsKey(last1) && list2.contains(last1))
			map1.put(last1, 1);

	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		String secret = "1122", guess = "0001";
		System.out.println(solution.getHint(secret, guess));
	}
}
