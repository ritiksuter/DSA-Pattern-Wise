import java.util.HashMap;
import java.util.Map;

public class UsingArrayAndHashMaps {
    public static void main(String[] args) {
        // String s = "banana";
        // int[] freq = new int[26];
        // for (int i = 0; i < s.length(); i++) {
        //     char ch = s.charAt(i);
        //     freq[ch - 'a']++;
        // }
        // // System.out.println(Arrays.toString(freq));
        // System.out.println((char) (('b' - 'a') + 96));
        // System.out.println((char) 97);


        String s = "banana";
        Map<Character, Integer> map = new HashMap<>();

        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
    }
}