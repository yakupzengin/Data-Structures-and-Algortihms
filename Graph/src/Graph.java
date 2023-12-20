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





}
