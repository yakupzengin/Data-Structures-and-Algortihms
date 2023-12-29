import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {
        String text = "aaabbbbcc";

        // Step 1: Calculate character frequencies from the given text
        Map<String, Integer> frequencies = HuffmanTree.calculateFrequencies(text);
        System.out.println("frequencies -> " + frequencies);
        System.out.println(frequencies.keySet());


        // Step 2: Create a linked list and insert frequencies in sorted order
        LinkedListHuffman linkedList = new LinkedListHuffman();
        for (String key : frequencies.keySet()) {
            linkedList.insertSorted(new HuffmanNode(key, frequencies.get(key)));
        }
        System.out.println("*");
        linkedList.display();

        // Step 3: Construct the Huffman tree
        HuffmanTree huffmanTree = new HuffmanTree();
        huffmanTree.createHuffmanTree(linkedList);
        HuffmanNode root = linkedList.head.node;
        System.out.println("root.frequency = " + root.frequency);

        // Step 4: Display Huffman codes
        Map<String, String> huffmanCodes = huffmanTree.getHuffmanCodes(root, "");
        for (String key : huffmanCodes.keySet()) {
            String value = huffmanCodes.get(key);
            System.out.println(key + ": " + value);
        }

        // Step 5: Encode source text
        String encodedText = huffmanTree.encode(text, huffmanCodes);
        System.out.println("Encoded Text: " + encodedText);

        // Step 6: Decode encoded text
        String decodedText = huffmanTree.decode(encodedText, root);
        System.out.println("Decoded Text: " + decodedText);


    }
}
