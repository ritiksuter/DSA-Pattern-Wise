public class SubsequencePattern {
    public static void main(String[] args) {
        String s = "abc";
        String t = "aXbYc";
        int i = 0;
        int j = 0;

        while(i < s.length() && j < t.length()) {
            if(s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        System.out.println(i == s.length());     // true
    }
}
