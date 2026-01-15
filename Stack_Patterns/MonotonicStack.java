import java.util.Arrays;
import java.util.Stack;

public class MonotonicStack {
    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 6, 2, 3};
        int[] result = nextGreater(arr);

        System.out.println(Arrays.toString(result));
    }

    public static int[] nextGreater(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();     // Stores indices

        for (int i = n-1; i >= 0; i--) {
            while(!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
                stack.pop();
            }

            ans[i] = stack.isEmpty() ? -1 : nums[stack.peek()];

            stack.push(i);
        }
        return ans;
    }
}


/*
Next Greater

Previous Greater

Next Smaller

Previous Smaller
*/