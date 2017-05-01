import java.util.List;

/**
 * Created by skalski on 01.05.17.
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Graph {

    private final Map<String, List<Vertex>> vertices;

    public Graph() {
        this.vertices = new HashMap<String, List<Vertex>>();
    }

    public void addVertex(String String, List<Vertex> vertex) {
        this.vertices.put(String, vertex);
    }

    public List<String> getShortestPath(String start, String finish) {
        final Map<String, Integer> distances = new HashMap<String, Integer>();
        final Map<String, Vertex> previous = new HashMap<String, Vertex>();
        PriorityQueue<Vertex> nodes = new PriorityQueue<Vertex>();

        for(String vertex : vertices.keySet()) {
            if (vertex == start) {
                distances.put(vertex, 0);
                nodes.add(new Vertex(vertex, 0));
            } else {
                distances.put(vertex, Integer.MAX_VALUE);
                nodes.add(new Vertex(vertex, Integer.MAX_VALUE));
            }
            previous.put(vertex, null);
        }

        while (!nodes.isEmpty()) {
            Vertex smallest = nodes.poll();
            if (smallest.getId() == finish) {
                final List<String> path = new ArrayList<String>();
                while (previous.get(smallest.getId()) != null) {
                    path.add(smallest.getId());
                    smallest = previous.get(smallest.getId());
                }
                return path;
            }

            if (distances.get(smallest.getId()) == Integer.MAX_VALUE) {
                break;
            }

            for (Vertex neighbor : vertices.get(smallest.getId())) {
                Integer alt = distances.get(smallest.getId()) + neighbor.getDistance();
                if (alt < distances.get(neighbor.getId())) {
                    distances.put(neighbor.getId(), alt);
                    previous.put(neighbor.getId(), smallest);

                    forloop:
                    for(Vertex n : nodes) {
                        if (n.getId() == neighbor.getId()) {
                            nodes.remove(n);
                            n.setDistance(alt);
                            nodes.add(n);
                            break forloop;
                        }
                    }
                }
            }
        }

        return new ArrayList<String>(distances.keySet());
    }

}
