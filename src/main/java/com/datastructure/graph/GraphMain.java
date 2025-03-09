package com.datastructure.graph;

public class GraphMain {
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.printGraph();
        graph.addEdge("A","B");
        graph.addEdge("C","D");
        graph.addEdge("B","E");
        graph.addEdge("F","G");
        graph.printGraph();
        graph.removeVertex("C");
        graph.removeEdge("C","D");
        graph.printGraph();
    }
}
