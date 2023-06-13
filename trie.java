package tree;

import java.util.HashMap;
import java.util.Map;

import org.w3c.dom.Node;

/**
 * trie
 */
public class trie {

    static class trienode{

        Map<Character,trienode> childern=new HashMap<>();
        boolean wordend;
    }

    trienode root=new trienode();

    public trie(String str){
populateSuffix(str);
    }


    public void populateSuffix(String str){
        for (int i = 0; i < str.length(); i++) {
            subString(str, i);
        }
    }

    public void subString(String str,int index){

        trienode node=root;
        for (int i = index; i < str.length(); i++) {
            char letter=str.charAt(i);
            if (!node.childern.containsKey(letter)) {
                trienode newNode=new trienode();
                node.childern.put(letter, newNode);
            }
            node=node.childern.get(letter);
            
        }
        node.wordend=true;
    }

    public boolean contains(String str){

        trienode node= root;
        for (int i = 0; i < str.length(); i++) {
            char letter=str.charAt(i);
            if (!node.childern.containsKey(letter)) {
                return false;
            }
            node =node.childern.get(letter);
        }

        return node.wordend;
    }
    public static void main(String[] args) {
        

        trie Trie=new trie("manna");
        System.out.println(Trie.contains("annam"));
    }
}