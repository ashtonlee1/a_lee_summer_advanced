public class MyLinkedList {
  private Node start;
  private Node end;
  private int length = 0;
  public int size() {
    return size;
  }
  public boolean add(int value) {
    Node n = new Node();
    n.setData(value);
    n.next = start;
    n.prev = null;
    if (start!=null) {
      start.setPrev(n);
    }
    start = n;
  }
  public String toString() {

  }
  public class Node {
    private Node next;
    private Node prev;
    private int data;
    public Node next() {
      return next;
    }
    public Node prev() {
      return prev;
    }
    public void setNext() {
      next = node;
    }
    public void setPrev() {
      prev = node;
    }
    public int getData() {
      return data;
    }
    public int setData(int i) {
      data = i;
    }
    public String toString() {
      return ("Data = " + Integer.toString(data));
    }
  }
  public MyLinkedList() {

  }
  public static void main(String[] args) {
    MyLinkedList m = new MyLinkedList();

  }
}
