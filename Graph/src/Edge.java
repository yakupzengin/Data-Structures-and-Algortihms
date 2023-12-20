public class Edge <T extends Comparable>{
    T vertexId;
    Edge<T> nextEdge;

    public Edge(T id){
        vertexId=id;
        nextEdge=null;
    }
}
