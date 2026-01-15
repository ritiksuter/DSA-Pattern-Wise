import java.util.Stack;

public class RangeAndWindowsPattern {
    public static void main(String[] args) {
        int[] heights = {2,1,5,6,2,3};
        System.out.println(largestRectangleArea(heights));
    }

    public static int largestRectangleArea(int[] h) {
        int n = h.length;
        Stack<Integer> st = new Stack<>();
        int max = 0;

        for (int i = 0; i <= n; i++) {
            int curr = (i == n) ? 0 : h[i];

            while (!st.isEmpty() && curr < h[st.peek()]) {
                int height = h[st.pop()];
                int right = i;
                int left = st.isEmpty() ? -1 : st.peek();

                int width = right - left - 1;
                max = Math.max(max, height * width);
            }
            st.push(i);
        }
        return max;
    }
}


/*
Whenever the question says:

Largest / Maximum / Minimum in a subarray

Range where an element is smallest / greatest

Sliding window with boundaries

Histogram area

Subarrays contribution

Stock span, max rectangle, rain water, etc.
*/