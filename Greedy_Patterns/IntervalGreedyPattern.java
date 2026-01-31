import java.util.Arrays;
import java.util.List;

class Interval {
    int start, end;

    Interval(int s, int e) {
        start = s;
        end = e;
    }
}

public class IntervalGreedyPattern {
    public static void main(String[] args) {
        List<Interval> intervals = Arrays.asList(
            new Interval(1, 3),
            new Interval(2, 4),
            new Interval(3, 5),
            new Interval(5, 7)
        );
        int ans = maxIntervals(intervals);
        System.out.println(ans);
    }

    public static int maxIntervals(List<Interval> intervals) {
        // Sort by end time
        intervals.sort((a,b) -> a.end - b.end);

        int count = 1;
        int lastEnd = intervals.get(0).end;

        for (int i = 1; i < intervals.size(); i++) {
            if (intervals.get(i).start >= lastEnd) {
                count++;
                lastEnd = intervals.get(i).end;
            }
        }
        return count;
    }
}