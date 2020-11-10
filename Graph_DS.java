package ex0;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class Graph_DS implements graph {
    private HashMap<Integer, node_data> g;
    private int edgeCounter;
    private int mc;

    public Graph_DS() {
        this.g = new HashMap<>();
        this.edgeCounter = 0;
        this.mc = 0;
    }
    public Graph_DS(graph g) {
        this.g = new HashMap<>();
        this.edgeCounter = g.edgeSize();
        this.mc = 0;
    }

    @Override
    //getter - get a node by the key
    public node_data getNode(int key) {
        if(this.g.containsKey(key))
            return this.g.get(key);
        return null;
    }

    @Override
    //the function returns if there is an edge between nodes
    public boolean hasEdge(int node1, int node2) {
        node_data node_1 = getNode(node1);
        if(node_1!= null) {
            if(node_1.hasNi(node2))
                return true;
        }
        return false;
    }

    @Override
    //adding new node to the map
    public void addNode(node_data n) {
        if(!this.g.containsKey(n.getKey())) {//if the Key doesn't exist -> Add
            this.g.put(n.getKey(), n);
            this.mc++;
        }
    }

    @Override
    //connecting to nodes with an edge and adding these node to the neighbors list of each node
    public void connect(int node1, int node2) {
        node_data node_1 = getNode(node1);
        node_data node_2 = getNode(node2);
        if(node_1!= null && node_2!= null && node_1!= node_2 && !hasEdge(node1,node2)){
            node_1.addNi(node_2);
            node_2.addNi(node_1);
            this.edgeCounter++;
            this.mc++;
        }
    }

    @Override
    //getter - returns the value of the node
    public Collection<node_data> getV() {
        return this.g.values();
    }

    @Override
    //getter - recieving an int and returns the value of the node that contains this int
    public Collection<node_data> getV(int node_id) {
        return getNode(node_id).getNi();
    }

    @Override
    //receving an int and removing the node by this int - also delete the exact node's neighbors
    public node_data removeNode(int key) {
        node_data node_1 = getNode(key);
        if(node_1!= null) {
            ArrayList<node_data> node_neighbors = (ArrayList) node_1.getNi();
            while(node_neighbors.size()!=0){
                node_1.removeNode(node_neighbors.get(0));
                this.edgeCounter--;
                this.mc++;
            }
            this.g.remove(key);
            this.mc++;
            return node_1;
        }
        return null;
    }

    @Override
    //receving 2 ints and deletes the edge between 2 nodes by using getNode
    public void removeEdge(int node1, int node2) {
        if(hasEdge(node1,node2)) {
            node_data node_1 = getNode(node1);
            node_data node_2 = getNode(node2);
            if (node_1 != null && node_2 != null) {
                node_1.removeNode(node_2);
                this.edgeCounter--;
            }
        }
    }

    @Override
    public int nodeSize() {
        return this.g.size();
    }

    @Override
    public int edgeSize() {
        return this.edgeCounter;
    }

    @Override
    public int getMC() {
        return this.mc;
    }
}
