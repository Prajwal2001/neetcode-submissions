class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length, m = matrix[0].length;
        int l = 0, r = n * m - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            int midi = mid / m;
            int midj = mid % m;
            if (matrix[midi][midj] == target) {
                return true;
            } else if (matrix[midi][midj] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return false;
    }
}
