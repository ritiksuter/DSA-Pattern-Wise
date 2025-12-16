public class BinarySearchIn2DArray {
    public static void main(String[] args) {
        int[][] nums = {{1,2,3}, {4,5,6}, {7,8,9}};
        int target = 6;
        boolean ans = binarySearch(nums, target);
        System.out.println(ans);
    }
    public static boolean binarySearch(int[][] nums, int target) {
        int n = nums.length;
        int m = nums[0].length;
        int low = 0;
        int high = n * m - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int row = mid / m;
            int col = mid % m;

            if(nums[row][col] == target) return true;
            else if(nums[row][col] < target) low = mid + 1;
            else high = mid - 1;
        }
        return false;
    }
}