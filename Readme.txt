Description:
The project is the First assignment under a rolling task project in OOP course.
Ex0 deals with creating a non-directional graph using nodes and describing the edges by List of neighbors of the this specific node.
	
#Readme 
in this poject i implement the object NodeData that implements the interfase named node_data.
The "node_data" create nodes that each node has : String Key, int Info, int Tag, Arraylist neighbors, Int KeyCounter. 
next i implement the opbject Graph_DS than implement the interface named graph,
graph is creating a graph from the node_data by using the neighbors Arraylist as the edges.
each graph graph is built from : Hashmap that contains the <node.key, node itsef>, edge counter and mc (changes counter).
and last class is Graph_algo that implements the interface graph_algorithms.
its perpose is to scan the graph fast and get from it some info, such as if the graph is connected, the shortest path distance in the graph 
by numbers and the shrotest path in the graph by nodes.
 
