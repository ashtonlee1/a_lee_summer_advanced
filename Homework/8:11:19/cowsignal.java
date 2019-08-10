import java.util.*;
import java.io.*;

public class cowsignal {
  public static void main(String[] args) throws IOException, FileNotFoundException{
     BufferedReader br = new BufferedReader(new FileReader("cowsignal.in"));                                                  // input file name goes above
     PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("cowsignal.out")));
     StringTokenizer st = new StringTokenizer(br.readLine());
     int a = Integer.parseInt(st.nextToken());
     int b = Integer.parseInt(st.nextToken());
     int c = Integer.parseInt(st.nextToken());
     for (int i = 0; i<a; i++) {
         String str = br.readLine();
         String row = "";
         for (int y = 0; y < str.length(); y++) {
             String temp =  "" + str.charAt(y);
             for (int l = 0; l < c - 1; l++) {
                 temp+=str.charAt(y);
             }
             row += temp;

         }
         for (int x = 0; x < c; x++) {
             pw.println(row);
         }
     }
     pw.close();
  }

}
