public class Palindrome {
    public static void main(String[] args) {
        String s = "level";
        int left = 0;
        int right = s.length() - 1;

        while(left < right) {
            if(s.charAt(left) != s.charAt(right)) {
                System.out.println("Not Palindrome");
                return;
            }
            left++;
            right--;
        }
        System.out.println("Palindrome");
    }
}
