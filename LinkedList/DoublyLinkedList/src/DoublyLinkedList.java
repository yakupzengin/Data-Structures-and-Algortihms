public class DoublyLinkedList<T extends  Comparable> {
  DNode<T> head;
  public DNode<T> createNode(T val) {
      return new DNode<>(val);
  }
  public void insertToFront(T val ){
    DNode<T> newNode = createNode(val);
    if (head == null) {
        head = newNode;
    }else{
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }
  }
  public void insertToEnd(T val){
      DNode<T> newNode=createNode(val);
      if (head == null){
          head = newNode;
      }else{
          DNode<T> iterator = head;
          while (iterator.next != null){
              iterator = iterator.next;
          }
          newNode.prev=iterator;
          newNode.prev.next = newNode;
      }
  }
  // Assume that every value is unique in the list.
  public void delete(T val){
      if (head == null)
          return;
      else if (head.value.compareTo(val) ==0) {
          head = head.next;
          // head has changed a next
          if (head != null)
              head.prev = null;
      }else{
          DNode<T> iterator = head;

          while(iterator != null && iterator.value.compareTo(val) !=0){
              iterator = iterator.next;
          }
          if (iterator == null)
              return;
          else{
              iterator.prev.next = iterator.next;
              if (iterator.next != null)
                  iterator.next.prev = iterator.prev;
          }
      }
  }
}