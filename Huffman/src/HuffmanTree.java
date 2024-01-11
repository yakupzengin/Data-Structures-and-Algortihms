import java.util.HashMap;
import java.util.Map;

class HuffmanTree {

    public static String encode(String text, Map<String, String> huffmanCodes) {
        StringBuilder encodedText = new StringBuilder();
        for (char character : text.toCharArray()) {
            String charKey = String.valueOf(character);
            String code = huffmanCodes.get(charKey);
            encodedText.append(code);
        }
        return encodedText.toString();
    }
    public static String decode(String encodedText, HuffmanNode root) {
        StringBuilder decodedText = new StringBuilder();
        HuffmanNode current = root;

        for (char bit : encodedText.toCharArray()) {
            if (bit == '0') {
                current = current.left;

            } else {
                current = current.right;

            }

            if (current.left == null && current.right == null) {
                decodedText.append(current.value);
                current = root;
            }
        }

        return decodedText.toString();
    }
    public static Map<String, Integer> calculateFrequencies(String text) {
        Map<String, Integer> frequencies = new HashMap<>();
        for (char character : text.toCharArray()) {
            String charKey = String.valueOf(character);
            frequencies.put(charKey, frequencies.getOrDefault(charKey, 0) + 1);
        }
        return frequencies;
    }
    /*
    *
    * public void createHuffmanTree(LinkedList list){
        * while( list.count() > 1 ) {
            * HuffmanNode leftN = list.delete();
            * HuffmanNode rightN = list.delete();
            * HuffmanNode mergeNode = new HuffmanNode( leftN.frequency + right.frequency , null);
            * mergeNode.left = leftN;
            * mergeNode.right = rightN;
            * list.insertSorted(mergeNode);
        * }
        * root = list.delete(); // The last remaining node i    n the list ist the root of the Huffman Tree.
        *
    *
    * */
    public void createHuffmanTree(LinkedListHuffman list) {
        while (list.head.next != null) {
            HuffmanNode left = list.head.node;
            list.head = list.head.next;

            HuffmanNode right = list.head.node;
            list.head = list.head.next;

            HuffmanNode merged = new HuffmanNode(null, left.frequency + right.frequency);
            merged.left = left;
            merged.right = right;

            list.insertSorted(merged);
        }
    }

    public Map<String, String> getHuffmanCodes(HuffmanNode root, String code) {
        Map<String, String> huffmanCodes = new HashMap<>();
        generateCodes(root, code, huffmanCodes);
        return huffmanCodes;
    }

    private void generateCodes(HuffmanNode node, String code, Map<String, String> huffmanCodes) {
        if (node != null) {
            if (node.left == null && node.right == null) {
                huffmanCodes.put(node.value, code);
            }

            generateCodes(node.left, code + "0", huffmanCodes);
            generateCodes(node.right, code + "1", huffmanCodes);
        }
    }


}