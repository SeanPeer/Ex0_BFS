package ex0;

import java.util.ArrayList;
import java.util.Collection;

public class NodeData implements node_data {
    private int key;
    private String info;
    private int tag; //0 = white, 1 = black, 2 = grey
    private ArrayList<node_data> neighbors;
    static int keyCounter = 0;
    //Default constructor
    public NodeData(){
        this.key = keyCounter++;
        this.info = "";
        this.tag = 0;
        this.neighbors = new ArrayList<node_data>();

    }
    //Constructor copy key
    public NodeData (int key){
        this.key = key;
        this.info = "";
        this.tag = 0;
        this.neighbors = new ArrayList<node_data>();
    }


    @Override
    //key getter - returning the specific node key
    public int getKey() {
        return this.key;
    }

    @Override
    //neighbors getter - returning an ArrayList of neighbors of the specific node
    public Collection<node_data> getNi() {
        return this.neighbors;
    }

    @Override
    //hasNi is getting a key and checks if this.node has a neighbor with the same key we got
    public boolean hasNi(int key) {
        //node doesn't have any neighbors
        if(this.neighbors == null)
            return false;
        //checks 1 by 1 if there is a neighbor with the key we got
        for (int i = 0;i < neighbors.size();i++){
            if (key == this.neighbors.get(i).getKey())
                return true;
        }
        //the key wasn't found
        return false;
    }

    @Override
    //adding node_data t to this.node neighbors ArrayList and the opposite
    public void addNi(node_data t) {
        this.neighbors.add(t);
    }

    @Override
    //removing node_data node from this.node neighbors ArrayList and the opposite
    public void removeNode(node_data node) {
        if(this.neighbors.contains(node)) {//if node exist in this.neighbors -> remove
            this.neighbors.remove(node);
            node.getNi().remove(this);
        }
    }

    @Override
    public String getInfo() {
        return this.info;
    }

    @Override
    public void setInfo(String s) {
        this.info = s;

    }

    @Override
    //Tag getter - return the tag of this node
    public int getTag() {
        return this.tag;
    }

    @Override
    //Tag setter - updates the tag of this node
    public void setTag(int t) {
        this.tag = t;

    }
}