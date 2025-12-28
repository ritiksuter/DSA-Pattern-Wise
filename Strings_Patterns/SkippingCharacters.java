public class SkippingCharacters {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        s = s.toLowerCase();
        int left = 0;
        int right = s.length() - 1;

        while(left < right) {
            while(left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while(left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            if(s.charAt(left) != s.charAt(right)) {
                System.out.println("Not Palindrome");
                return ;
            }
            left++;
            right--;
        }
        System.out.println("Valid Palindrome");
    }
}
