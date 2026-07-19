class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        List<int[]> res = new ArrayList<>();
        int start = newInterval[0];
        int end = newInterval[1];
        for(int[] interval:intervals){
            if(interval[1]<start || interval[0]>end){
                res.add(interval);
            }else {
                start = Math.min(start, interval[0]);
                end = Math.max(end,interval[1]);
            }
        }
        res.add(new int[]{start,end});
        Collections.sort(res, (a,b) -> Integer.compare(a[0],b[0]));

        return res.toArray(new int[res.size()][]);
    }
}
