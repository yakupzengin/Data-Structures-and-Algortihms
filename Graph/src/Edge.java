public class Edge <T extends Comparable>{
    T vertexId;
    int weight;
    Edge<T> nextEdge;
    public Edge(T id,int w){
        vertexId=id;
        nextEdge=null;
        weight = w;
    }
}
