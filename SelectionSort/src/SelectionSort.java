public class SelectionSort {
    // Method to perform Selection Sort on an array of numbers
    public static void selectionSort(int[] numbers) {
        int length = numbers.length;

        // Iterating through the array elements
        for (int i = 0; i < length - 1; i++) {
            // Assume the current element is the minimum
            int min = numbers[i];
            int indexOfMin = i;

            // Find the index of the smallest element in the unsorted part of the array
            for (int j = i + 1; j < length; j++) {
                if (numbers[j] < min) {
                    // Update the minimum value and its index
                    min = numbers[j];
                    indexOfMin = j;
                }
            }

            // Swap the found minimum element with the first element of the unsorted section
            int temp = numbers[i];
            numbers[i] = numbers[indexOfMin];
            numbers[indexOfMin] = temp;
        }
    }

    public static void main(String[] args) {
        int[] numbers = {640, 1251, 12, 122, 11};

        // Perform Selection Sort on the array
        selectionSort(numbers);

        System.out.println("Sorted Array: ");
        // Display the sorted array elements
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
    }
}
