import java.util.*;
public class classwork {
  public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
    int[][] pathGrid = new int[obstacleGrid.length][obstacleGrid[0].length];
    for(int x = 0; x < obstacleGrid.length; x++) {
      for(int y = 0; y < obstacleGrid[0].length; y++) {
        if(obstacleGrid[x][y] == 0) {
          if(x == 0 && y == 0) {
            pathGrid[x][y] = 1;
          } else if(x == 0) {
            pathGrid[x][y] = pathGrid[x][y-1];
          } else if(y == 0) {
            pathGrid[x][y] = pathGrid[x-1][y];
          } else {
            pathGrid[x][y] = pathGrid[x-1][y] + pathGrid[x][y-1];
          }
        } else {
          pathGrid[x][y] = 0;
        }
      }
    }
    return pathGrid[obstacleGrid.length-1][obstacleGrid[0].length-1];
  }
  public static int minimumTotal(List<List<Integer>> triangle) {
    return -1;
  }
  public static List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> result = new ArrayList<>();
    if(matrix.length == 0) return result;
    int m = matrix.length;
    int n = matrix[0].length;
    int counter = 0;
    while(counter<(Math.min(m,n)+1)/2){
      for(int i=counter;i<=n-counter-1;i++) result.add(matrix[counter][i]);
      for(int i=counter+1;i<m-counter-1;i++) result.add(matrix[i][n-counter-1]);
      for(int i=n-counter-1;m-counter-1!=counter&&i>=counter;i--) result.add(matrix[m-counter-1][i]);
      for(int i=m-counter-2;n-counter-1!=counter&&i>counter;i--) result.add(matrix[i][counter]);
      counter++;
    }
    return result;
  }
  public static void main(String[] args) {
    int[][] test = {{0,0,0},{0,1,0},{0,0,0}};
    List<List<Integer>> test2 = new ArrayList<>();
    List<Integer> a = new ArrayList<>();
    List<Integer> b = new ArrayList<>();
    List<Integer> c = new ArrayList<>();
    List<Integer> d = new ArrayList<>();
    a.add(1);
    b.add(4);
    b.add(5);
    c.add(2);
    c.add(7);
    c.add(3);
    d.add(5);
    d.add(4);
    d.add(2);
    d.add(3);
    test2.add(a);
    test2.add(b);
    test2.add(c);
    test2.add(d);
    /*
          [1]
        [4][5]
      [2][7][3]
    [5][4][2][3]
    */
    int[][] test3 = {{3,4,5},{6,1,0},{0,7,0}};
    System.out.println("Problem 1");
    System.out.println(uniquePathsWithObstacles(test));
    System.out.println("Problem 2");
    System.out.println(minimumTotal(test2));
    System.out.println("Problem 3");
    List<Integer> list = spiralOrder(test3);
    for(int i=0;i<list.size();i++){
      System.out.println(list.get(i));
    }
  }
}
