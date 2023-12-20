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
    public void addVertex(T id) {
        if (findVertex(id) !=null){
            System.out.println("It Already Exısts.");
            return;
        }
        Vertex<T> newVertex = new Vertex<>(id);
        if (head == null)
            head=newVertex;
        else{
            Vertex<T> iterator = head;
            while(iterator.nextVertex!=null)
                iterator=iterator.nextVertex;
            iterator.nextVertex =newVertex;
        }
    }
    public void addEdge(T startId, T endId){
        Vertex<T> current = findVertex(startId);
        if (current == null)
            System.out.println("No Vertex exist with this id.");
        else{
            Edge<T> iterator = current.edgeLink;
            if (iterator == null){
                current.edgeLink=new Edge<>(endId);
            }else{
                while(iterator.nextEdge != null)
                    iterator = iterator.nextEdge;
                iterator.nextEdge = new Edge<>(endId);

            }
        }
    }




}
