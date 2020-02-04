import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/*
 * Given two words (beginWord and endWord), and a dictionary's word list,
 * find all shortest transformation sequence(s) from beginWord to endWord, 
 * such that:
 * 
 * 	Only one letter can be changed at a time
 * 	Each transformed word must exist in the word list. Note that beginWord 
 * is not a transformed word.
 * 
 * 
 * Note:
 * 
 * 	Return an empty list if there is no such transformation sequence.
 * 	All words have the same length. 
 * 	All words contain only lowercase alphabetic characters.
 * 	You may assume no duplicates in the word list.
 * 	You may assume beginWord and endWord are non-empty and are not the same.
 */

public class FindLaddersComplicated {
	private Graph words;
    private int len;
    private String beginWord;
    
    private class Graph {
        public String val;
        // These are for the linked list
        public Graph next;
        public Graph prev;
        
        // These are for the "graph"
        public HashSet<Graph> prev_neighborhood;
        
        public Graph (String val) { 
            this.val = val;
            prev_neighborhood = new HashSet<Graph>();
        }
    }
    
    private boolean isNeighbor(String s1, String s2) {
        int diff = 0;
        for (int i = 0; i < len; i++) {
            if (s1.charAt(i) != s2.charAt(i))
                diff++;
        }
        // System.out.println("diff("+s1 + ", " + s2 + ") = " + diff);
        return (diff == 1);
    }
    
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        /* Base cases */
        if (wordList.isEmpty()) 
            return new ArrayList<List<String>>();
        
        len = beginWord.length();
        
        this.beginWord = beginWord;
        words = new Graph(null);
        Graph lastWord = words;
        boolean found = false;
        
        /* It transforms the wordlist to a linked-list-grapp without the endWord */
        for (String w : wordList) {
            if (w.equals(endWord)) {
                found = true;
            }else if (!w.equals(beginWord)) {
                lastWord.next = new Graph(w);
                lastWord.next.prev = lastWord;
                lastWord = lastWord.next;
            }
        }
        
        // If the list doesn't contain the endWord
        if (!found)
            return new ArrayList<List<String>>();
        
        if (isNeighbor(beginWord, endWord)) {
            List<List<String>> ret = new ArrayList<List<String>>();
            ArrayList<String> sol = new ArrayList<String>(2);
            sol.add(beginWord);
            sol.add(endWord);
            ret.add(sol);
            return ret;
        }
        
        words = words.next;
        if (words != null)
            words.prev = null;
        
        // Initialization of the Graph.
        Graph firstElem = new Graph(endWord);
        HashSet<Graph> leaves = new HashSet<Graph>();
        leaves.add(firstElem);
        
        // Population of the graph, getting the last (beginWord or empty)
        Graph last = makeGraph(leaves);
        if (last == null)
            return new ArrayList<List<String>>();
        
        System.out.println("Get Sequences From Graph");
        return getSequencesFromGraph(new ArrayList<String>(), last);
    }
    
    /* Traverses the graph in reverse order */
    private List<List<String>> getSequencesFromGraph(List<String> acumSeq, Graph actual) {        
        List<List<String>> ret = new ArrayList<List<String>>();
        acumSeq.add(actual.val);
        if (actual.prev_neighborhood.isEmpty()) {
            ret.add(acumSeq);
            return ret;
        }
        
        for(Graph g : actual.prev_neighborhood)
            System.out.print(g.val + ", ");
        System.out.println();
        int branches = actual.prev_neighborhood.size();
        for(Graph g : actual.prev_neighborhood) {
            System.out.println(g.val);
            if(branches-- == 1) {
                ret.addAll(getSequencesFromGraph(acumSeq, g));
            } else {
                List<String> acumSeqCpy = new ArrayList<String>();
                for (int i = 0; i < acumSeq.size(); i++)
                    acumSeqCpy.add(acumSeq.get(i));
                
                ret.addAll(getSequencesFromGraph(acumSeqCpy, g));
            }
        }
        return ret;
    }
    
    /* Generates the graph keeping the leaves on the hand at each step */
    private Graph makeGraph(HashSet<Graph> leaves) {
        HashSet<Graph> newLeaves = new HashSet<Graph>();
        Graph beginW = new Graph(beginWord);
        boolean finish = false;
        Graph w;
        // Add the new neighborhood for each leaf
        for (Graph l : leaves) {
            w = words;
            while (w != null) {
            	if (isNeighbor(l.val, w.val)){
                    newLeaves.add(w);
                    w.prev_neighborhood.add(l);
                    
                    if (isNeighbor(w.val, beginWord)) {
                        finish = true;
                        beginW.prev_neighborhood.add(w);
                    }
                }
                w = w.next;
            }
        }
        
        // If the neighborhood is an empty set,
        // return empty set.
        if (newLeaves.isEmpty())
            return null;
        
        // If I reach the beginWord, 
        // return it
        if (finish)
            return beginW;
        
        // Remove each new leaf from the original list
        for (Graph l : newLeaves) {            
            if (l.prev != null)
                l.prev.next = l.next;
            else
                words = l.next;
            
            if (l.next != null)
                l.next.prev = l.prev;
        }
        
        // Do the recursive step.
        return makeGraph(newLeaves);
    }
}