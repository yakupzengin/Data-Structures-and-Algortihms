public class    Graph <T extends Comparable> {
    Vertex<T> head;

    public void findNeighbor(T ıd){
        Vertex<T> current = findVertex(ıd);
        if (current == null){
            return;
        }
        Edge<T> iteratorEdge = current.edgeLink;
        while(iteratorEdge != null){
            System.out.print(iteratorEdge.vertexId + " ");
            iteratorEdge = iteratorEdge.nextEdge;
        }
        System.out.println();
    }

    public boolean hasPathLengthTwo(T startId, T endId) {
        Vertex<T> startVertex = findVertex(startId);
        if (startVertex == null){
            System.out.println("There is no Start vertex with startID");
            return false;
        }
        Edge<T> iteratorEdge = startVertex.edgeLink;
        int count =0;
        while(count <=2  && iteratorEdge != null){
            count++;
            System.out.println("count "+ count + " - " + "iteratorEDge.vertexID" + iteratorEdge.vertexId);
            if (iteratorEdge.vertexId.compareTo(endId) ==0 && count==2){
                return true;
            }
            iteratorEdge = iteratorEdge.nextEdge;
        }

        return false; // No path of length 2 found
    }

    public int findTotalWeight(){
        int totalWeight=0;
        Vertex<T> iteratorVertex=head;

        while( iteratorVertex != null){
            Edge<T> iteratorEdge = iteratorVertex.edgeLink;
            while(iteratorEdge !=null){
                totalWeight += iteratorEdge.weight;
                iteratorEdge = iteratorEdge.nextEdge;
            }
            iteratorVertex = iteratorVertex.nextVertex;
        }
        return totalWeight;
    }
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
    public void addEdge(T startingId, T endId, int w){
        Vertex<T> current=findVertex(startingId);
        Edge<T> newEdge=new Edge<>(endId, w);
        if (current== null){
            return;
        }
        Edge<T> iteratorEdge=current.edgeLink;
        if(iteratorEdge==null)
            current.edgeLink=newEdge;
        else{
            while(iteratorEdge.nextEdge!=null)
                iteratorEdge=iteratorEdge.nextEdge;
            iteratorEdge.nextEdge=newEdge;
        }
    }
//    public void addEdge(T startId, T endId){
//        Vertex<T> current = findVertex(startId);
//        if (current == null)
//            System.out.println("No Vertex exist with this id.");
//        else{
//            Edge<T> iterator = current.edgeLink;
//            if (iterator == null){
//                current.edgeLink=new Edge<>(endId);
//            }else{
//                while(iterator.nextEdge != null)
//                    iterator = iterator.nextEdge;
//                iterator.nextEdge = new Edge<>(endId);
//
//            }
//        }
//    }

    public int outDegree(T id){
        int count=0;
        Vertex<T> current=findVertex(id);
        if (current==null){
            return count;
        }
        Edge<T> iteratorEdge=current.edgeLink;
        while(iteratorEdge!=null)
        {
            iteratorEdge=iteratorEdge.nextEdge;
            count++;

        }
        return count;
    }
    public int inDegree(T id){
        int count = 0;
        Vertex<T> iteratorVertex = head;
        while(iteratorVertex != null){
            Edge<T> iteratorEdge = iteratorVertex.edgeLink;
            while(iteratorEdge != null){
                if(iteratorEdge.vertexId.compareTo(id) == 0){
                    count++;
                }
                iteratorEdge = iteratorEdge.nextEdge;
            }
            iteratorVertex = iteratorVertex.nextVertex;
        }
        return count;
    }
    public void display(){
        Vertex<T> iterator = head;
        while (iterator !=null){
            System.out.print(iterator.id + " ");
            Edge<T> iteratorEdge = iterator.edgeLink;
            while(iteratorEdge != null){
                System.out.print(iteratorEdge.vertexId+ " ");
                iteratorEdge = iteratorEdge.nextEdge;
            }
            System.out.println();
            iterator = iterator.nextVertex;
        }
    }
}
