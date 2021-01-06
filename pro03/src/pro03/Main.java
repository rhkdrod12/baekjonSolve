package pro03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] genres = {"classic", "pop", "classic", "classic", "pop"};
		int[] plays = {500, 600, 800, 800, 2500};

		new Solution2().solution(genres, plays);
	}
}
class Solution2{
	public int[] solution(String[] genres, int[] plays) {

		HashMap<String, HashMap<Integer, Integer>> temp = new HashMap<String, HashMap<Integer, Integer>>();
		HashMap<String, Integer> genresTotal = new HashMap<String, Integer>();

		for(int i = 0 ; i < genres.length ; i++) {

			String tempGenres = genres[i];
			HashMap<Integer, Integer> genresInfo;

			if(temp.containsKey(tempGenres)) {
				genresInfo = temp.get(tempGenres);
			}
			else {
				genresInfo = new HashMap<Integer, Integer>();
			}

			genresInfo.put(i, plays[i]);
			temp.put(tempGenres, genresInfo);
			genresTotal.put(tempGenres, genresTotal.getOrDefault(tempGenres, 0) + plays[i]);
		}

		Iterator it = sortByValue(genresTotal).iterator();
		ArrayList<Integer> rns = new ArrayList<Integer>();
		
		while(it.hasNext()) {
			String key = (String) it.next();
			Iterator indexIt = sortByValue(temp.get(key)).iterator();
			
			int loop = 0;
			while(indexIt.hasNext()) {
				rns.add((int)indexIt.next());
				loop++;
				if(loop>1) break;
			}
			
		}
		
		int[] ans = new int[rns.size()];
		for(int i = 0 ; i < ans.length; i++) {
			ans[i] = rns.get(i);
		}

		return ans;
		
//		String[] keys = genresTotal.keySet().toArray(new String[] {});
//		Arrays.sort(keys, (a,b)->genresTotal.get(b) - genresTotal.get(a));
//		System.out.println("총합으로 정렬: " + Arrays.deepToString(genresTotal.entrySet().toArray()));
//
//		ArrayList<Integer> answer = new ArrayList<Integer>();
//
//		for(String key : keys) {
//			Integer[] tmpKeys = temp.get(key).keySet().toArray(new Integer[] {});
//
//			HashMap<Integer, Integer> tempInfo = temp.get(key);
//			Arrays.sort(tmpKeys, (a,b)->tempInfo.get(b) - tempInfo.get(a));
//
//			for(int i = 0 ; i < 2 && i<tempInfo.size() ; i++) {
//				answer.add(tmpKeys[i]);
//			}
//		}
//
//		int[] ans = new int[answer.size()];
//		for(int i = 0 ; i < ans.length; i++) {
//			ans[i] = answer.get(i);
//		}
//		System.out.println(answer);
//
//		return ans;
	}

	private ArrayList sortByValue(final Map map){
		ArrayList<Object> keyList = new ArrayList();
		keyList.addAll(map.keySet());

		Collections.sort(keyList, new Comparator(){
			public int compare(Object o1, Object o2){
				Object v1 = map.get(o1);
				Object v2 = map.get(o2);

				return ((Comparable) v2).compareTo(v1);
			}
		});

		return keyList;
	}

}


class Solution {
	public int[] solution(String[] genres, int[] plays) {

		Map<String, Music> tmp = new HashMap<String, Music>();

		for(int i = 0; i < genres.length ; i++) {
			if(tmp.containsKey(genres[i])) {
				tmp.get(genres[i]).MusicAdd(i, plays[i]);
			}
			else {
				tmp.put(genres[i], new Music(genres[i], i, plays[i]));
			}
		}

		String[] keys = tmp.keySet().toArray(new String[] {});
		Arrays.sort(keys, (a,b)->tmp.get(b).sum - tmp.get(a).sum);

		ArrayList<Integer> numAnswer = new ArrayList<Integer>();

		for(String key : keys) {
			Collections.sort(tmp.get(key).infos,Comparator.comparing(Music.info::getPlays).reversed().thenComparing(Music.info::getNumber));
			for(int i = 0 ; i < tmp.get(key).infos.size() && i < 2; i++) {
				numAnswer.add(tmp.get(key).infos.get(i).number);
			}
		}

		int[] answer = new int[numAnswer.size()];
		for(int i = 0 ; i < answer.length ; i++	) {
			answer[i] = numAnswer.get(i);
		}
		return answer;
	}
}
class Music {

	String genres;
	public ArrayList<info> infos = new ArrayList<Music.info>();
	int sum = 0;

	public Music(String genres, int number, int plays) {
		// TODO Auto-generated constructor stub
		this.genres = genres;
		infos.add(new info(number, plays));
		sum+=plays;
	}

	public void MusicAdd(int number, int plays) {
		infos.add(new info(number, plays));
		sum+=plays;
	}

	class info{
		int number;
		int plays;

		public info(int number, int plays) {
			this.number = number;
			this.plays = plays;
		}
		public int getNumber() {
			return number;
		}
		public int getPlays() {
			return plays;
		}
	}
}

