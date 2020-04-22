package com.algorithm;

public class Heap {
    private int PQ_SIZE = 1000;
    private int[] priority_queue = new int[PQ_SIZE+1];//从1开始的数组
    private int n;
    Heap(){
        n = 0;
    }
    void pq_insert(int[] priority_queue, int x)throws Exception{
        if( n>=PQ_SIZE ){
            throw new Exception("overflow insert x");
        }else{
            n = n+1;
            priority_queue[n] = x;
            bubble_up(priority_queue, x);
        }

    }
    void bubble_up(int[] priority_queue; int x){
        if(n == 1 ) {

        }


    }
    int pq_parent(int n){
        if(n == 1){
            return -1;
        }else{
            return n/2;
        }
    }
    int pq_child(int n){
        return n*2;
    }

}
