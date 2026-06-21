/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {

        int count = intervals.size();
        Collections.sort(intervals, (a,b) -> {
            if(a.start!=b.start){
                return Integer.compare(a.start, b.start);
            }
            return Integer.compare(a.end,b.end);
        });

        PriorityQueue<Integer> runningMeetings = new PriorityQueue<>();

        int maxRooms =0;

        for(Interval interval: intervals){
            while(!runningMeetings.isEmpty() && runningMeetings.peek() <= interval.start){
                runningMeetings.poll();
            }

            runningMeetings.add(interval.end);
            maxRooms = Math.max(maxRooms,runningMeetings.size());
        }

        return maxRooms;
    }
}
