/**
 * DefaultBinaryTreeNode.java
 * CS 201
 * Jessica Feng
 */

/**
 * BinaryTree is the implementation for a BinaryTreeNode.
 */
public class DefaultBinaryTreeNode<T> implements BinaryTreeNode<T>
{
	/**
	 * instant fields, data and left/right child node.
	 */
	private T data;
	private DefaultBinaryTreeNode<T> leftC;
	private DefaultBinaryTreeNode<T> rightC;
	
	/**
	 * constructor does not do anything
	 */
	public DefaultBinaryTreeNode()
	{
		
	}
	
	/**
	   * Get the data stored at this node.
	   * @return Object data.
	   */
	  public T getData()
	  {
		  return data;
	  }

	  /**
	   * Set the data stored at this node.
	   */
	  public void setData(T data)
	  {
		  this.data = data;
	  }

	  /**
	   * Get the left child.
	   * @return BinaryTreeNode that is left child,
	   * or null if no child.
	   */
	  public DefaultBinaryTreeNode<T> getLeftChild()
	  {
		  return leftC;
	  }

	  /**
	   * Get the right child.
	   * @return BinaryTreeNode that is right child,
	   * or null if no child.
	   */
	  public DefaultBinaryTreeNode<T> getRightChild()
	  {
		  return rightC;
	  }

	  /**
	   * Set the left child.
	   */
	  public void setLeftChild( BinaryTreeNode<T> left )
	  {
		  this.leftC = (DefaultBinaryTreeNode<T>) left;
	  }

	  /**
	   * Set the right child.
	   */
	  public void setRightChild( BinaryTreeNode<T> right )
	  {
		  this.rightC = (DefaultBinaryTreeNode<T>) right;
	  }

	  /**
	   * Tests if this node is a leaf (has no children).
	   * @return true if leaf node.
	   */
	  public boolean isLeaf()
	  {
		  // if it does not have any children, then it is a leaf
		  if(this.getLeftChild() == null && this.getRightChild() == null)
			  return true;
		  
		  return false;
	  }
		

}
