import java.io.*;
import java.util.*;
public class blocks {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("blocks.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("blocks.out")));
		int N = Integer.parseInt(br.readLine());
    int[] blocksNeeded = new int[26];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String a = st.nextToken();
			String b = st.nextToken();
			int[] first = update(a);
			int[] second = update(b);
			for(int n = 0; n < 26; n++) {
        /*update arr*/
				if(first[n] > second[n]) {
					blocksNeeded[n]+=first[n];
				}
				else {
					blocksNeeded[n]+=second[n];
				}
			}
		}
		for(int i=0; i<26; i++) {
      int out = blocksNeeded[i];
			pw.println(out);
		}
		pw.close();
	}
	public static int[] update(String str) {
		int[] blocksNeeded = new int[26];
		for(int i = 0; i < str.length(); i++) {
			int index = str.charAt(i) - 'a';
			blocksNeeded[index]++;
		}
		return blocksNeeded;
	}

}
