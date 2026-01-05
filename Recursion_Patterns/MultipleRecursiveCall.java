public class MultipleRecursiveCall {
    public static void main(String[] args) {
        System.out.println(count("abc", 0));
    }

    public static int fib(int n) {
        if(n <= 1) return n;

        return fib(n-1) + fib(n-2);
    }

    public static void solve(String s, int index, String curr) {
        if(index == s.length()) {
            System.out.println(curr);
            return ;
        }
        // include
        solve(s, index+1, curr+s.charAt(index));
        // exclude
        solve(s, index+1, curr);
    }

    public static int count(String s, int index) {
        if(index == s.length()) return 1;

        return count(s, index+1) + count(s, index+1);
    }

    
}