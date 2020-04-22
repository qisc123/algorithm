package com.algorithm;

public class Graph {
    int MAX_VERTICES = 1000;
    EdgeNode[] edges = new EdgeNode[MAX_VERTICES+1];//邻接信息，就是边的一个固定顶点
    int[] degree = new int[MAX_VERTICES+1];//每个顶点的出度
    int nVertices;
    int nEdges;
    boolean directed;

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

         if(directed ==false){
             insertEdge(graph,y,x,true);//若为无向图，再插入一遍
         }else{
             graph.nEdges++;
         }
     }

     void bfs(Graph graph, int v){

     }

      void dfs(Graph graph){

    }
}
