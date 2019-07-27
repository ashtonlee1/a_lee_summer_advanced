import java.util.*;
import java.util.HashMap;
import java.util.Map;

public class classwork {
  public static void main(String[] args) {
    HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
    ArrayList<Integer> n1 = new ArrayList<Integer>(Arrays.asList(1,2));
    List<Integer> n2 = new ArrayList<Integer>(Arrays.asList(0,4));
    List<Integer> n3 = new ArrayList<Integer>(Arrays.asList(0,3,5));
    List<Integer> n4 = new ArrayList<Integer>(Arrays.asList(2,4));
    List<Integer> n5 = new ArrayList<Integer>(Arrays.asList(1,3,5,6));
    List<Integer> n6 = new ArrayList<Integer>(Arrays.asList(2,4));
    List<Integer> n7 = new ArrayList<Integer>(Arrays.asList(4,7));
    List<Integer> n8 = new ArrayList<Integer>(Arrays.asList(6));
    map.put(0,n1);
    map.put(1,n2);
    map.put(2,n3);
    map.put(3,n4);
    map.put(4,n5);
    map.put(5,n6);
    map.put(6,n7);
    map.put(7,n8);
    ArrayList<Integer> visited = new ArrayList<Integer>(0);
    ArrayList<Integer> start = new ArrayList<Integer>(Arrays.asList(0));
    int result = count(map,start,6,0);
    /*ArrayList<Integer> result2 = path(map,0,1,0,visited);*/
    System.out.println(result);
    System.out.println("\n");
    /*for(int i = 0; i < result2.size(); i++) {
      System.out.println(result2.get(i));
    }*/
  }
  public static int count(HashMap<Integer, List<Integer>> map, ArrayList<Integer> start, int target, int count) {
    ArrayList<Integer> newstart = new ArrayList<Integer>(0);
    if(start.contains(target)) {
      return count;
    }
    else {
      int len = start.size();
      for(int i = 0; i < len; i++) {
        /*System.out.println(start.size());
        System.out.println("break");
        System.out.println(start.get(i));*/
        List<Integer> value = map.get(start.get(i));
        newstart.addAll(value);
      }
      /*System.out.println("once......");*/
      count++;
      return count(map, newstart, target, count);
    }
  }

  /*WIP*/

  public static ArrayList<Integer> path(HashMap<Integer, List<Integer>> map, int start, int target, int count, ArrayList<Integer> visited) {
    ArrayList<Integer> startlist = new ArrayList<Integer>(Arrays.asList(start));
    ArrayList<Integer> x = new ArrayList<Integer>(Arrays.asList(start));
    int goal = count(map,startlist,target,0)+1;
    System.out.println("goal=" + (goal-1));
    if(start==target) {
      visited.add(target);
      return visited;
    }
    else {
      visited.add(start);
      List<Integer> value = map.get(start);
      for(int i = 0; i < value.size(); i++) {
        int tmp = value.get(i);
        if(!visited.contains(tmp)&&!x.contains(i)&&count<goal) {
          start = tmp;
          ArrayList<Integer> ans = path(map,start,target,count,visited);
          if(ans.size()==goal&&!ans.contains(target)) {
            x.add(i);
            return path(map,start,target,count,visited);
          }
          else {
            System.out.println("Success");
            return visited;
          }
        }
      }
      count++;
    }
    return visited;
  }
}
