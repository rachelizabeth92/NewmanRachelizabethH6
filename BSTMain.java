public class BSTMain
{
  public static void main(String[] args)
  {
    BST tree = new BST();
    
    tree.insert("Rachel");
    tree.insert("Bob");
    tree.insert("Heidi");
    tree.insert("Roger");
    tree.insert("Bob");
    
    tree.inorderTraversal(tree.getRoot());
    
    System.out.printf("Search %d\n", tree.searchTree("Rachel"));
    
    
    System.out.printf("Delete %d\n", tree.deleteNode("Rachel"));
    
    tree.inorderTraversal(tree.getRoot());
 }
}
    
    
    