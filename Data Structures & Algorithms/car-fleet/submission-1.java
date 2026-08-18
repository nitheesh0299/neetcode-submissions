class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        List<int[]> cars = new ArrayList<>();
        int n =position.length;
        for(int i=0;i<n;i++){
            cars.add(new int[]{position[i],speed[i]});
        }

        cars.sort((a,b) -> Integer.compare(b[0],a[0]));
        int fleet =0;
        int i=0;
        while(i<n){
            int[] curr = cars.get(i);
            double maxTime = (double)(target-curr[0])/curr[1];
            i++;
            while(i<n){
                curr = cars.get(i);
                double time = (double)(target-curr[0])/curr[1];
                if(time<=maxTime)
                    i++;
                else
                    break;
            }
            fleet++;
        }

        return fleet;
    }
}
