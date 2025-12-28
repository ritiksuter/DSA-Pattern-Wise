public class CheckIfStringIsMirrorSymmetric {
    public static void main(String[] args) {
        String s = "abccba";
        int i = 0;
        int j = s.length() - 1;

        while(i < j) {
            if(s.charAt(i) != s.charAt(j)) {
                System.out.println("Not Symmetric");
                return;
            }
            i++;
            j--;
        }
        System.out.println("Symmetric");
    }
}