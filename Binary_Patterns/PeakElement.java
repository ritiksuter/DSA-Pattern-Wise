public class PeakElement {
    public static void main(String[] args) {
        int[] nums = {4,5,6,17,9,8,7};
        int ans = findPeak(nums);
        System.out.println(ans);
    }
    public static int findPeak(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if(nums[mid] < nums[mid + 1]) {
                low = mid + 1;
            }
            else {
                high = mid;
            }
        }
        return low;
    }
}