package com.datastructure.graph;

import java.util.ArrayList;
import java.util.HashMap;

public class Graph {
    //Adding Vertex
    private HashMap<String, ArrayList<String>> adjList = new HashMap<>();
    public boolean addVertex(String vertex){
        if(adjList.get(vertex)==null){
            adjList.put(vertex, new ArrayList<>());
            return true;
        }
        return false;
    }
    //Print Graph
    public void printGraph(){
        System.out.println(adjList);
    }
    //Adding Edge
    public boolean addEdge(String vertex1,String vertex2){
        if(adjList.get(vertex1)!=null && adjList.get(vertex2)!=null){
            adjList.get(vertex1).add(vertex2);
            adjList.get(vertex2).add(vertex1);
            return true;
        }
        return false;
    }
    //remove Edge
    public boolean removeEdge(String vertex1,String vertex2){
    if(adjList.get(vertex1)!=null && adjList.get(vertex2)!=null){
        adjList.get(vertex1).remove(vertex2);
        adjList.get(vertex2).remove(vertex1);
        return true;
    }
    return false;
    }

    //remove vertex
    public boolean removeVertex(String vertex) {
        if(adjList.get(vertex)==null) return false;
        for (String otherVertex :adjList.get(vertex)){
            adjList.get(otherVertex).remove(vertex);
        }
        adjList.remove(vertex);
        return true;
    }

}
