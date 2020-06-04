package com.algorithm;

import java.util.Stack;

public class Main {
    public static  int trap6(int[] height) {
        int sum = 0;
        Stack<Integer> stack = new Stack<>();
        int current = 0;
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
        return sum;}
    public static void main(String[] args){
	// write your code here
      int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
      int sum = trap6(height);
      System.out.println(sum);
    }
}
