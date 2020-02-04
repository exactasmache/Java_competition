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

public class FindLadders {
	private int nWords;
	private int len;
	
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        nWords = wordList.size();
        len = beginWord.length();
        
        List<List<Integer>> ret_idx = getSequences(new ArrayList<Integer>(), wordList, 0);
        List<List<String>> ret = new ArrayList<List<String>>();
        // TODO:
        for (List<Integer> id_seq : ret_idx) {
        	List<String> seq = new ArrayList<String>();
        	for(int id : id_seq)
        		seq.add(wordList.get(id));
        	ret.add(seq);
        }
        return ret;
    }
    
    private boolean isNeighbor(String s1, String s2) {
        int diff = 0;
        for (int i = 0; i < len; i++) {
            if (s1.charAt(i) != s2.charAt(i))
                diff++;
        }
        return (diff == 1);
    }
    
    private List<List<Integer>> getSequences(List<Integer> acumSeq, List<String> wordList, int index) {        
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        acumSeq.add(index);
        
        if (index == nWords-1) {
            ret.add(acumSeq);
            return ret;
        }
        
//        List<Integer> nbhood = new ArrayList<Integer>();
        
//        for (int i = index+1; i < nWords; i++)
//            if ()
//        	// TODO
//            	
//            	
//        int branches = nbhood.size();
//        for(Graph g : actual.prev_neighborhood) {
//            System.out.println(g.val);
//            if(branches-- == 1) {
//                ret.addAll(getSequencesFromGraph(acumSeq, g));
//            } else {
//                List<String> acumSeqCpy = new ArrayList<String>();
//                for (int i = 0; i < acumSeq.size(); i++)
//                    acumSeqCpy.add(acumSeq.get(i));
//                
//                ret.addAll(getSequencesFromGraph(acumSeqCpy, g));
//            }
//        }
        return ret;
    }
}