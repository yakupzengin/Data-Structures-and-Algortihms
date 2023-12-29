class HuffmanNode {
    String value;
    float frequency;
    HuffmanNode left, right;

    public HuffmanNode(String value, float frequency) {
        this.value = value;
        this.frequency = frequency;
        this.left = this.right = null;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}