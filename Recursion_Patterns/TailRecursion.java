public class TailRecursion {
    public static int sum(int n, int acc) {
        if(n == 0) return acc;
        return sum(n - 1, acc + n);
    }

    public static int fact(int n, int acc) {
        if(n == 0) return acc;
        return fact(n - 1, acc * n);
    }

    public static int power(int a, int n, int acc) {
        if(n == 0) return acc;
        return power(a, n - 1, acc * a);
    }

    public static void reverse(String s, int index, String acc) {
        if(index < 0) {
            System.out.println(acc);
            return ;
        }
        reverse(s, index - 1, acc + s.charAt(index));
    }

    public static int count(int n, int acc) {
        if (n == 0) return acc;
        return count(n / 10, acc + 1);
    }

    public static int sumOfDigits(int n, int acc) {
        if (n == 0) return acc;
        return sum(n / 10, acc + (n % 10));
    }

    public static int factUsingIterative(int n) {
        int acc = 1;
        while(n > 0) {
            acc = acc * n;
            n--;
        }
        return acc;
    }
}