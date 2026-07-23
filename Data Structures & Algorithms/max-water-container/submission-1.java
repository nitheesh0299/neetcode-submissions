class Solution {
    public int maxArea(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int leftMax =-1,rightMax =-1;
        int maxArea =0;
        // for(int i=0;i<n;i++){
        //     if(leftMax == -1 ||heights[leftMax]<heights[i]){
        //         leftMax =i;
        //     }
        //     if(rightMax == -1 || heights[leftMax]<heights[n-i-1]){
        //         rightMax = n-i-1;
        //     }

        //     int area = Math.min(heights[leftMax],heights[rightMax])*(rightMax-leftMax);
        //     maxArea = Math.max(maxArea,area);
        // }
        int l=0;
        int r=n-1;
        while(l<r){
            leftMax = heights[l];
            rightMax =  heights[r];
            int area = Math.min(leftMax,rightMax)*(r-l);
            maxArea = Math.max(maxArea,area);
            if(heights[l]<heights[r])
                l++;
            else
                r--;
        }

        return maxArea;
    }
}
