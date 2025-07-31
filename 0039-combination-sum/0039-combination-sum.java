class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ansArray = new ArrayList<>();
        List<Integer> targetArr = new ArrayList<>();
        
        findCombinationSum(0, ansArray, target, candidates, targetArr);
        return ansArray;
    }
    
    public void findCombinationSum(int index, List<List<Integer>> ansArray, int target, int[] arr, List<Integer> targetArray){
        if(index >= arr.length){
            if(target == 0){
                ansArray.add(new ArrayList<>(targetArray));
            }
            return;
        }
        
        if(arr[index] <= target){
            targetArray.add(arr[index]);
            findCombinationSum(index, ansArray, target - arr[index], arr, targetArray);
            targetArray.remove(targetArray.size() - 1);
        }
        
        findCombinationSum(index + 1, ansArray, target, arr, targetArray);
    }
}