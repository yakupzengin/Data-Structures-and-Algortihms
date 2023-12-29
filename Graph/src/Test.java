public class Test {
    public static void main(String [] args){
        Graph<Integer> myGraph = new Graph<>();
        myGraph.addVertex(1);
        myGraph.addVertex(2);
        myGraph.addVertex(3);
        myGraph.addVertex(4);
        myGraph.addVertex(5);

        myGraph.addEdge(1,3, 1);
        myGraph.addEdge(1,4, 1);
        myGraph.addEdge(1,7, 2);
        myGraph.addEdge(2,3, 1);
        myGraph.addEdge(2,7, 3);
        myGraph.addEdge(3,2, 1);
        myGraph.addEdge(4,1, 5);
        myGraph.addEdge(4,9, 1);
        myGraph.addEdge(4,12, 6);
        myGraph.addEdge(5,10,3);
        int findTotalWeight = myGraph.findTotalWeight();
        System.out.println("findTotalWeight = "+findTotalWeight);
        System.out.println(myGraph.hasPathLengthTwo(2,7));
        System.out.println(myGraph.outDegree(1));
        System.out.println(myGraph.inDegree(5));
        System.out.println("display method : ");
        myGraph.display();

    }
}
