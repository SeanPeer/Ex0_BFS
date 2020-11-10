package ex0;

import java.util.*;

public class Graph_Algo implements graph_algorithms {
    private graph g;
    private HashMap<Integer,Integer> parent;
    private HashMap<Integer,Integer> dist;

    @Override
    public void init(graph g) {
        this.g = g;
        //init maps for bfs
        this.parent = new HashMap<>();
        this.dist = new HashMap<>();
    }

    @Override
    public graph copy() {
        graph new_graph = new Graph_DS(this.g); // create a new graph object -> new_graph

        for (node_data node : this.g.getV()) {  // for each vertex in graph g.getV()
            node_data new_node = new NodeData(node.getKey()); //create a new node based on the old node's key
            new_graph.addNode(new_node); //add the new_node to new_graph
        }

        for(node_data node : this.g.getV()){ // for each vertex in graph g.getV()
            node_data tmp = new_graph.getNode(node.getKey()); // get the new node based on old's key

            for (node_data t : node.getNi()) { // for each neighbor of node
                tmp.addNi(new_graph.getNode(t.getKey())); //add new ni based on old neighbor's key
            }
            tmp.setInfo(node.getInfo()); //set info based on old neighbor's info
            tmp.setTag(node.getTag());  // set tag based on old neighbor's tag
        }

        return new_graph;
    }

    private void BFS(int src) {
        Queue<node_data> queue = new LinkedList<node_data>();
        for(node_data node : g.getV()){
            this.parent.put(node.getKey(),null);
            this.dist.put(node.getKey(), -1);
            node.setTag(0); //white
        }

        this.dist.put(this.g.getNode(src).getKey(),0);
        queue.add(g.getNode(src));

        while(!queue.isEmpty()){
            node_data u = queue.poll();

            for (node_data ni : u.getNi()) {
                if(ni.getTag()==0){
                    ni.setTag(2);//grey
                    this.parent.put(ni.getKey(),u.getKey());
                    this.dist.put(ni.getKey(),this.dist.get(u.getKey())+1);
                    queue.add(ni);

                }

            }
            u.setTag(1);//black
        }

    }

    @Override
    public boolean isConnected() {
        if(this.g.nodeSize() == 1 ||this.g.nodeSize() == 0)
            return true;

        List<node_data> list = new ArrayList<>(g.getV());
        BFS(list.get(0).getKey());

        for(node_data node : this.g.getV()) {
            if (node.getTag() == 0)
                return false;
        }
        return true;
    }

    @Override
    public int shortestPathDist(int src, int dest) {
        BFS(src);
        return dist.get(dest);
    }

    @Override
    public List<node_data> shortestPath(int src, int dest) {
        BFS(src);
        List<node_data> path = new ArrayList<node_data>();

        int t = dest;

        while(true) {
            path.add(this.g.getNode(t));
            t = parent.get(t);

            if (t == src) {
                path.add(this.g.getNode(t));
                break;
            }
        }

        System.out.println(path);

        return path;
    }
}
