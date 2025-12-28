public class MinimumWindowSubstring {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";

        int[] freq = new int[128];
        for(char c: t.toCharArray()) freq[c]++;

        int left = 0;
        int count = t.length();
        int minLen = Integer.MAX_VALUE;
        int start = 0;

        for (int right = 0; right < s.length(); right++) {
            if(freq[s.charAt(right)]-- > 0) count--;
            while(count == 0) {
                if(right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }
                if(freq[s.charAt(left)]++ == 0) count++;
            }
        }
        System.out.println(s.substring(start, start + minLen));
    }
}