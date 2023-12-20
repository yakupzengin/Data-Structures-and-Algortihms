public class Test {
    public static void main(String [] args){
        Graph<Integer> myGraph = new Graph<>();
        myGraph.addVertex(1);
        myGraph.addVertex(2);
        myGraph.addVertex(3);
        myGraph.addVertex(4);
        myGraph.addVertex(5);
        myGraph.addEdge(1,3);
        myGraph.addEdge(1,5);
        myGraph.addEdge(3,4);
        myGraph.addEdge(3,5);
        myGraph.addEdge(4,5);
        myGraph.addEdge(2,3);
        myGraph.display();
        System.out.println(myGraph.outDegree(1));
        System.out.println(myGraph.inDegree(5));

    }
}
