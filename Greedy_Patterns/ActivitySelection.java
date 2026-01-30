import java.util.Arrays;

class Activity {
    int start, end;

    public Activity(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class ActivitySelection {
    public static void main(String[] args) {
        Activity[] activities = {
            new Activity(1, 3),
            new Activity(2, 4),
            new Activity(3, 5),
            new Activity(0, 6),
            new Activity(5, 7),
            new Activity(8, 9)
        };
        int ans = maxActivities(activities);
        System.out.println(ans);
    }

    public static int maxActivities(Activity[] activities) {
        // Step 1: Sort activities by end time
        System.out.println("-------------------------- Before Sorting --------------------------");
        for (int i = 0; i < activities.length; i++) {
            System.out.println("Start : " + activities[i].start + ",  End :" + activities[i].end);
        }
        
        Arrays.sort(activities, (a, b) -> a.end - b.end);
        
        System.out.println("-------------------------- After Sorting --------------------------");
        for (int i = 0; i < activities.length; i++) {
            System.out.println("Start : " + activities[i].start + ",  End :" + activities[i].end);
        }
        
        int count = 1;      // First activity selected
        int lastEnd = activities[0].end;

        // Step 2: Greedy Choice
        for (int i = 1; i < activities.length; i++) {
            if(activities[i].start >= lastEnd) {
                count++;
                lastEnd = activities[i].end;
            }
        }
        return count;
    }
}






/*
class Activity implements Comparable<Activity> {
    int start;
    int end;

    @Override
    public int compareTo(Activity other) {
        return this.end - other.end;   // sort by end time
    }
}

*/