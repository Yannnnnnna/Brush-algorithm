package _01Array;


import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {

       System.out.println("result: " + search3(6));

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
    /*
    * 搜索插入位置
      给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
    * 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
    * */

    public static int search1(int[] nums, int target) {
        if (target < nums[0]) {
            return 0;
        } else if (target > nums[nums.length - 1]) {
            return nums.length;
        }else{
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
            if (target < nums[mid]){
                return mid;
            }else {
                return mid + 1;
            }
        }
    }

    /*
    * 34. 在排序数组中查找元素的第一个和最后一个位置
        给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。
        请你找出给定目标值在数组中的开始位置和结束位置。
        如果数组中不存在目标值 target，返回 [-1, -1]。
    * */
    public static int[] search2(int[] nums, int target){
        int[] result = {-1, -1};
        if (nums == null || nums.length <= 0
                || target < nums[0] || target > nums[nums.length - 1]){
            return result;
        }

        int left = 0;
        int right = nums.length;
        int mid = 0;
        while (left < right){
            mid = (left + right) / 2;
            if(target < nums[mid]){
                right = mid;
            }else if(target > nums[mid]){
                left = mid + 1;
            }else if(target == nums[mid]){
                result[0] = mid;
                int i = mid;
                while (i < nums.length && nums[i] == target){
                    result[1] = i++;
                }
                i = mid;
                while (i >= 0 && nums[i] == target){
                    result[0] = i--;
                }
                break;
            }
        }
        return result;
    }

    /*
    * 69. x 的平方根
    * 给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
    * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
    * 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
    * */
    public static int search3(int x){
        if(x == 0 || x == 1){
            return x;
        }
        int left = 0;
        int right = x / 2;
        int mid = 0;
        while (left <= right){
            //mid = (left + right) / 2;     //这样写可能会导致溢出，当int非常大的时候
            mid = left + (right - left) / 2;
            //用乘法很容易溢出，所以改用除法
            if(x / mid > mid){
                left = mid + 1;
            }else if(x / mid < mid){
                right = mid - 1;
            }else {
                return mid;
            }
        }
        return right;
    }
}