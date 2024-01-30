package _01Array;


public class BinarySearch {
    public static void main(String[] args) {

        int[] nums = {1,3,5,6};
        System.out.println("结果为：" + search(nums, 7));

    }

    /*
    *
    1.  先判断给出的数字是否在数组的长度范围内
    2.  定义一个变量储存最左端和最右端，还有中间值
    3.   判断条件为左 < 右,
        1.  中间值为左 + 右  再除以二
        2.  当中间值小于目标值时，最右值等于中间值
        3.  当中间值大于目标值时，最左值等于中间值
        4.  不满足上面的条件说明找到，返回中间值
    4.  若出循环说明没有找到

    * */
    public static int search(int[] nums, int target) {
        if (nums[0] > target || nums[nums.length - 1] < target) {
            return -1;
        }
        int left = 0;
        int right = nums.length;
        int mid = 0;
        while (left < right) {
            mid = (left + right) / 2;
            if (target < nums[mid]) {
                right = mid;
            } else if (target > nums[mid]) {
                left = mid + 1;     //[ , )区间，mid已经找过了，所以应该+1避免重复寻找
            } else {
                return mid;
            }
        }
        return -1;

    }
}
