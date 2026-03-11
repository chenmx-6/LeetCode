package Solution;

public class Solution0088 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int addPosition=m+n-1;
        int p1=m-1,p2=n-1;
        while(true){
            int num1 =p1<0?Integer.MIN_VALUE:nums1[p1];
            int num2 =p2<0?Integer.MIN_VALUE:nums2[p2];
            if(num1<num2){
                nums1[addPosition]=num2;
                p2--;
            }else{
                nums1[addPosition]=num1;
                p1--;
            }
            addPosition--;
            if(p2<0){
                break;
            }
        }
    }
}
