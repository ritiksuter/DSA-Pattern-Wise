import java.util.Arrays;

public class FirstAndLastOcurrence {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,4,4,5,6};
        int target = 4;
        int[] ans = firstAndLastOcurrence(nums, target);
        System.out.println(Arrays.toString(ans));
    }
    public static int[] firstAndLastOcurrence(int[] nums, int target) {
        int first = firstOccurence(nums, target);
        int last = lastOccurence(nums, target);

        return new int[] {first, last};
    }

    public static int firstOccurence(int[] nums, int target) {
        int ans = -1;
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                ans = mid;
                high = mid - 1;
            }
            else if (nums[mid] < target) {
                low = mid + 1;
            }
            else high = mid - 1;
        }
        return ans;
    }
    public static int lastOccurence(int[] nums, int target) {
        int ans = -1;
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                ans = mid;
                low = mid + 1;
            }
            else if (nums[mid] < target) {
                low = mid + 1;
            }
            else high = mid - 1;
        }
        return ans;
    }
}