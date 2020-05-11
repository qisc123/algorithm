package com.algorithm;

import java.util.Queue;

public class Graph {
    int MAX_VERTICES = 1000;
    EdgeNode[] edges = new EdgeNode[MAX_VERTICES+1];//邻接信息，就是边的一个固定顶点
    int[] degree = new int[MAX_VERTICES+1];//每个顶点的出度
    int nVertices;
    int nEdges;
    boolean directed;

    boolean[] processed = new boolean[MAX_VERTICES+1];
    boolean[] discovered = new boolean[MAX_VERTICES+1];
    int[] parent = new int[MAX_VERTICES+1];

    void initializeGraph(Graph graph, boolean directed){
        int i;
        graph.nEdges = 0;
        graph.nVertices = 0;
        graph.directed = directed;
        for(int num : degree){
            degree[num] = 0;
        }
        for(EdgeNode edge : edges){
            edge = null;
        }
    }
 /*
    void readGraph(Graph g, boolean directed, int m, ){

        int i;   //计数器
        int m;  //边的条数
        int x, y; //边（x，y）

}
*/

     void insertEdge(Graph graph, int x, int y, boolean directed){
         EdgeNode edgeNode = new EdgeNode();
         edgeNode.y = y;
         edgeNode.next = graph.edges[x]; //链接上链表
         graph.edges[x] = edgeNode;   //表头重新指向新插入的边node
         graph.degree[x]++;

         if(!directed){
             insertEdge(graph,y,x,true);//若为无向图，再插入一遍
             //是否要加入一行 graph.nEdges++;不用，在图中，还是只有一条边
         }else{
             graph.nEdges++;
         }
     }

     void initializeSearch(Graph graph){
         int i;
         for (i = 1; i <= graph.nVertices; i++){
             processed[i] = discovered[i] = false;
             parent[i] = -1;
         }
     }

     void bfs(Graph graph, int v){
         Queue q;


     }

      void dfs(Graph graph){

    }
}
