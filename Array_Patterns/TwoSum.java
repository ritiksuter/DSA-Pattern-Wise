import java.util.Arrays;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        int[] ans = twoSumWithoutSort(nums, target);
        System.out.println(Arrays.toString(ans));
    }

    public static int[] twoSum(int[] nums, int target) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length-1;

        while(left < right) {
            if(nums[left] + nums[right] == target) {
                return new int[] {left, right};
            }
            else if(nums[left] + nums[right] < target) {
                left++;
            }
            else if(nums[left] + nums[right] > target) {
                right--;
            }
        }
        return new int[] {-1, -1};
    }

    public static int[] twoSumWithoutSort(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target) return new int[] {i, j};
            }
        }
        return new int[] {-1, -1};
    }
}