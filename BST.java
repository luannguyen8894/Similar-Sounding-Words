

/**
 *  This class implements a BST.
 *  
 *  @param <T> the type of the key.
 *
 *  @author W. Masri and Luan Nguyen
 */
class BST<T extends Comparable<T>> 
{
	// **************//
	// DO NO CHANGE
	
	/**
	 *  Node class.
	 *  @param <T> the type of the key.
	 */
	class Node<T extends Comparable<T>> 
	{
		/**
		*  key that uniquely identifies the node.
		*/
		T key;
		/**
		*  references to the left and right nodes.
		*/
		Node<T> left, right;
		/**
		 *  Constructor for node class.
		 *  @param item will be assigned.
		 */
		public Node(T item) 
		{
			key = item; 
			left = right = null; 
		}
		/**
		 *  method returns the key in string type.
		 *  @return the key.
		 */
		public String toString() 
		{
			return "" + key; 
		}
	}
	
	/**
	 *  The root of the BST.
	 */
	Node<T> root;
	/**
	 *  Constructor for BST class.
	 */
	public BST() 
	{
		root = null; 
	}
	/**
	 *  method returns the value in BST in string type.
	 *  @return the inorderToString().
	 */
	public String toString() 
	{
		return inorderToString(); 
	}
	// DO NO CHANGE
	// **************//
	
	

	
	
	/**
	 *  This method returns a string in which the elements are listed in an inorder fashion. 
	 *  Your implementation must be recursive.
	 *  Note: you can create private helper methods
	 *  @return string in which the elements are listed in an inorder fashion
	 */
	public String inorderToString() 
	{
		if(root == null)
		{
			return "";
		}
		else
		{
			String str = toStringInorder(root);
			return (str.substring(0, str.length() - 1));
		}
		
	}
	/**
	 *  Recursively adding each node to a string in Inorder.
	 *  @param root of the BST
	 *  @return the string to toString() method.
	 */
	public String toStringInorder(Node<T> root) 
	{
	    String str = "";
	    if (root == null) 
	    {
	        return "";
	    }
	    str += toStringInorder(root.left);
	    str += "\""+root.toString()+"\" ";
	    str += toStringInorder(root.right);
	    //
	    return str;
	}

	
	
	
	
	/**
	 *  This method inserts a node in the BST. You can implement it iteratively or recursively.
	 *  Note: you can create private helper methods
	 *  @param value of the new node
	 *  @param node root
	 *  @return the node associated with the key.
	 */
	
	private Node<T>  insertNode(Node<T> node, T value)
	{
		if(value.compareTo(node.key) < 0)
		{
			if(node.left == null)
			{
				node.left = new Node<T>(value);
			}
			else
			{
				node.left = insertNode(node.left, value);
			}
		}
		else if(value.compareTo(node.key) >= 0)
		{
			if(node.right == null)
			{
				node.right = new Node<T>(value);
			}
			else
			{
				node.right =  insertNode(node.right, value);
			}
		}
		return node;
	}
	/**
	 *  This method inserts a node in the BST.
	 *  @param key is the new data
	 */
	public void insert(T key) 
	{
		if(root == null)
			root = new Node<T>(key);
		else
			root = insertNode(root, key);
		// YOUR CODE GOES HERE 
	}
	
	
	
	
	/**
	 *  This method finds and returns a node in the BST. You can implement it iteratively or recursively.
	 *  It should return null if not match is found.
	 *  Note: you can create private helper methods
	 *  @param key to find
	 *  @return the findNode method.
	 */
	public Node<T> find(T key)	
	{ 					
		return findNode(root, key);
		
	}	 
	/**
	 *  This method finds and returns a node in the BST. You can implement it iteratively or recursively.
	 *  It should return null if not match is found.
	 *  Note: you can create private helper methods
	 *  @param node associated with the key
	 *  @param key to find
	 *  @return either null, the result node or the function itself.
	 */
	public Node<T> findNode(Node<T> node, T key)
	{
		if(node == null)
		{
			return null;
		}
		else if(node.key.compareTo(key) == 0)
		{
			return node;
		}
		
		if(key.compareTo(node.key) < 0)
		{
			return findNode(node.left, key);
		}
		
		return findNode(node.right, key);
	}
	
	

	/**
	 *  Main Method For Your Testing -- Edit all you want.
	 *  
	 *  @param args not used
	 */
	public static void main(String[] args) {
		/*
							 50
						  /	      \
						30    	  70
	                 /     \    /     \
	                20     40  60     80   
		*/
		
		
		BST<Integer> tree1 = new BST<>();
		tree1.insert(50); 
		tree1.insert(30); 
		tree1.insert(20); 
		tree1.insert(40);
		tree1.insert(70); 
		tree1.insert(60); 
		tree1.insert(80);
		if (tree1.find(50) != null) {
			System.out.println("Yay1");
		}
		if (tree1.find(90) == null) {
			System.out.println("Yay2");
		}
		if (tree1.toString().equals("\"20\" \"30\" \"40\" \"50\" \"60\" \"70\" \"80\"") == true) {
			System.out.println("Yay3");
		}
		BST<String> tree2 = new BST<>();
		tree2.insert("50"); tree2.insert("30"); tree2.insert("20"); tree2.insert("40");
		tree2.insert("70"); tree2.insert("60"); tree2.insert("80");
		
		if (tree2.find("70") != null) {
			System.out.println("Yay4");
		}
		if (tree2.find("90") == null) {
			System.out.println("Yay5");
		}
		if (tree2.toString().equals("\"20\" \"30\" \"40\" \"50\" \"60\" \"70\" \"80\"") == true) {
			System.out.println("Yay6");
		}
	}
	
}
