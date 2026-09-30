class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        Queue<int []> q = new LinkedList<>();
        int res = 0;

        for(int i = 0 ; i < tickets.length ; i++){
            q.add(new int [] {i, tickets[i]});
        }

        while(!q.isEmpty()){
            int [] temp = q.poll();
            res++;
            temp[1] = temp[1]-1;

            if(k == temp[0] && temp[1] == 0) return res;
            else if(temp[1] == 0) continue;
            else{
                q.add(temp);
            }
        }

        return res;
    }
}
