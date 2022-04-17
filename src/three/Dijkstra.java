package three;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;

import test.graph.Edge;
import test.graph.Node;

// no negative weight
public class Dijkstra {
    //维护这张表，一直更新
    public static HashMap<Node,Integer> dijkstral(Node from){
        HashMap<Node,Integer>distanceMap = new HashMap<>();
        //自己到自己是0
        distanceMap.put(from,0);
        //更新过的点进set 不做比较了
        HashSet<Node> selectedNodes = new HashSet<>();
        //获取下一个最小值，且没被更新过的点
        Node minNode = getMinDistanceAndUnselectedNode(distanceMap,selectedNodes);
        while(minNode !=null){
            int distance = distanceMap.get(minNode);
            for(Edge edge:minNode.edges){
                Node toNode = edge.to;
                if(!distanceMap.containsKey(toNode)){
                    distanceMap.put(toNode,distance + edge.weight);
                }else{
                    distanceMap.put(edge.to,Math.min(distanceMap.get(toNode),distance + edge.weight));
                }
            }   
            selectedNodes.add(minNode);
            minNode = getMinDistanceAndUnselectedNode(distanceMap,selectedNodes);
        }

        return distanceMap;
    }

    public static Node getMinDistanceAndUnselectedNode(HashMap<Node,Integer> distanceMap,HashSet<Node> touchedNodes){
        Node minNode = null;
        int minDistance = Integer.MAX_VALUE;
        for(Entry<Node,Integer>entry:distanceMap.entrySet()){
            Node node = entry.getKey();
            int distance = entry.getValue();
            if(!touchedNodes.contains(node) && distance <minDistance){
                minNode = node;
                minDistance = distance;
            }            
        }
        return minNode;
    }
    
}
