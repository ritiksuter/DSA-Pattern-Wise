public class FixedWindow {
    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidbaooo";
        int[] freq = new int[26];
        for(char c: s1.toCharArray()) freq[c - 'a']++;

        int left = 0;
        int count = s1.length();

        for (int right = 0; right < s2.length(); right++) {
            if(freq[s2.charAt(right) - 'a']-- > 0) count--;

            if(right - left + 1 > s1.length()) {
                if(freq[s2.charAt(left) - 'a']++ >= 0) count++;
                left++;
            }
            if(count == 0) {
                System.out.println("Permutation exists");
                return;
            }
        }
    }
}