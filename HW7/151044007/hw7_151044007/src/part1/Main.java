package part1;

import java.util.Random;

public class Main {
    public static void main(String [] args){
        System.out.println( "Directed acyclic graph have random weight(v=10 e=20) w=random----->"+"\n" );
        ListGraph graph=new ListGraph(10,true);
        Random random=new Random();
        graph.insert(new Edge(0,1,random.nextInt()/1000000));
        graph.insert(new Edge(0,3,random.nextInt()/1000000));
        graph.insert(new Edge(0,5,random.nextInt()/1000000));
        graph.insert(new Edge(1,2,random.nextInt()/1000000));
        graph.insert(new Edge(1,4,random.nextInt()/1000000));
        graph.insert(new Edge(1,5,random.nextInt()/1000000));
        graph.insert(new Edge(2,3,random.nextInt()/1000000));
        graph.insert(new Edge(2,5,random.nextInt()/1000000));
        graph.insert(new Edge(2,7,random.nextInt()/1000000));
        graph.insert(new Edge(3,4,random.nextInt()/1000000));
        graph.insert(new Edge(3,6,random.nextInt()/1000000));
        graph.insert(new Edge(4,5,random.nextInt()/1000000));
        graph.insert(new Edge(4,7,random.nextInt()/1000000));
        graph.insert(new Edge(4,8,random.nextInt()/1000000));
        graph.insert(new Edge(5,6,random.nextInt()/1000000));
        graph.insert(new Edge(5,8,random.nextInt()/1000000));
        graph.insert(new Edge(6,7,random.nextInt()/1000000));
        graph.insert(new Edge(6,9,random.nextInt()/1000000));
        graph.insert(new Edge(7,8,random.nextInt()/1000000));
        graph.insert(new Edge(8,9,random.nextInt()/1000000));

        graph.plot_graph(graph);
        System.out.println("The graph is directed so is_undirected should be false-->"+graph.is_undirected((graph)));
        System.out.println("The graph is acyclic so is_acyclic should be true-->"+graph.is_acyclic_graph((graph)));
       System.out.println(graph.shortest_path(graph,0,5));
        System.out.println(graph.shortest_path(graph,0,5));
        System.out.println(graph.shortest_path(graph,1,5));
        System.out.println(graph.shortest_path(graph,1,9));

    }
}
