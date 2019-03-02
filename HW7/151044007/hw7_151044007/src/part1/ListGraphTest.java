package part1;

import java.util.Vector;

import static org.junit.jupiter.api.Assertions.*;

class ListGraphTest {

    @org.junit.jupiter.api.Test
    void is_connected() {
        ListGraph g=new ListGraph(8,true);
        Edge edge=new Edge(0,1,2.0);
        g.insert(edge);
        edge=new Edge(0,2,3.0);
        g.insert(edge);
        edge=new Edge(0,4,4.0);
        g.insert(edge);
        edge=new Edge(1,2,5.0);
        g.insert(edge);
        edge=new Edge(1,6,6.0);
        g.insert(edge);
        edge=new Edge(3,7,3.0);
        g.insert(edge);
        edge=new Edge(4,1,4.5);
        g.insert(edge);
        edge=new Edge(4,6,7.0);
        g.insert(edge);
        edge=new Edge(4,7,6.4);
        g.insert(edge);
        edge=new Edge(5,7,5.5);
        g.insert(edge);
        edge=new Edge(6,5,4.7);
        g.insert(edge);
        edge=new Edge(7,5,6.7);
        g.insert(edge);
        g.plot_graph(g);
        System.out.print("is connected");
        assertEquals(true,g.is_connected(g,0,5));


    }
    @org.junit.jupiter.api.Test
    void shortest_path() {
        ListGraph g=new ListGraph(8,true);
        Edge edge=new Edge(0,1,3.0);
        g.insert(edge);
        edge=new Edge(0,2,2.0);
        g.insert(edge);
        edge=new Edge(0,3,6.0);
        g.insert(edge);
        edge=new Edge(1,5,4.0);
        g.insert(edge);
        edge=new Edge(2,4,3.4);
        g.insert(edge);
        edge=new Edge(3,5,4.1);
        g.insert(edge);
        edge=new Edge(3,7,4.2);
        g.insert(edge);
        edge=new Edge(5,1,6.4);
        g.insert(edge);
        edge=new Edge(4,6,6.4);
        g.insert(edge);
        edge=new Edge(5,7,1.2);
        g.insert(edge);
        edge=new Edge(1,6,3.3);
        g.insert(edge);
        g.plot_graph(g);
        Vector v=g.shortest_path(g,0,6);
        System.out.print(v);

    }
    @org.junit.jupiter.api.Test
    void is_undirected() {
        ListGraph g=new ListGraph(8,true);
        Edge edge=new Edge(0,1,3.0);
        g.insert(edge);
        edge=new Edge(0,2,2.0);
        g.insert(edge);
        edge=new Edge(0,3,6.0);
        g.insert(edge);
        edge=new Edge(1,5,4.0);
        g.insert(edge);
        edge=new Edge(2,4,3.4);
        g.insert(edge);
        edge=new Edge(3,5,4.1);
        g.insert(edge);
        edge=new Edge(3,7,4.2);
        g.insert(edge);
        edge=new Edge(5,1,6.4);
        g.insert(edge);
        edge=new Edge(4,6,6.4);
        g.insert(edge);
        edge=new Edge(5,7,1.2);
        g.insert(edge);
        edge=new Edge(1,6,3.3);
        g.insert(edge);
        g.plot_graph(g);
        System.out.println("isnt is_undirected");
        assertEquals(false,g.is_undirected(g));
    }
    @org.junit.jupiter.api.Test
    void is_acycle() {
        ListGraph g=new ListGraph(8,true);
        Edge edge=new Edge(0,1,3.0);
        g.insert(edge);
        edge=new Edge(0,2,2.0);
        g.insert(edge);
        edge=new Edge(0,3,6.0);
        g.insert(edge);
        edge=new Edge(1,5,4.0);
        g.insert(edge);
        edge=new Edge(2,4,3.4);
        g.insert(edge);
        edge=new Edge(3,5,4.1);
        g.insert(edge);
        edge=new Edge(3,7,4.2);
        g.insert(edge);
        edge=new Edge(5,1,6.4);
        g.insert(edge);
        edge=new Edge(4,6,6.4);
        g.insert(edge);
        edge=new Edge(5,7,1.2);
        g.insert(edge);
        edge=new Edge(1,6,3.3);
        g.insert(edge);

        System.out.print("isnt is_acycle");
        assertEquals(true,g.is_acyclic_graph(g));
        ListGraph graph=new ListGraph(4,true);
        edge=new Edge(1,2,1.2);
        graph.insert(edge);
        edge=new Edge(2,3,1.2);
        graph.insert(edge);
        edge=new Edge(3,1,1.2);
        graph.insert(edge);
        g.plot_graph(g);
        System.out.print("is_acycle");
        assertEquals(false,g.is_acyclic_graph(graph));

    }
    @org.junit.jupiter.api.Test
    void plot_graph() {
        ListGraph g=new ListGraph(8,true);
        Edge edge=new Edge(0,1,3.0);
        g.insert(edge);
        edge=new Edge(0,2,2.0);
        g.insert(edge);
        edge=new Edge(0,3,6.0);
        g.insert(edge);
        edge=new Edge(1,5,4.0);
        g.insert(edge);
        edge=new Edge(2,4,3.4);
        g.insert(edge);
        edge=new Edge(3,5,4.1);
        g.insert(edge);
        edge=new Edge(3,7,4.2);
        g.insert(edge);
        edge=new Edge(5,1,6.4);
        g.insert(edge);
        edge=new Edge(4,6,6.4);
        g.insert(edge);
        edge=new Edge(5,7,1.2);
        g.insert(edge);
        edge=new Edge(1,6,3.3);
        g.insert(edge);

        g.plot_graph(g);
        ListGraph graph=new ListGraph(4,true);
        edge=new Edge(1,2,1.2);
        graph.insert(edge);
        edge=new Edge(2,3,1.2);
        graph.insert(edge);
        edge=new Edge(3,1,1.2);
        graph.insert(edge);
        System.out.println("------------");
        graph.plot_graph(graph);
    }
}