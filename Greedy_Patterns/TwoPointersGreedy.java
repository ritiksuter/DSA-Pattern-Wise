import java.util.Arrays;

public class TwoPointersGreedy {
    public static void main(String[] args) {
        int[] g = {1,2,3};
        int[] s = {1,1};
        int ans = findContentChildren(g, s);
        System.out.println(ans);

        int[] people = {3,2,2,1};
        int limit = 3;
        int res = numRescueBoats(people, limit);
        System.out.println(res);
    }

    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int i = 0, j = 0, count = 0;

        while (i < g.length && j < s.length) {
            if(s[j] >= g[i]) {
                count++;
                i++;
                j++;
            }
            else j++;
        }
        return count;
    }

    public static int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);

        int left = 0, right = people.length - 1;
        int boats = 0;

        while (left <= right) {
            if(people[left] + people[right] <= limit) left++;
            right--;
            boats++;
        }
        return boats;
    }
}