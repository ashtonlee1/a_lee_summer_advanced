import java.io.*;
import java.util.*;
public class cowtip {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("cowtip.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("cowtip.out")));
		int n = Integer.parseInt(br.readLine());
    int answer = 0;
		char[][] cows = new char[n][n];
		for(int i=0;i<n;i++) {
			String line = br.readLine();
			for(int m=0;m<n;m++) {
				cows[i][m] = line.charAt(m);
			}
		}
    /*looping from bottom right,
    first 1 encountered has to be a flip,
    flips all to above and to the left
    and repeat process to the top left*/
		for(int i=n-1;i>=0;i--) {
			for(int m=n-1;m>=0;m--) {
				if(cows[i][m] == '1') {
					for(int x=0;x<i+1;x++) {
						for(int y=0;y<m+1;y++) {
							if(cows[x][y] == '1') {
								cows[x][y] = '0';
							}
							else if(cows[x][y] == '0') {
								cows[x][y] = '1';
							}
						}
					}
          answer++;
				}
			}
		}
		pw.println(answer);
		pw.close();
	}
}
