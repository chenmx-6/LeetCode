package Solution;

import java.util.Random;

public class Solution0912 {
    private final Random random=new Random(System.currentTimeMillis());
    public int[] sortArray(int[] nums) {
        quickSort(nums,0,nums.length-1);
        return nums;
    }

    public void quickSort(int[] nums,int left,int right){
        int randomIndex = random.nextInt(right - left + 1) + left;
        int pivot = nums[randomIndex];
        swap(nums,left,randomIndex);
        int le=left+1;
        int ge=right;
        while(true){
            if(le<=ge&&nums[le]<pivot){
                le++;
            }
            if(le<=ge&&nums[ge]>pivot){
                ge--;
            }
            if(le>=ge){
                break;
            }
            swap(nums,le,ge);
            le++;
            ge--;
        }
        swap(nums,left,ge);
        quickSort(nums,left,randomIndex-1);
        quickSort(nums,randomIndex+1,right);
    }

    public void swap(int[]nums,int left ,int right){
        int temp=nums[left];
        nums[left]=nums[right];
        nums[right]=left;
    }
}
