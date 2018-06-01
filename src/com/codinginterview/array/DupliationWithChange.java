package com.codinginterview.array;

/**
 * 一种通过改变数组找出数组中重复数字的算法
 * 长度为 n 数组中所有数字在 0 -- n-1 范围内，找出数组中重复的数字
 * 常规解法：
 *          1.排序法，对数组进行排序，从头到尾扫描,排序一个数组需要 O(nlogn) 的时间。
 *          2.利用哈希表，从头到尾扫描数组中元素，每扫描到一个元素若哈希表中没有这个元素，就将其放入哈希表。
 *            若有这个元素，则这是一个重复元素。从哈希表中查找一个元素的时间复杂度是 O（1）。所以时间复杂度是 O（n），但却需要O(n)
 *            的空间复杂度。
 * 更好解法：
 *          1.数组范围在 0 -- n-1 范围内，那么数组中如果没有重复数字，则对数组排序后每个数字应该就在对应的数组下标 i 上。
 *          2.从头到尾扫描这个数组，当扫描到下标为 i 的数字 m 时，比较这个数字 m 是否等于 i 。
 *          3.如果 m 等于 i ,则向下扫描下一个数字，如果 m 不等于 i ，则将下标为 i 和 下标为 m 的数字进行比较。
 *          4.如果相等，则数字 m 出现了重复。如果不相等就将位置 m 和 位置 i 数字进行交换，把 m 放到属于它的位置。
 *          5.重复 3 4 操作，知道找到了重复数字位置。
 *          6.尽管算法有一个两重循环，但每个数字最多只交换两次就能找到属于他的位置，因此总的时间复杂度是 O(n)
 */
public class DupliationWithChange {

    /**
     *
     * @param numbers 数组
     * @param length 数组长度
     * @return
     */
    public static int duplicate(int[] numbers, int length){

        if (numbers == null || length <= 0){
            return -1;
        }

        for (int i = 0; i < length; i++){

            while (numbers[i] != i){

                if (numbers[i] == numbers[numbers[i]]){
                    int duplication = numbers[i];
                    return duplication;
                }
                //交换 位置 i 和 位置 m 上的元素
                int temp = numbers[i];
                numbers[i] = numbers[temp];
                numbers[temp] = temp;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        int[] numbers = {0, 1, 2, 2, 3, 4};
        System.out.println(duplicate(numbers, numbers.length));

    }
}
