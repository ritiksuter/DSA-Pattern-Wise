public class KadaneAlgorithm {
    public static void main(String[] args) {
        int[] arr = {1,2,-5,3,-2,4};
        int ans = maxSubArray(arr);
        System.out.println(ans);
    }
    public static int maxSubArray(int[] nums) {
        int max = nums[0];
        int current = nums[0];

        for (int i = 1; i < nums.length; i++) {
            current = Math.max(nums[i], current + nums[i]);
            max = Math.max(max, current);
        }
        return max;
    }
}