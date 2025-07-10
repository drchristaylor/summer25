package wk7;

public class BinarySearch {
    public static boolean binarySearch(int target, int[] sortedData) {
        return binarySearch(target, sortedData, 0, sortedData.length);
    }

    private static boolean binarySearch(int target, int[] sortedData, int start, int end) {
        int middle = (end - start) / 2 + start;
        boolean found = sortedData[middle] == target;
        if (!found && start < end) {
            if (target < sortedData[middle]) {
                found = binarySearch(target, sortedData, start, middle);
            } else {
                found = binarySearch(target, sortedData, middle + 1, end);
            }
        }
        return found;
    }

    public static void main(String[] args) {
        int[] data = {1, 3, 8, 12, 14, 14, 16, 18};
        System.out.println(binarySearch(13, data));
    }
}
