package algos.tree;

import java.util.*;

public class Tries {
	Node root = null;

	Tries() {
		root = new Node();
	}
	//NOTE: at root pos  =0 and at end of word (e.g: "he"  pos =2 not 1)
	//on recursive call EOW ? then mark it false  and return true if it has no children
	public boolean delete(String str, Node cur, int pos) {
		Node aNode = null;
		if (cur == null) {
			return true;
		}
		if (pos == str.length()) {
			cur.eow = false;
			if (cur.nodes.size() == 0) {
				return true;
			} else {
				return false;
			}
		}
		aNode = cur.nodes.get(str.charAt(pos));
		boolean shouldDelete = delete(str, aNode, pos + 1);
		if (!shouldDelete)//child function: answered del = true
			return false;
		cur.nodes.remove(str.charAt(pos));// remove child node
		if (cur.eow ||  cur.nodes.size() > 0) // should we remove this node now: EOW ? or SIZE?
			return false;
		return true;
	}

	public void insert(String str) {
		Node cur = root, prev = cur;
		;

		for (int i = 0; i < str.length(); i++) {
			prev = cur;
			char ch = str.charAt(i);
			cur = cur.nodes.get(ch);
			if (cur == null) {
				cur = new Node();
				cur.ch = str.charAt(i);
				prev.nodes.put(str.charAt(i), cur);
				prev = cur;
			}
		}

		cur.eow = true;
	}

	public void print(Node cur, String s) {
		if (cur == null)
			return;
		if (cur.eow)
			System.out.println(s + cur.ch);
		for (Character ch : cur.nodes.keySet()) {
			print(cur.nodes.get(ch), s + (cur==root?"":cur.ch));
		}
	}

	// returns the last node if eow = true;
	public Node get(String str) {
		Node cur = root;
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			cur = cur.nodes.get(ch);
			if (cur == null)
				break;
		}
		return cur != null && cur.eow ?cur:null;
	}

	public static void main(String[] args) {
		Tries trie = new Tries();
		trie.insert("h");
		trie.insert("hh");
		
		trie.print(trie.root, "");
		String word = "hh";
		Node node = trie.get(word);
		System.out.println("Node found: "+node);
		System.out.println("==================");
		trie.delete(word, trie.root, 0);
		trie.print(trie.root, "");
		node = trie.get(word);
		System.out.println("Node found: "+node);
//		trie.insert("hello");
//		trie.insert("help");
//		trie.insert("hell");
//		trie.insert("good");
//		trie.insert("god");
//		trie.insert("gone");
//		trie.insert("goner");
//		
	}
}

class Node {
	Character ch=null;
	boolean eow = false;
	Map<Character, Node> nodes = new HashMap<>();
	
}
