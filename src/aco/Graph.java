package aco;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by Eugene on 01.07.2017.
 */
public class Graph {

    private List<Vertex> vertexList;

    public Graph() {
        vertexList = new ArrayList<>();
    }

    public Graph(ArrayList<Vertex> vertexList) {
        this.vertexList = new ArrayList<>(vertexList);
    }

    public void addVertex(Vertex vertex) {
        vertexList.add(vertex);
    }

    public Vertex searchVertexByName(String name) {
        for (Vertex vertex : vertexList) {
            if (vertex.getVertexName().equals(name)) {
                return vertex;
            }
        }

        return null;
    }

    public void deleteVertex(String name) {
        Iterator<Vertex> iterator = vertexList.iterator();

        while (iterator.hasNext()) {
            Vertex vertex = iterator.next();
            if (vertex.getVertexName().equals(name)) {
                iterator.remove();
            }
        }
    }

    public int getNumberOfVertices() {
        return vertexList.size();
    }

    public List<Vertex> getVertexList() {
        return vertexList;
    }

    @Override
    public String toString() {
        return "Graph {" +
                "vertexList = " + vertexList +
                '}';
    }
}
