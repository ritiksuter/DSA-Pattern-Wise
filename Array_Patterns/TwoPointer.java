public class TwoPointer {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5};
        int target = 57;
        boolean ans = twoSum(arr, target);
        System.out.println(ans);
    }

    public static boolean twoSum(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while(left < right) {
            if(arr[left] + arr[right] == target) return true;
            if(arr[left] + arr[right] < target) left++;
            else right--;
        }
        return false;
    }
}
