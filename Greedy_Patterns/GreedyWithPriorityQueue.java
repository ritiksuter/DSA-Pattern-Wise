import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Interval {
    int start, end;

    Interval(int s, int e) {
        start = s;
        end = e;
    }
}

class Job {
    int deadline, profit;

    Job(int d, int p) {
        deadline = d;
        profit = p;
    }
}

public class GreedyWithPriorityQueue {
    public static void main(String[] args) {
        // List<Interval> intervals = Arrays.asList(
        //     new Interval(1, 3),
        //     new Interval(2, 4),
        //     new Interval(3, 5),
        //     new Interval(0, 6),
        //     new Interval(5, 7),
        //     new Interval(8, 9)
        // );

        Job[] jobs = {
            new Job(7, 95),
            new Job(1, 90),
            new Job(2, 30),
            new Job(3, 10),
        };
        int ans = maxProfit(jobs);
        System.out.println(ans);
    }

    // TC -> O(n log n)
    public static int minMeetingRooms(List<Interval> intervals) {
        intervals.sort((a, b) -> a.start - b.start);

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (Interval i : intervals) {
            if (!minHeap.isEmpty() && minHeap.peek() <= i.start) {
                minHeap.poll();   // Reuse room
            }
            minHeap.add(i.end);
        }
        return minHeap.size();
    }

    public static int maxProfit(Job[] jobs) {
        // Sort wrt profit
        Arrays.sort(jobs, (a, b) -> b.profit - a.profit);

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int time = 0;

        for (Job job : jobs) {
            if(time < job.deadline) {
                minHeap.add(job.profit);
                time++;
            }
            else if(!minHeap.isEmpty() && minHeap.peek() < job.profit) {
                minHeap.poll();
                minHeap.add(job.profit);
            }
        }
        int totalProfit = 0;
        for (int p : minHeap) totalProfit += p;
        return totalProfit;
    }
}