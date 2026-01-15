import java.util.Stack;

public class ExpressionEvaluationPattern {
    public static void main(String[] args) {
        String s = "23*54*+9-";
        int ans = evaluatePostfix(s);
        System.out.println(ans);
    }

    public static int evaluatePostfix(String s) {
        Stack<Integer> st = new Stack<>();

        for (char ch : s.toCharArray()) {
            if(Character.isDigit(ch)) {
                st.push(ch - '0');
            }
            else {
                int b = st.pop();
                int a = st.pop();

                if(ch == '+') st.push(a + b);
                if(ch == '-') st.push(a - b);
                if(ch == '*') st.push(a * b);
                if(ch == '/') st.push(a / b);
            }
        }
        return st.pop();
    }

    
}