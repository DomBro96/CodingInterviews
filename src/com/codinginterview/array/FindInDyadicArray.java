package com.codinginterview.array;

/**
 * 一个整型二维数组，其数字按照从左到右，从上到下依次递增。给出一个数值，判断该递增二维数组中是否有这样一个数字。
 * 常规解法：
 *          1.两重循环的暴力解法。应放弃
 * 算法思路：
 *          1.由该递增二维数组的特点，二维数组中 右上角数字 是该行最大，该列最小的。
 *          2.每次取出二维数组中右上角的数字和要查找的数字进行比较。
 *          3.如果查找数字比右上角数字大，则查找数组的范围应该删除右上角数字所在行。(因为右上角已经是该行最大了)
 *          4.如果查找数字比右上角数字小，则查找数组的范围应该删除右上角数字所在列。(因为右上角已经是该列最小了)
 */
public class FindInDyadicArray {

    public static boolean find(int[][] dyadicArray, int rows, int columns, int number){

        boolean found = false;

        if (dyadicArray != null && rows > 0 && columns >0){

            int row = 0;
            int column = columns - 1;
            while (row < rows && column >= 0){

                if (dyadicArray[row][column] == number){
                    found = true;
                    break;
                }
                //如果查找数字大于右上角元素，则剔除右上角元素所在行
                else if (dyadicArray[row][column] < number){
                    row ++;
                //如果查找元素小于右上角右上角元素，则剔除右上角元素所在列
                }else {
                    columns --;
                }

            }
        }
        return found;
    }

    public static void main(String[] args) {
        int[][] theArray = {{1, 2, 3, 4},
                            {2, 3, 4, 5},
                            {3, 4, 5, 6},
                            {4, 5, 6, 7}};
        System.out.println(find(theArray, 4, 4, 8));
    }
}
