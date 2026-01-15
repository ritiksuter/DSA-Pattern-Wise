import java.util.Arrays;
import java.util.Stack;

public class NextOccurencePattern {
    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 3, 4};
        System.out.println(Arrays.toString(nextGreaterRight(arr)));
    }

    public static int[] nextGreaterRight(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() <= arr[i]) {
                st.pop();
            }

            if (st.isEmpty()) res[i] = -1;
            else res[i] = st.peek();

            st.push(arr[i]);
        }
        return res;
    }

}