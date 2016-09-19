import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
	boolean[] visit = new boolean[12];
	public List<String> readBinaryWatch(int num) {
		List<String> hours = new ArrayList<String>();
		List<String> mins = new ArrayList<String>();
		List<String> res = new ArrayList<String>();
		if (num > 8 )
			return res;
		int hmax = num > 3 ? 3 : num;
		for (int i = 0; i <= hmax; i++) {
			getHours(0, i, hours, 0, 4);
			getHours(0, num - i, mins, 0, 6);
			for (String h : hours) {
				if (Integer.valueOf(h) > 11)
					continue;
				for (String m : mins) {
					if (Integer.valueOf(m) > 59)
						continue;
					if (m.length() == 1)
						res.add(h + ":0" + m);
					else
						res.add(h + ":" + m);
				}
			}
			// System.out.println(hours);
			// System.out.println(mins);
			hours.clear();
			mins.clear();
			Arrays.fill(visit, false);
		}
		Collections.sort(res);
		return res;
	}
	private void getHours(int begin, int num, List<String> list, int path,
			int max) {
		// TODO Auto-generated method stub
		if (num == 0) {
			list.add(String.valueOf(path));
			return;
		}
		// 注意排列和选择这里的i是不一样的，选择是i=begin；排列是i=0；
		for (int i = begin; i < max; i++) {
			if (!visit[i]) {
				visit[i] = true;
				getHours(i + 1, num - 1, list, path + (int) Math.pow(2, i),
						max);
				visit[i] = false;
			}
		}
	}
	public static void main(String[] args) {
		int num = 0;
		System.out.println(new Solution().readBinaryWatch(num));
	}
}
