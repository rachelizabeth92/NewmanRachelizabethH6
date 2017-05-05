public class BST
{
  Node root;
  
  public BST()
  {
    root = null;
  }
  
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
  
  public boolean isFull()
  {
    return false;
  }
  
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
  
  public Node getRoot()
  {
    return root;
  }
}
        
      
      
      
      
      
      
      
      
      