package SearchingAndSorting;

public class SearchInRotatedArray {

    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;

        while(start<=end){

            int mid = start + (end-start)/2;

            if(nums[mid]==target)
                return mid;
            else if( nums[start] <= nums[mid] && !(target >= nums[start] &&  target < nums[mid]) )
                start = mid+1;
            else if(nums[start] <= nums[mid] && (target >= nums[start] &&  target < nums[mid]) )
                end = mid-1;
            else if(nums[start] >= nums[mid] && (target <= nums[end] &&  target > nums[mid]))
                start = mid+1;
            else end = mid-1;

        }
        return -1;
    }
}
