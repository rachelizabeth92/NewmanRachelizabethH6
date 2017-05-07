import java.util.*;
import java.io.*;

public class BSTMain
{
  public static void main(String[] args) throws FileNotFoundException
  {
    BST tree = new BST();
    File file = new File("file.txt");
    Scanner myScan = new Scanner(file);
    String word;
    
   while(myScan.hasNext())
    {
     word = myScan.next().toLowerCase();
     tree.insert(word);
    }
    myScan.close();
    
    tree.postorderTraversal();
    
    System.out.printf("Search %d\n", tree.search("good"));
 }
}
    
    
    