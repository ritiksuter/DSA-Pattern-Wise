public class BinarySearchOnNearlySortedArray {
    public static void main(String[] args) {
        int[] nums = {10, 30, 20, 40, 50};
        int target = 30;
        int ans = binarySearch(nums, target);
        System.out.println(ans);
    }
    public static int binarySearch(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while(low <= high) {
            int mid = low + (high - low) / 2;

            if(nums[mid] == target) return mid;
            if(mid > low && nums[mid - 1] == target) return mid - 1;
            if(mid < high && nums[mid + 1] == target) return mid + 1;

            if(nums[mid] > target) high = mid - 2;
            else low = mid + 2;
        }
        return -1;
    }
}