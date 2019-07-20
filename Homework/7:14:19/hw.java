import java.io.*;
import java.util.*;
public class hw {
  public static boolean matchingParentheses(String text) {
    Stack<Character> stack = new Stack<Character>();
    int length = text.length();
    if(text.isEmpty()) {
      return true;
    }
    for(int i = 0; i < length; i++) {
      char t = text.charAt(i);
      if(t=='(') {
        stack.push(t);
      }
      if(t==')') {
        if(stack.isEmpty()) {
          return false;
        }
        char n = stack.peek();
        if(n=='(') {
          stack.pop();
        }
        else {
          return false;
        }
      }
    }
    return stack.isEmpty();
  }
  public static void main(String[] args) {
    if(matchingParentheses("()()(")) {
      System.out.println("Matches");
    }
    else {
      System.out.println("Does not match");
    }
  }
}
