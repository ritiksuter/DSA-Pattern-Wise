public class BinarySearchPattern {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 50, 122};
        int target = 122;
        int ans = search(arr, target);
        System.out.println(ans);
    }

    public static int search(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while(low <= high) {
            int mid = (low + high) / 2;

            if(arr[mid] == target) return mid;

            // if(arr[low] <= arr[mid]) {
            //     if(target >= arr[low] && target < arr[mid]) {
            //         high = mid - 1;
            //     }
            //     else {
            //         low = mid + 1;
            //     }
            // }
            // else {
            //     if(target > arr[mid] && target <= arr[high]) {
            //         low = mid + 1;
            //     }
            //     else {
            //         high = mid - 1;
            //     }
            // }
        
            if(target >= arr[mid]) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }
}
