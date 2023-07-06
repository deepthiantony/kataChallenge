import java.io.*;
import java.util.*;

class Result {
	
	/*
	 * Complete the 'sherlockAndAnagrams' function below.
	 *
	 * The function is expected to return an INTEGER.
	 * The function accepts STRING s as parameter.
	 */
	
	
	public static int sherlockAndAnagrams(String s) {
		List<String> anagramCheckList = new ArrayList<>();
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			int j = i;
			while (j < s.length()) {
				String anagram = s.substring(i, j + 1);
				char ch[] = anagram.toCharArray();
				Arrays.sort(ch);
				String sortedAnagram = new String(ch);
				for (int k = 0; k < anagramCheckList.size(); k++) {
					if (anagramCheckList.get(k).equals(sortedAnagram)) {
						count += 1;
					}
				}
				anagramCheckList.add(sortedAnagram);
				j++;
			}
		}
		return count;
	}
	
}

public class Solution {
	
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
		
		int q = Integer.parseInt(bufferedReader.readLine().trim());
		
		for (int qItr = 0; qItr < q; qItr++) {
			String s = bufferedReader.readLine();
			
			int result = Result.sherlockAndAnagrams(s);
			
			bufferedWriter.write(String.valueOf(result));
			bufferedWriter.newLine();
		}
		
		bufferedReader.close();
		bufferedWriter.close();
	}
}
