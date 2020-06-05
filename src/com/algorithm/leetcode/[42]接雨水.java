package com.algorithm.leetcode;//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
//
// 
//
// 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Mar
//cos 贡献此图。 
//
// 示例: 
//
// 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
//输出: 6 
// Related Topics 栈 数组 双指针


import java.util.Stack;
//定理一：在某个位置i处，它能存的水，取决于它左右两边的最大值中较小的一个。
//定理二：当我们从左往右处理到left下标时，左边的最大值left_max对它而言是可信的，但right_max对它而言是不可信的。（见下图，由于中间状况未知，对于left下标而言，right_max未必就是它右边最大的值）
//定理三：当我们从右往左处理到right下标时，右边的最大值right_max对它而言是可信的，但left_max对它而言是不可信的。


//leetcode submit region begin(Prohibit modification and deletion)

class Solution {
//对于位置left而言，它左边最大值一定是left_max，右边最大值“大于等于”right_max，这时候，如果left_max<right_max成立，那么它就知道自己能存多少水了。无论右边将来会不会出现更大的right_max，都不影响这个结果。
//所以当left_max<right_max时，我们就希望去处理left下标，反之，我们希望去处理right下标。
//双指针
    public int trap2(int[] height) {
        int left = 1;
        int right = height.length-2;
        int rightMax = 0;
        int leftMax = 0;
        int sum = 0;

        for (int i = 1; i < height.length -2; i++){
            if (height[left-1] < height[right+1]){
                leftMax = Math.max(height[left-1],leftMax);
                int min = leftMax;
                if (min > height[left]){
                    sum = sum + min - height[left];
                }
                left++;
            }else {
                rightMax = Math.max(rightMax,height[right+1]);
                int min = rightMax;
                if (min > height[right]){
                    sum = sum + min - height[right];
                }
                right++;
            }
        }
        return sum;
    }
    //动态规划的增强版，只保存一个最大值；
//对于每一格的面积，根据木桶效应，为左右两边最大值得较小值-当前格的值为高，当然要大于当前值
//由于从左向右遍历，左侧的最大值可以即时保存，但右边要提前遍历存储在数组中；
    public int trap(int[] height) {
        if (height.length == 0||height == null)
            return 0;
        int[] right = new int[height.length];
//        for(int i = 1; i<height.length; i++){
//            int max = 0;
//            for (int j = i+1; j<height.length; j++){
//                if (height[j]>max)
//                    max = height[j];
//            }
//            right[i] = max; //i= length -1时 right[i] = 0
//        }
        for (int i = height.length-2; i>0; i--){
            right[i] = Math.max(height[i+1],right[i+1]);
        }
        int sum =0;
        int leftMax = 0;
        for (int i=1; i < height.length; i++ ){
            if (height[i-1]>leftMax)
                leftMax = height[i-1];
            int min = Math.min(leftMax, right[i]);
            if (height[i] < min ){
                sum = sum + min - height[i];
            }
        }
        return sum;
    }
    //
    public int trap6(int[] height) {//使用栈，存储为数组下标，一般情况下栈中存有数据，
        int sum = 0;                //将数组下一个数据和栈中下标的值对比，若小于则继续入栈。
        Stack<Integer> stack = new Stack<>();//若大于则弹出栈首元素，此时若栈为空则退出到外循环将数组压入栈中
        int current = 0;                    //若栈不为空则说明有面积，弹出下一个数据进行计算
        while(current < height.length){
            while(!stack.empty()&&height[current] > height[stack.peek()] ){
                int h = height[stack.pop()];
                if (stack.empty()){
                    break;
                }
                int min = Math.min(height[current],height[stack.peek()]);
                int distance = current - stack.peek()-1;
                sum = sum + (min-h) * distance;
            }
            stack.push(current);
            current++;
        }
        return sum;




    }

}
    

//leetcode eubmit region end(Prohibit modification and deletion)
