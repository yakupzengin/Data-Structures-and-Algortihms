public class BinarySearchAlgorithm {

    // Binary search algorithm to find a specific number in a sorted array.
    // Returns the index of the number if found, otherwise returns -1
    public static int binarySearch(int[] numbers, int numberToFind) {
        int low = 0;
        int high = numbers.length - 1;

        while (low <= high) {
            int middlePosition = (low + high) / 2;
            int middleNumber = numbers[middlePosition];

            if (numberToFind == middleNumber)
                return middlePosition;

            if (numberToFind < middleNumber) {
                high = middlePosition - 1;
            } else {
                low = middlePosition + 1;
            }
        }
        return -1; // Number not found in the array
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 5, 7, 9, 11, 13};
        int numberToFind = 1;
        int index = binarySearch(array, numberToFind);

        // Display the result of the binary search
        if (index != -1) {
            System.out.println(numberToFind + " found at index: " + index);
        } else {
            System.out.println(numberToFind + " not found in the array.");
        }
    }
}
