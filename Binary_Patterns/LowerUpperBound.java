public class LowerUpperBound {
    public static void main(String[] args) {
        int[] arr = {1,2,4,5,6};
        int target = 4;
        int lb = lowerBound(arr, target);
        int ub = upperBound(arr, target);
        System.out.println(lb);
        System.out.println(ub);
    }

    public static int lowerBound(int[] arr, int target) {
        int n = arr.length-1;
        int ans = n + 1;
        int low = 0;
        int high = n;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if(arr[mid] >= target) {
                ans = mid;
                high = mid - 1;
            }
            else low = mid + 1;
        }
        return ans;
    }
    
    public static int upperBound(int[] arr, int target) {
        int ans = arr.length;
        int low = 0;
        int high = arr.length - 1;

        while(low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] > target) {
                ans = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return ans;
    }
}