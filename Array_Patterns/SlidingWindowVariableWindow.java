public class SlidingWindowVariableWindow {
    public static void main(String[] args) {
        int[] arr = {4,6,3,-1,15,-7};
        int k = 18;
        int ans = maxLen(arr, k);
        System.out.println(ans);
    }

    public static int maxLen(int[] arr, int k) {
        int left = 0;
        int sum = 0;
        int maxLen = 0;

        for (int right = 0; right < arr.length; right++) {
            sum += arr[right];

            while(sum > k) {
                sum -= arr[left++];
            }
            maxLen = Math.max(maxLen, right-left+1);
        }
        System.out.println(sum);  // 10
        return maxLen;
    }
}
