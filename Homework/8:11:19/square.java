import java.io.*;
import java.util.*;
public class square {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("square.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("square.out")));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int a1 = Integer.parseInt(st.nextToken());
		int b1 = Integer.parseInt(st.nextToken());
		int c1 = Integer.parseInt(st.nextToken());
		int d1 = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int a2 = Integer.parseInt(st.nextToken());
		int b2 = Integer.parseInt(st.nextToken());
		int c2 = Integer.parseInt(st.nextToken());
		int d2 = Integer.parseInt(st.nextToken());

		int[] x = new int[4];
		int[] y = new int[4];

		x[0] = a1;
		x[1] = a2;
		x[2] = c1;
		x[3] = c2;
		y[0] = b1;
		y[1] = b2;
		y[2] = d1;
		y[3] = d2;

		bubbleSort(x);
		bubbleSort(y);
		int xdif = x[3] - x[0];
		int ydif = y[3] - y[0];

		if(xdif > ydif) {
			pw.println(xdif * xdif);
		}
		else {
			pw.println(ydif * ydif);
		}
		pw.close();
	}
	public static void bubbleSort(int[] array) {
    boolean sorted = false;
    int temp;
    while(!sorted) {
        sorted = true;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i+1]) {
                temp = array[i];
                array[i] = array[i+1];
                array[i+1] = temp;
                sorted = false;
            }
        }
    }
}
}
