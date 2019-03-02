package part3;

import java.util.*;
public class ListGraph extends AbstractGraph {
    private List<Edge>[] edges;

    public ListGraph(int numV,boolean directed){
        super(numV,directed);
        edges=new List[numV];
        for(int i=0;i<numV;i++)
            edges[i]=new LinkedList< Edge>();
    }
    public Iterator<Edge> edgeIterator(int source){
        return edges[source].iterator();
    }
    public boolean isEdge(int source, int dest) {
        for(int i=0;i<edges[source].size();i++)
            if(edges[source].get(i).getSource()==source&&edges[source].get(i).getDest()==dest)
                return true;
        return false;
    }

    public void insert(Edge edge) {
        edges[edge.getSource()].add(new Edge(edge.getSource(),
                edge.getDest(),
                edge.getWeight()));
        if (!isDirected()) {
            edges[edge.getDest()].add(new Edge(edge.getDest(),
                    edge.getSource(),
                    edge.getWeight()));
        }
    }
    public Edge getEdge(int source, int dest) {
        Edge target =
                new Edge(source, dest,Double.POSITIVE_INFINITY);
        for (Edge edge : edges[source]) {
            if (edge.getDest()==target.getDest()&&edge.getSource()==target.getSource())
                return edge; // Desired edge found, return it.
        }
        // Assert: All edges for source checked.
        return target; // Desired edge not found.
    }



    /**********************************************************************
     *                                                                    *
     *Yazdığım metotlar buradan başlıyor                                  *
     *is_connected,is_connected1(yardımcı metod)                          *
     *is_shortest                                                         *
     *dijkstrasAlgorithm(pseudocode a göre kendim yazdım)                 *
     *a_cyclic                                                            *
     *is_directed                                                         *
     *********************************************************************/

    /**
     * Takes a graph and two label
     * checks whether there is a connection between them
     * Uses helper method(is_connected1)
     * @param g graph
     * @param v1 label
     * @param v2 label
     * @return TRUE​ if there is a path from ​ v1​ to ​ v2​ in g,​ ​ FALSE​ if not.
     */
    public boolean is_connected(ListGraph g,int v1,int v2) {
        if(is_connected1(g,v1,v2)==true||is_connected1(g,v2,v1)==true) {
            return true;
        }
        else
            return false;
    }

    /**
     * Takes a graph and two label
     * checks whether there is a connection between them
     * Uses helper method(is_connected1)
     * visited(ArrayList) checks whether is visited
     * queue adds visited label and its children
     * starts first label and adds queue its conneciton labels and add arrayList this visited label.
     * checks whether there is a connection between them if not queue.remove and continue after label
     * if there is no path return false
     * if v1 and v2 unconvenient label throws ArrayIndexOutOfBoundsException
     * @param g graph
     * @param v1 label
     * @param v2 label
     * @return TRUE​ if there is a path from ​ v1​ to ​ v2​ in g,​ ​ FALSE​ if not.
     */
    private boolean is_connected1(ListGraph g,int v1,int v2){
        ArrayList<Integer> visited=new ArrayList();
        Queue<Integer> queue=new LinkedList();
        /**
         * if v1 or v2 larger than graph length throws exception
         */
        if(g.edges.length<=v1||g.edges.length<=v2){
            throw new ArrayIndexOutOfBoundsException("v1 or v2 are not in given graph");
        }
        int count=0;
        /**
         * adds start node
         */
        queue.add(g.edges[v1].get(count).getSource());
        visited.add(queue.peek());
        /**
         * adds startlabel's children and marking visited label(adds arrayList)
         */
        while(count<g.edges[v1].size()){
            queue.add(g.edges[v1].get(count).getDest());
            visited.add(g.edges[v1].get(count).getDest());
            count++;
        }
        /**
         * loop continues queue size isn't 0. Because if queue is empty all label are visited.
         */
        while (queue.size()>0){
            count=0;
            /**
             * if there is path v1 from v2 or vice versa return true.
             */
            if(queue.peek().equals(v2))
                return true;
            else{
                //remove checked label and continue its other connected label
                queue.remove();
                while (queue.peek()!=null&&g.edges[queue.peek()].size()>count){
                    /**
                     * if label not visited adds queue and marking
                     */
                    if(visited.contains(g.edges[queue.peek()].get(count).getDest())==false) {
                        queue.add(g.edges[queue.peek()].get(count).getDest());
                        visited.add(g.edges[queue.peek()].get(count).getDest());
                        count++;
                    }
                    else
                        count++;
                }

            }
        }
        return false;
    }

