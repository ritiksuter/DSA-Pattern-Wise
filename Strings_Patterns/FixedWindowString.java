public class FixedWindowString {
    public static void main(String[] args) {
        
    }
    public static int maxVowels(String s, int k) {
        int left = 0, vowels = 0, max = 0;

        for (int right = 0; right < s.length(); right++) {
            if(isVowel(s.charAt(right))) {
                vowels++;
            }

            if(right - left + 1 == k) {
                max = Math.max(max, vowels);

                if(isVowel(s.charAt(left))) {
                    vowels--;
                }
                left++;
            }
        }
        return max;
    }
    public static boolean isVowel(char c) {
        return "aeiou".indexOf(c) != -1;
    }
}
