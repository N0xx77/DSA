class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

        int remove = 0;
        int time = Integer.MIN_VALUE;

        for(int i = 0 ; i<intervals.length ; i++){
            if(intervals[i][0] >= time){
                time = intervals[i][1];
            }
            else {
                remove += 1;
            }
        }

        return remove;
    }
}