    /**
     *returns empty vector if there is no connection between given labels
     * uses dijkstrasAlgorithm
     *add shortest path vice versa in vector and returns
     *
     * @param g List graph
     * @param v1 start index
     * @param v2 end index
     * @return Vector shortest path
     */
    public Vector shortest_path(ListGraph g,int v1,int v2){
        if(g.is_connected(g,v1,v2)==false)
            return new Vector();
        else {
            double cost[] = new double[g.getNumV()];
            int[] pred = new int[g.getNumV()];
            Vector returnV1=new Vector();
            Vector returnV=new Vector();
            dijkstrasAlgorithm(g, v1,cost,pred);
            returnV.add(v2);
            int count=v2;
            while(true){
                count=pred[count];
                returnV.add(count);
                if(count==v1)
                    break;;
            }
            for(int i=returnV.size()-1;i>=0;--i)
                returnV1.add(returnV.get(i));
            return returnV1;
        }
    }

    /**
     * start add to Queue
     * cost and predessor is initializes to check relative node
     * start label cost 0
     * While loop continue size is larger than 0
     * compare and finds the smallest cost in cost[]
     * looks its neighbours and finds the smallest cost edge. add new cost in relative index
     * remove the used label and adds the smallest edge destination and continue.
     * @param graph ListGraph
     * @param start start index
     * @param cost total minimum cost
     * @param pred predeccessor
     */
    public static void dijkstrasAlgorithm(ListGraph graph,
                                          int start,double cost[],int pred[]) {

        PriorityQueue<Integer> openList = new PriorityQueue<>();
        openList.add(start);
        for (int i = 0; i < graph.getNumV(); i++) {
            cost[i] = Double.POSITIVE_INFINITY;
            pred[i] = -1;
        }
        cost[start]=0;
        while (openList.size()!=0){
            double low_cost=Double.POSITIVE_INFINITY;
            int index=-1;
            int vertex=-1;
            for(int i=0;i<cost.length;i++){
                if(cost[i]<low_cost) {
                    low_cost = cost[i];
                    index=i;
                }
            }
            vertex=openList.peek();
            openList.remove();

            for (int v=0;v<graph.edges.length;++v) {
                if (graph.isEdge(vertex, v)) {
                    double weight = graph.getEdge(vertex, v).getWeight();
                    if (cost[v]> cost[vertex]+weight) {
                        cost[v] = cost[vertex]+weight;
                        pred[v] = vertex;
                        openList.add(v);
                    }
                }
            }
        }
    }

    /**
     *  Looks all labels whether is directed or undirected.
     * if v1 v2 is edge and v2 v1 is edge and costs are same boo is true
     * if v1 v2 is edge and v2 v1 is edge and costs are different return false
     * if v1 v2 is edge but v2 v1 isnt edge return false
     * remove.element from set and continue other label
     *
     * @param graph List graph
     * @return trye if graph is undirected else returns false
     */
    public boolean is_undirected(ListGraph graph){
        Queue<Integer> set=new LinkedList<>();
        boolean boo=false;
        for(int ii=0;ii<graph.getNumV();ii++)
            set.add(ii);
        for(int j=0;j<graph.getNumV();j++) {
            for (int i = 0; i < graph.getNumV(); i++) {
                if (set.peek() != i)
                    continue;
                else if (graph.isEdge(set.peek(), i) == true) {
                    if (graph.isEdge(i, set.peek()) == true &&
                            graph.getEdge(set.peek(), i).getWeight() ==
                                    graph.getEdge(i, set.peek()).getWeight())
                        boo = true;
                } else if (graph.isEdge(set.peek(), i) == true && graph.isEdge(i, set.peek()) == false) {
                    return false;
                } else if (graph.isEdge(set.peek(), i) == true) {
                    if (graph.isEdge(i, set.peek()) == true &&
                            graph.getEdge(set.peek(), i).getWeight() !=
                                    graph.getEdge(i, set.peek()).getWeight())
                        return false;
                }
            }
            set.remove();
        }
        return boo;
    }

