package wk8;

public class Driver {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 12, 14, 18, 22};
        System.out.println(find(nums, -2, 0, nums.length));
    }

    private static boolean find(int[] nums, int target, int start, int end) {
        if (start >= end) {
            return false;
        }
        boolean found = false;
        int middleIndex = (end + start) / 2;
        if (nums[middleIndex] == target) {
            found = true;
        } else if (target < nums[middleIndex]) {
            found = find(nums, target, start, middleIndex);
        } else {
            found = find(nums, target, middleIndex + 1, end);
        }
        return found;
    }

    public static boolean find(int[] nums, int target) {
        boolean found = false;
        int start = 0;
        int end = nums.length;
        while (!found && start < end){
            int middleIndex = (end + start) / 2;
            if (nums[middleIndex] == target) {
                found = true;
            } else if (target < nums[middleIndex]) {
                end = middleIndex;
            } else {
                start = middleIndex + 1;
            }
        }
        return found;
    }
}