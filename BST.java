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
  public int searchTree(String element)
  {
    if(!isEmpty())
    {
      Node curr = root;
      
     while(curr != null)
     {
       if(element.compareTo(curr.getElem()) > 0)
       {
         if(curr.getRight() == null)
         {
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
           curr = null;
         }
         else
         {
           curr = curr.getLeft();
         }
       }
       else//they are equal
       {
         return curr.getCount();
       }
     }
    }
   return 0;
  }
  
  public Node findMax(Node node)
  {
    if(node != null)
    {
      while(node.getRight() != null)
      {
        node = node.getRight();
      }
    }
    return node;
  }
  
  public Node findMin(Node node)
  {
    if(node != null)
    {
      while(node.getLeft() != null)
      {
        node = node.getLeft();
      }
    }
    return node;
  }
  
  //delete from tree
  public int deleteNode(String element)
  {
    Node curr;//node to delete
    Node pred;//parent of node to delete
    int count = 0;//element count of node to delete
    
    if(!isEmpty())
    {
      pred = null;
      curr = root;
      
      while(curr != null)//find node to delete
       {
       if(element.compareTo(curr.getElem()) > 0)
       {
         if(curr.getRight() == null)
         {
           pred = null;
           curr = null;
         }
         else
         {
           pred = curr;
           curr = curr.getRight();
         }
       }
       else if(element.compareTo(curr.getElem()) < 0)
       {
         if(curr.getLeft() == null)
         {
           pred = null;
           curr = null;
         }
         else
         {
           pred = curr;
           curr = curr.getLeft();
         }
       }
       else//they are equal
       {
         break;//node found, fall out of loop
       }
     }
      
     if(curr != null)
      {
       //no children
       if(curr.getLeft() == null && curr.getRight() == null)
       {
         count = curr.getCount();
         if(pred == null)
         {
           root = null;//trivial case, one node on tree
         }
         else// general case, leaf node
         {
         if(pred.getLeft() == curr)
         {
           pred.setLeft(null);
         }
         else
         {
           pred.setRight(null);
         }
         }
 
       }
       else if(curr.getLeft() != null && curr.getRight() != null)
       {
         Node node = findMax(curr.getLeft());
         
         count = curr.getCount();
         element = node.getElem();
         System.out.print(element);
         curr.setElem(element);
         root = curr;
         
       }
       else if(curr.getLeft() != null)
       {
         if( pred == null)
         {
           root = curr.getLeft();
         }
         else
         {
         pred.setRight(curr.getLeft());
         }
         count = curr.getCount();
       }
       else
       {
         if(pred == null)
         {
           root = curr.getRight();
         }
         else
         {
           System.out.printf("Pred = %s,   curr = %s\n", pred.getElem(), curr.getElem());
         pred.setLeft(curr.getRight());
         System.out.printf("pred left = %s  right = %s\n", pred.getLeft().getElem(), pred.getRight().getElem());
         }
         count = curr.getCount();
       }
       curr.setLeft(null);
       curr.setRight(null);
       curr = null;
    } 
  }
    return count;
}
}
        
      
      
      
      
      
      
      
      
      