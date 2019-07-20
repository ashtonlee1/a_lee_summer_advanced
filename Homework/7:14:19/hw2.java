public class MyLinkedList {
  private Node start;
  private Node end;
  private int length = 0;
  public int size() {
    return length;
  }
  public boolean add(Integer value) {
    Node n=new Node();
    n.setData(value);
    n.next = start;
    n.prev = null;
    if(start!=null) {
      start.setPrev(n);
    }
    start = n;
    length++;
    return true;
  }
  public String toString() {
    Node n = start;
    String str = "";
    while(n!=null){
      str=str+n.toString()+",";
      n=n.next();
    }
    return str;
  }
  public Integer get(int index) {
    if(index<0||index>size()) {
      return null;
    }
    Node n1 = start;
    for(int i = 0;i<index-1;i++) {
      n1 = n1.next();
    }
    return n1.getData();
  }
  public Integer set(int index, Integer value) {
    if(index<0||index>size()) {
      return null;
  }
    Node n=start;
    for(int i = 0;i<index-1;i++) {
      n=n.next();
  }
    return n.setData(value);
  }
  public boolean contains(Integer value) {
    boolean answer = false;
    Node n=start;
    while(n!=null) {
      if(n.getData()==value) {
        answer=true;
        break;
      }
      n=n.next;
    }
    return answer;
  }
  public Integer remove(int index) {
    if(index<0||index>size()) {
      return null;
    }
    Node n=start;
    for(int i = 0;i<index-1;i++) {
      n=n.next();
    }
    Integer n1 = n.getData();
    if(n!=start) {
      n.prev().setNext(n.next());
    } else {
      start=n.next();
    }
    if(n!=end) {
      n.next().setPrev(n.prev());
    } else {
      end = n.prev();
    }
    if(n==start&&n==end) {
      n.setData(null);
      n.setPrev(null);
      n.setNext(null);
    }
    length--;
    return n1;
  }
  public int indexOf(int value){
    Node n = start;
    if(contains(value)==false) {
      return -1;
    }
    for(int i = 0;i<length;i++){
      if(n.getData()==value){
        return i;
      }
      n=n.next();
    }
  }
  public boolean remove(Integer value){
    if(contains(value) == false){
      return false;
    }
    int index = indexOf(value);
    Node n = start;
    for(int i = 1;i<index+1;i++){
      n=n.next();
    }
    if(length==1){
      start = null;
      end = null;
    }
    if(n.next()==null){
      n.prev().setNext(null);
      return true;
    }
    if(n.prev() == null){
      n.next().setPrev(null);
      return true;
    }
    n.prev().setNext(n.next());
    n.next().setPrev(n.prev());
    return true;
    length--;
  }
  public void add(int index, Integer value) {
    if(index>0&&index<=size()) {
      Node n1 = new Node();
      n1.setData(value)
      Node n = start;
      for (int i = 0;i<index-1;i++) {
        n=n.next();
      }
      if (p!=start) {
        n.prev().setNext(n1);
        n1.setPrev(n.prev());
      } else {
        start = n1;
      }
      n1.setNext(n);
      n.setPrev(n1);
      length++;
    }
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
    public void setNext(Node other) {
      next = other;
    }
    public void setPrev(Node other) {
      prev = other;
    }
    public int getData() {
      return data;
    }
    public int setData(Integer i) {
      data = i;
      return data;
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
