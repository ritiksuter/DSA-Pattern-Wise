public class LinearRecursion {
    public static void main(String[] args) {
        // printNTo1(10);
        int ans = fact(5);
        System.out.println(ans);
    }

    public static void print(int n) {
        if(n == 0) return ;

        print(n - 1);
        System.out.print(n + " ");
    }

    public static void printNTo1(int n) {
        if(n == 0) return ;

        System.out.print(n + " ");
        printNTo1(n - 1);
    }

    public static int sum(int n) {
        if(n == 0) return 0;
        return n + sum(n - 1);
    }

    public static int fact(int n) {
        if(n == 1) return 1;
        return n * fact(n - 1);
    }

    public static int power(int a, int n) {
        if(n == 0) return 1;
        return a * power(a, n-1);
    }

    public void reverse(String s, int index) {
        if(index < 0) return ;

        System.out.println(s.charAt(index));
        reverse(s, index-1);
    }

    public static boolean isPalindrome(String s, int left, int right) {
        if(left >= right) return true;
        if(s.charAt(left) != s.charAt(right)) return false;

        return isPalindrome(s, left+1, right-1);
    }

    public static int sum(int[] arr, int index) {
        if(index == arr.length) return 0;
        return arr[index] + sum(arr, index+1);
    }

    public static int max(int[] arr, int index) {
        if(index == arr.length - 1) return arr[index];

        return Math.max(arr[index], max(arr, index+1));
    }
}