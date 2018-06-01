package com.codinginterview.array;

/**
 *
 * 数组长度为 n+1 , 数组中所有数字均在 1 — n 范围内。
 * 不改变数组，找出数组中任意重复数字。
 * 常规解法：
 *          1.暴力法，时间复杂度达到了 O(n²)
 *          2.对数组排序法会更改数组
 *          3.对该数组进行拷贝，然后使用排序法，产生格外的空间复杂度
 * 更好的解法思路：
 *          1.考虑数组长度为 n+1 ,数字范围在 1 -- n ,则数组中一定会出现重复数字。
 *          2.由 1 中得到结论，若 没有重复数字，则 1 -- n 范围内就只会有 n 个数字。
 *            所以判断数组中是否有重复数字和范围是有关系的。
 *          3.将数组中 1 -- n 数字从中间数字 m 分为两部分，前面一半为 1 -- m, 后面一半为 （m+1） -- n ；
 *            如果 1 -- m 的数字数目在整个数组中超过 m ，那么这一半的区间里面一定包含重复数字。然后继续
 *            将包含重复数字的区间一分为二，直到找到一个重复数字。
 *          4.算法的时间复杂度为 O(nlogn)
 *          5.该算法总是会找出前一半数组中靠前的重复数字
 */
public class DuplicationNoChange {

    public static int getDuplication(int[] numbers, int length){

        if (numbers == null || length <= 0){
            return -1;
        }
        int start = 1;
        int end = length - 1;
        //这里类似于二分法，只不过每次二分，不过会记录下数字出现的次数
        while (end >= start){
            int middle = (end + start) / 2;
            //判断 二分之一 数字在数组中出现的个数，首先是判断 前一半数字
            int count = countRange(numbers, length, start, middle);
            //如果数字已经二分到重叠，且没有发现重复数字则退出，不过这是不可能的
            if (end == start){
                if (count > 1){
                    return start;
                }else {
                    break;
                }
            }
            //如果出现的次数大于这一半数字个数，证明前一半数字中一定有重复的，则开始重复判断
            if (count > middle - start + 1){
                end = middle;
            }else {
                start = middle + 1;
            }
        }
        return -1;

    }

    private static int countRange(int[] numbers, int length, int start, int middle) {

        if (numbers == null){
            return 0;
        }
        int count = 0;
        for (int i = 0; i < length; i++) {
            //判断数组中 在 start - middle 范围数字在数组长出现的个数
            if (numbers[i] >= start && numbers[i] <= middle) {
                ++count;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] intArray = {2,3,5,4,3,2,6,7};
        int theNumber = getDuplication(intArray, intArray.length);
        System.out.println(theNumber);
    }


}
