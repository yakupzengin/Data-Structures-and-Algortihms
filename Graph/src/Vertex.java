public class Vertex <T extends Comparable>{
    T id;
    Vertex<T> nextVertex;
    Edge<T> edgeLink;
    public Vertex(T id){
        this.id=id;
        nextVertex=null;
        edgeLink=null;
    }
}
