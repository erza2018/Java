

public class L496_E_NextGreaterEl {
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
    // You are given two arrays (without duplicates) nums1 and nums2 where nums1’s elements are subset of nums2. 
    // Find all the next greater numbers for nums1's elements in the corresponding places of nums2.

    // The Next Greater Number of a number x in nums1 is the first greater number to its right in nums2. 
    // If it does not exist, output -1 for this number.

    int[] ans = new int[nums1.length];
    int k = 0;
    
    for(int i=0; i<nums1.length; i++) {
        
        int a = nums1[i], index = -1;
        
        for(int j=0; j<nums2.length; j++) {
            if(nums2[j] == a) {
                index = j;
            }
        }
        for(int j=index+1; j<nums2.length; j++) {
            if(nums2[j] > a) {
                a = nums2[j];
                break;
            }
        }
        if(a == nums1[i]) ans[k++] = -1;
        else ans[k++] = a;
    }
    return ans;
    }
    public static void main(String[] args) {
        nextGreaterElement(new int[]{4,1,2}, new int[]{1,3,4,2});
    }
}