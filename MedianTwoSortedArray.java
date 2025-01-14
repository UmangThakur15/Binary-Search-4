// TC will be O(log (m+n))
// SC will be O(1)

class MedianTwoSortedArray {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null){
            return -1.0;
        }

        int m = nums1.length;
        int n = nums2.length;
        if(n < m){
            return findMedianSortedArrays(nums2, nums1);
        }
        int low = 0;
        int high = m;
        while(low <= high){
            int partX = low + (high - low)/2;
            int partY = (m+n)/2 - partX;
            double l1 = partX == 0 ? Integer.MIN_VALUE : nums1[partX - 1];
            double l2 = partY == 0 ? Integer.MIN_VALUE : nums2[partY - 1];
            double r1 = partX == m ? Integer.MAX_VALUE : nums1[partX];
            double r2 = partY == n ? Integer.MAX_VALUE : nums2[partY];
            if(l1 <= r2 && l2 <= r1){
                if( (m+n) % 2 == 0){
                    return (Math.max(l1, l2) + Math.min(r1, r2))/2.0;
                }
                return Math.min(r1, r2);
            }
            if(l2 > r1){
                low = partX + 1;
            }
            else if(l1 > r2){
                high = partX - 1;
            }
        }
        return 45.0;
    }

    public static void main(String[] args){
        MedianTwoSortedArray obj = new MedianTwoSortedArray();
        int[] nums1 = {1,3};
        int[] nums2 = {2};
        System.out.println(obj.findMedianSortedArrays(nums1, nums2));
    }
}