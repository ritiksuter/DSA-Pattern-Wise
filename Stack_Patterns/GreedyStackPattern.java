import java.util.Stack;

public class GreedyStackPattern {
    public static void main(String[] args) {
        String num = "1432219";
        int k = 3;
        System.out.println(removeKdigits(num, k));
    }

    public static String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();

        for (char c : num.toCharArray()) {
            while (!st.isEmpty() && k > 0 && st.peek() > c) {
                st.pop();
                k--;
            }
            st.push(c);
        }

        while (k-- > 0) {
            st.pop();
        }

        // Build result
        StringBuilder sb = new StringBuilder();
        for (char c : st) sb.append(c);

        // remove leading zeroes
        while (sb.length() > 0 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}


/*
This is one of the most powerful interview patterns.

It appears when:

You must build the best / smallest / largest / valid result
while processing elements one by one

You must decide:

“Should I keep this element or remove something before it?”
*/