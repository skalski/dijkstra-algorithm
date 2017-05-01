import java.util.Arrays;

/**
 * Created by skalski on 01.05.17.
 */


public class Main {

    public static void main(String[] args) {

        //Let"s build up a pseudo map
        Graph g = new Graph();
        g.addVertex("Aachen", Arrays.asList(new Vertex("Berlin", 7),
                new Vertex("Köln", 8)));
        g.addVertex("Berlin", Arrays.asList(new Vertex("Aachen", 7),
                new Vertex("Frankfurt", 2)));
        g.addVertex("Köln", Arrays.asList(new Vertex("Aachen", 8),
                new Vertex("Frankfurt", 6), new Vertex("Gütersloh", 4)));
        g.addVertex("München", Arrays.asList(new Vertex("Frankfurt", 8)));
        g.addVertex("Essen", Arrays.asList(new Vertex("Hanover", 1)));
        g.addVertex("Frankfurt", Arrays.asList(new Vertex("Berlin", 2),
                new Vertex("Köln", 6), new Vertex("München", 8),
                new Vertex("Gütersloh", 9), new Vertex("Hanover", 3)));
        g.addVertex("Gütersloh", Arrays.asList(new Vertex("Köln", 4),
                new Vertex("Frankfurt", 9)));
        g.addVertex("Hanover", Arrays.asList(new Vertex("Essen", 1),
                new Vertex("Frankfurt", 3)));


        System.out.println(g.getShortestPath("Aachen", "Hanover"));
    }

}
