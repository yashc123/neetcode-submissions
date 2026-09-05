class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<Integer>();
        List<Integer> finalList = new ArrayList<>();

        for(int i = 0; i < nums1.length; i++){
            set.add(nums1[i]);
        }

        for(int i = 0; i < nums2.length; i++){
            if(set.contains(nums2[i])){
                finalList.add(nums2[i]);
                set.remove(nums2[i]);
            }
            
        }

        int[] result = new int[finalList.size()];

        for(int i = 0; i < finalList.size(); i++){
            result[i] = finalList.get(i);
        }

        return result;
    }
}