package wk11;

public class Driver {
    public static void main(String[] args) {
        {
            int[] sorted = {1, 2, 3, 4, 5, 6};
            int[] reverseSorted = {6, 5, 4, 3, 2, 1};
            int[] scrambled = {3, 1, 2, 6, 5, 4};
            insertionSort(sorted);
            System.out.println(print(sorted));
            insertionSort(reverseSorted);
            System.out.println(print(reverseSorted));
            insertionSort(scrambled);
            System.out.println(print(scrambled));
        }
        {
            int[] sorted = {1, 2, 3, 4, 5, 6};
            int[] reverseSorted = {6, 5, 4, 3, 2, 1};
            int[] scrambled = {3, 1, 2, 6, 5, 4};
            selectionSort(sorted);
            System.out.println(print(sorted));
            selectionSort(reverseSorted);
            System.out.println(print(reverseSorted));
            selectionSort(scrambled);
            System.out.println(print(scrambled));
        }
    }

    public static String print(int[] data) {
        StringBuffer buf = new StringBuffer("[");
        for (int num : data) {
            buf.append(num + ", ");
        }
        return buf.toString().substring(0, buf.length() - 2) + "]";
    }

    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int currentVal = arr[i];
            int index = i - 1;
            while (index >= 0 && arr[index] > currentVal) {
                arr[index + 1] = arr[index];
                index = index - 1;
            }
            arr[index + 1] = currentVal;
        }
    }

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            if (min != i) {
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
        System.out.println("done");
    }

}
