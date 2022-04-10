package three;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Stack;

import test.graph.Edge;
import test.graph.Graph;
import test.graph.Node;

// 最小生成树
public class Kruskal {
    public HashMap<Node,List<Node>> setMap;
    public MySets(List<Node> nodes){
        for(Node cur:nodes){
            List<Node> set = new ArrayList<Node>();
            set.add(cur);
            setMap.put(cur,set);
        }
    }

    // Union-Find Set
	public static class UnionFind {
		// key 某一个节点， value key节点往上的节点
		private HashMap<Node, Node> fatherMap;
		// key 某一个集合的代表节点, value key所在集合的节点个数
		private HashMap<Node, Integer> sizeMap;

		public UnionFind() {
			fatherMap = new HashMap<Node, Node>();
			sizeMap = new HashMap<Node, Integer>();
		}
		
		public void makeSets(Collection<Node> nodes) {
			fatherMap.clear();
			sizeMap.clear();
			for (Node node : nodes) {
				fatherMap.put(node, node);
				sizeMap.put(node, 1);
			}
		}

		private Node findFather(Node n) {
			Stack<Node> path = new Stack<>();
			while(n != fatherMap.get(n)) {
				path.add(n);
				n = fatherMap.get(n);
			}
			while(!path.isEmpty()) {
				fatherMap.put(path.pop(), n);
			}
			return n;
		}

		public boolean isSameSet(Node a, Node b) {
			return findFather(a) == findFather(b);
		}

		public void union(Node a, Node b) {
			if (a == null || b == null) {
				return;
			}
			Node aDai = findFather(a);
			Node bDai = findFather(b);
			if (aDai != bDai) {
				int aSetSize = sizeMap.get(aDai);
				int bSetSize = sizeMap.get(bDai);
				if (aSetSize <= bSetSize) {
					fatherMap.put(aDai, bDai);
					sizeMap.put(bDai, aSetSize + bSetSize);
					sizeMap.remove(aDai);
				} else {
					fatherMap.put(bDai, aDai);
					sizeMap.put(aDai, aSetSize + bSetSize);
					sizeMap.remove(bDai);
				}
			}
		}
	}

    class EdgeComparator implements Comparator<Edge>{
        @Override
        public int compare(Edge edge01, Edge edge02){
            return edge01.weight - edge02.weight;
        }
    }

    public static Set<Edge> KruskalMst(Graph graph){
        UnionFind unionFind = new UnionFind();
        // 所有 nodes.values(); 
        // HashMap
        unionFind.makeSets(graph.nodes.values());
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(new EdgeComparator());
        for(Edge edge:graph.edges){
            priorityQueue.add(edge);
        }
        Set<Edge> result = new HashSet<>();
        while(!priorityQueue.isEmpty()){
            Edge edge = priorityQueue.poll();
            if(!unionFind.isSameSet(edge.from, edge.to)){
                result.add(edge);
                unionFind.union(edge.from,edge.to)
            }
        }

        return result;
    }