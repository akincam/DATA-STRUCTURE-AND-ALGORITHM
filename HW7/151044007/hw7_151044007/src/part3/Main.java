package part3;

import java.util.Random;

public class Main {
    public static void main(String [] args) {
        System.out.println("Directed acyclic graph have random weight(v=15) w=constant----->" + "\n\n\n");
        ListGraph graph = new ListGraph(5, false);
        Random random = new Random();
        graph.insert(new Edge(0,1));
        graph.insert(new Edge(1,2));
        graph.insert(new Edge(2,0));
        graph.insert(new Edge(3,2));
        graph.insert(new Edge(3,1));
        graph.insert(new Edge(4,0));
        graph.insert(new Edge(4,3));
        graph.insert(new Edge(3,1));

        graph.plot_graph(graph);

        System.out.println("if cycle-graph returns false---->"+graph.is_acyclic_graph(graph));

            ListGraph graph1 = (graph.spanningTree(graph));
         System.out.print("After spanning method--->");
         graph.plot_graph(graph1);
        System.out.println("BreadthFirstSearch(this method taken by book sourcecode) parent label--> after spanning");
        int [] arr0=BreadthFirstSearch.breadthFirstSearch(graph1,0);
        int [] arr1=BreadthFirstSearch.breadthFirstSearch(graph1,1);
        int [] arr2=BreadthFirstSearch.breadthFirstSearch(graph1,2);
        int [] arr3=BreadthFirstSearch.breadthFirstSearch(graph1,3);
        for(int i=0;i<5;++i){
            System.out.print(arr0[i]+"  ");
        }
        System.out.println();
        for(int i=0;i<5;++i){
            System.out.print(arr1[i]+"  ");
        }
        System.out.println();
        for(int i=0;i<5;++i){
            System.out.print(arr2[i]+"  ");
        }
        System.out.println();
        for(int i=0;i<5;++i){
            System.out.print(arr3[i]+"  ");
        }
        System.out.println();
        ;
    }
}
