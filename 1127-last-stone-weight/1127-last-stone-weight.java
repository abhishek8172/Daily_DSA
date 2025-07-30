class Solution {
    public int lastStoneWeight(int[] stones) 
    {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)->b-a);

        //Add all stones
        for(int stone:stones)
            maxHeap.offer(stone);

        while(maxHeap.size()>1)
        {
            int y = maxHeap.poll(); //heaviest
            int x = maxHeap.poll(); //second heaviest
            if(x!=y)
                maxHeap.offer(y-x);
        }

        return maxHeap.isEmpty()?0:maxHeap.poll();
    }
}