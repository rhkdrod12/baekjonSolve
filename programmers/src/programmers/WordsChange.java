package programmers;

import java.util.ArrayList;
import java.util.Collections;

public class WordsChange {
	public static void main(String[] args) {

		String begin = "hit";
		String target = "cog";

		String[] words = { "hot", "dot", "dog", "lot", "log", "cog" };

		System.out.println(new WordsChangeSolution().solution(begin, target, words));

	}
}

class WordsChangeSolution {

	ArrayList<Integer> list = new ArrayList<Integer>();

	public int solution(String begin, String target, String[] words) {

		int answer = 0;

		if (!containWord(target, words))
			return answer;

		boolean[] visited = new boolean[words.length];

		bfs(begin, target, words, visited, 0);

		if (list.size() > 0) {
			answer = Collections.min(list);
		}

		return answer;

	}

	void bfs(String begin, String target, String[] words, boolean[] visited, int sum) {

		if (begin.equals(target)) {
			list.add(sum);
		}

		for (int i = 0; i < words.length; i++) {
			boolean[] visitedTemp = visited.clone();
			if (!visitedTemp[i] && compareWord(words[i], begin)) {
//            System.out.printf("begin: %s words: %s sum: %d i: %d\n", begin, words[i], sum, i);
				visitedTemp[i] = true;
				bfs(words[i], target, words, visitedTemp, sum + 1);
			}
		}
	}

	boolean containWord(String target, String[] words) {

		for (int i = 0; i < words.length; i++) {
			if (target.equals(words[i])) {
				return true;
			}
		}
		return false;
	}

	boolean compareWord(String begin, String target) {

		int cnt = 0;

		for (int i = 0; i < begin.length(); i++) {

			if (begin.charAt(i) != target.charAt(i)) {
				if (++cnt > 1)
					return false;
			}
		}

		return true;
	}

}