class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();
        int pivot = findPivot(mountainArr, 0, n-1);
        if (mountainArr.get(pivot) == target) {
            return pivot;
        }
        
        int result = binarySearchLeft(mountainArr, target, 0, pivot);
        if (result > -1) {
            return result;
        }
        return binarySearchRight(mountainArr, target, pivot+1, n-1);
    }
    
    private int binarySearchRight(MountainArray nums, int target, int left, int right) {
        if (left > right) return -1;
        if (left == right) return nums.get(left) == target ? left : -1;
        
        int mid = left + (right - left) / 2;
        int midValue = nums.get(mid);
        if (midValue == target) return mid;
        if (midValue > target) return binarySearchRight(nums, target, mid+1, right);
        
        return binarySearchRight(nums, target, left, mid);
    }
    
     private int binarySearchLeft(MountainArray nums, int target, int left, int right) {
        if (left > right) return -1;
        if (left == right) return nums.get(left) == target ? left : -1;
        
        int mid = left + (right - left) / 2;
        int midValue = nums.get(mid);
        if (midValue == target) return mid;
        if (midValue > target) return binarySearchLeft(nums, target, left, mid);
        
        return binarySearchLeft(nums, target, mid+1, right);
    }
    
    private int findPivot(MountainArray nums, int left, int right) {
        while(right-left > 1) {
            int mid = left + (right - left) / 2;
            int midValue = nums.get(mid);
            if (nums.get(left) < midValue && midValue < nums.get(mid+1)) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
