public class BST
{
  Node root;
  
  public BST()
  {
    root = null;
  }
  //check if empty
  public boolean isEmpty()
  {
    if(root == null)
    {
      return true;
    }
    else
    {
      return false;
    }
  }
  //check if full
  public boolean isFull()
  {
    return false;
  }
  //add to tree
  public String insert(String element)
  {
    Node node = new Node(element);
    
    if(isEmpty())
    {
     root = node;
    }
    else
    {
      Node curr = root;
      
     while(curr != null)
     {
       if(element.compareTo(curr.getElem()) > 0)
       {
         if(curr.getRight() == null)
         {
           curr.setRight(node);
           curr = null;
         }
         else
         {
           curr = curr.getRight();
         }
       }
       else if(element.compareTo(curr.getElem()) < 0)
       {
         if(curr.getLeft() == null)
         {
           curr.setLeft(node);
           curr = null;
         }
         else
         {
           curr = curr.getLeft();
         }
       }
       else//they are equal
       {
         curr.incrementCount();
         curr = null;
       }
     }
    }
   return element;
  }
  
  //inorder trav method
  public void inorderTraversal(Node node)
  {
    if(node != null)
    {
     inorderTraversal(node.getLeft());
     System.out.print(node.getElem() + " " + node.getCount() + "\n");
     inorderTraversal(node.getRight());
    }
    return; 
  }
  //get the root/return to root
  public Node getRoot()
  {
    return root;
  }
  //find node
  public String searchTree(String element)
  {
    Node node;
    
    if(node.getElem == element)
    {
      return node;
    }
    else if(element < node.getElem() && node.getLeft())
    {
      return node.getLeft(searchTree(element));
    }
    else if(element > node.getElem() && node.getRight())
    {
      return node.getRight(searchTree(element));
    }
    else
    {
      return null;
    }
  }
  //delete from tree
  public String delete(String element)
  {
    
  }
}
        
      
      
      
      
      
      
      
      
      