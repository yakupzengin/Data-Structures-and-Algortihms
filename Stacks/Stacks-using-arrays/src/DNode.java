 public class DNode {
     public int value;
      public DNode next, prev;
    public DNode(int val) {
               this.value = val;
               this.next = this;
                  this.prev = this;
             }
  }

 class DoublyLinkedList {
     public DNode head = null;

    // Method to remove the current head
             public void metod1() {
                 if (head == null)
                        System.out.println("Empty list");
                else if (head.next == head)
                         head = null;
                 else
                     head = head.next;
             }

     // Method to insert a new node at the end of the list
     public void metod2(int x) {
                 DNode temp = new DNode(x);
                 DNode iterator = head;while (iterator.next != head)
                     iterator = iterator.next;iterator.next = temp;temp.prev = iterator;head.prev = temp;temp.next = head;}
     // Method to insert a new node at the beginning of the list
     public void metod3(int x) {if (head == null)
         head = new DNode(x);else {
             DNode temp = new DNode(x);
             temp.next = head;
             temp.prev = head.prev;
             head.prev = temp;
             temp.prev.next = temp;
             head = temp;
         }
            }
            // Method to print values in reverse order starting from the last node
            public void metod4() {
                 DNode iterator = head.prev;
                 System.out.println(head.prev.value);
                 while (iterator != head.prev) {
                    System.out.println(iterator.value);
                    iterator = iterator.prev;
            }}
     public void display() {
         if (head == null) {
             return; // Do nothing if the list is empty
         }
         DNode iterator = head;
         do {
             System.out.println(iterator.value);
             iterator = iterator.next;
         } while (iterator != head);
     }
     public static void main(String[] args) {DoublyLinkedList db = new DoublyLinkedList();
                 // Inserting values into the doubly linked list
         db.metod3(8);
         db.metod3(2);
         db.metod2(9);
                db.metod3(4);
                db.metod2(10);
         System.out.println("****");
    db.display();
         System.out.println("method : 1 ***");
                // Removing the current head
         db.metod1();
         System.out.println("**");
         db.display();
         System.out.println("***");
         // Printing values in reverse order
                db.metod4();
             }
}
