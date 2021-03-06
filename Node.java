class Node
{
  String element;
  int count;
  Node left, right;
  
  public Node(String element)
  {
    left = (right = null);
    count = 1;
    this.element = element;
  }
    public void setRight(Node node)
            {
              this.right = node;
            }
            
            public Node getRight()
            {
              return this.right;
            }
            
            public void setLeft(Node node)
            {
              this.left = node;
            }
            
            public Node getLeft()
            {
              return this.left;
            }
            
            public void setElem(String element)
            {
              this.element = element;
            }
            
            public String getElem()
            {
              return this.element;
            }
            
            public void setCount(int count)
            {
              this.count = count;
            }
            
            public int getCount()
            {
              return count;
            }
            
            public int incrementCount()
            {
              return ++count;
            }
            
            public int decrementCount()
            {
              return --count;
            }
            
            
}