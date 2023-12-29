class LinkedListHuffman {
    LinkedListNode<HuffmanNode> head;

    public void insertSorted(HuffmanNode huffmanNode) {
        LinkedListNode<HuffmanNode> newNode = new LinkedListNode<>(huffmanNode);

        if (head == null || huffmanNode.frequency < head.node.frequency) {
            newNode.next = head;
            head = newNode;
        } else {
            LinkedListNode<HuffmanNode> current = head;
            LinkedListNode<HuffmanNode> prev = null;

            while (current != null && huffmanNode.frequency >= current.node.frequency) {
                prev = current;
                current = current.next;
            }

            prev.next = newNode;
            newNode.next = current;
        }
    }

    public void display() {
        LinkedListNode<HuffmanNode> iterator = head;
        while (iterator != null) {
            System.out.println("Values : " + iterator.node.value + " & " + "Frequencies : " + iterator.node.frequency + " ");
            iterator = iterator.next;
        }
        System.out.println();
    }
}