    /**
     * Looks all label so adds all label index in queue and check them
     * Looks a label's parent's parent is label return true(directed)
     * if graph is undirected looks prev parents if there is differences prev parent this means that
     * path return start label return true else return false
     * Bu metotda kitapta bulunan breathFirstSearch metotu alinmis ve üzerinde degisiklik yapilmistir
     * @param g List graph
     * @return true if graph is a cyclic else return false.
     */
    public boolean is_acyclic_graph(ListGraph g) {

        Queue<Integer> label=new LinkedList<>();
        for (int i = 0; i < g.getNumV(); i++) {
            label.add(i);
        }
        while(label.size()>0) {
            Queue<Integer> theQueue = new LinkedList<Integer>();
            int[] parent = new int[g.getNumV()];
            for (int i = 0; i < g.getNumV(); i++) {
                parent[i] = -1;
            }

            boolean[] identified = new boolean[g.getNumV()];

            identified[label.peek()] = true;
            theQueue.offer(label.peek());
            while (!theQueue.isEmpty()) {
                int current = theQueue.remove();
                Iterator<Edge> itr = g.edgeIterator(current);
                while (itr.hasNext()) {
                    Edge edge = itr.next();
                    int neighbor = edge.getDest();
                    if (!identified[neighbor]) {
                        identified[neighbor] = true;
                        theQueue.offer(neighbor);

                        int check=parent[neighbor];
                        parent[neighbor] = current;
                        if(is_undirected(g)&&check!=-1)
                            return false;
                        else if(is_undirected(g)==false){
                            Iterator<Edge> itr1 = g.edgeIterator(current);
                            while (itr1.hasNext()) {
                                Edge edge1 = itr1.next();
                                int neighbor1 = edge1.getDest();
                                Iterator<Edge> itr2 = g.edgeIterator(neighbor1);
                                while (itr2.hasNext()) {
                                    Edge edge2 = itr2.next();
                                    int neighbor2 = edge2.getDest();
                                    Iterator<Edge> itr3 = g.edgeIterator(neighbor2);
                                    while (itr3.hasNext()) {
                                        Edge edge3 = itr3.next();
                                        int neighbor3 = edge3.getDest();
                                        if(current==neighbor3)
                                            return false;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            label.remove();
        }
        return true;
    }


    /**
     * looks all vertex in for loop
     * adds first source and add its neighbours.
     * @param graph ListGraph
     */
    public void plot_graph(ListGraph graph){
        for(int i=0;i<graph.getNumV();i++) {
            if(graph.edges[i].size()!=0)
                System.out.print(graph.edges[i].get(0).getSource() + "-->");
            if(graph.edges[i].size()==0)
                System.out.print(i);
            for (int ii = 0; ii < graph.edges[i].size(); ii++) {
                System.out.print(graph.edges[i].get(ii).getDest());
                if(ii+1!=graph.edges[i].size())
                    System.out.print("-->");
            }
            System.out.println();
        }
    }

    /**
     *insert start index(i add 0)
     * insert start indexs neighbour
     *add start index in visited to check after
     * listGraph.edges.length==0 return sane List
     *if queue.size>0 loops continue
     * if first element of queue's isnt visited adds add parent of it
     *  and adds it in visited.
     *  looks its neighbour if there is neighbour adds in queue
     *  remove used label and continue others.
     *
     * @param listGraph
     * @return ListGraph
     */
    public ListGraph spanningTree(ListGraph listGraph) {

        ArrayList<Integer> visited = new ArrayList<>();
        ListGraph newG = new ListGraph(listGraph.getNumV(), false);

        for (int i = 0; i < listGraph.getNumV(); i++)
            visited.add(-1);

        Queue<Edge> queue = new LinkedList();

        Iterator<Edge> itr = listGraph.edgeIterator(0);
        visited.add(0);

        if(listGraph.edges.length==0)
            return listGraph;
        while (itr.hasNext()) {
            Edge edge = itr.next();
            queue.add(edge);
        }
        while (queue.size() > 0) {
            if (visited.contains(queue.peek().getDest()) == false) {
                newG.insert(queue.peek());
                visited.add(queue.peek().getDest());

                itr = listGraph.edges[queue.peek().getDest()].iterator();
                while (itr.hasNext()) {
                    Edge edge = itr.next();
                    queue.add(edge);
                }
                visited.add(queue.peek().getDest());
            }
            queue.remove();
        }
        return newG;
    }
}