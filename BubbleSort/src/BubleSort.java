public class BubleSort {

    // This method implements the bubble sort algorithm to sort the given array of integers.
    public static void bubbleSort(int[] values) {
        boolean sorted = true;

        for (int i = 0; i < values.length - 1; i++) {
            for (int j = 0; j < values.length - 1 - i; j++) {
                if (values[j] > values[j + 1]) {
                    int temp = values[j];
                    values[j] = values[j + 1];
                    values[j + 1] = temp;
                    sorted = false;
                }
            } // inner for loop
            if (sorted)
                return;
            sorted = true;
        } // outer for loop

    }

    public static void main(String[] args) {
        int[] myValues = {5, 1, 9, 10, 3, 4, 0};
        bubbleSort(myValues);

        // Displaying the sorted array elements after applying the bubble sort algorithm.
        for (int i = 0; i < myValues.length; i++) {
            System.out.print(myValues[i] + " ");
        }
        System.out.println();
    }
}
