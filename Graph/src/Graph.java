public class Graph <T extends Comparable>{
    Vertex<T> head;

    public Vertex<T> findVertex(T id){
        Vertex<T> iterator = head;
        while(iterator !=null){
            if (iterator.id.compareTo(id) == 0){
                return iterator;
            }
            iterator = iterator.nextVertex;
        }
        return null;
    }






}
