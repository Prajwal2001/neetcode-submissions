class Solution {
    boolean[] visited;
    List<List<Integer>> res;

    public List<List<Integer>> permute(int[] nums) {
        visited = new boolean[nums.length];
        res = new ArrayList<>();

        List<Integer> list = new ArrayList<>();
        getPermutations(nums, list);

        return res;
    }

    private void getPermutations(int[] nums, List<Integer> list) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                list.add(nums[i]);
                getPermutations(nums, list);
                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }
    }
}
