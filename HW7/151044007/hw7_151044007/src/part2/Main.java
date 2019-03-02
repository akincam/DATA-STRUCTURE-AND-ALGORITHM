package part2;

import part2.Edge;
import part2.ListGraph;

import java.util.Random;

public class Main {
    public static void main(String [] args) {
        System.out.println("Directed acyclic graph have random weight(v=15) w=constant----->" + "\n\n\n");
        ListGraph graph = new ListGraph(20, false);
        Random random = new Random();
        graph.insert(new Edge(0,2));
        graph.insert(new Edge(1,1));
        graph.insert(new Edge(2,3));
        graph.insert(new Edge(3,4));
        graph.insert(new Edge(4,5));
        graph.insert(new Edge(5,6));
        graph.insert(new Edge(6,7));
        graph.insert(new Edge(7,8));
        graph.insert(new Edge(8,9));
        graph.insert(new Edge(9,10));
        graph.insert(new Edge(10,11));
        graph.insert(new Edge(11,12));
        graph.insert(new Edge(12,13));
        graph.insert(new Edge(13,14));
        graph.insert(new Edge(14,15));
        graph.insert(new Edge(15,16));
        graph.insert(new Edge(16,17));
        graph.insert(new Edge(17,18));
        graph.insert(new Edge(18,19));
        System.out.println("-----"+graph.is_acyclic_graph(graph));

        graph.plot_graph(graph);

        System.out.println("0 and 19 is connected---->"+graph.is_connected(graph,0,19));
        System.out.println("8 and 1 isnt connected---->"+graph.is_connected(graph,8,1));
        System.out.println("15 and 4 is connected---->"+graph.is_connected(graph,15,4));



    }
}
