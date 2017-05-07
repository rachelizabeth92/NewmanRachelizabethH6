public class BST
{
    Node        root;

    public BST()
    {
        root = null;
    }

    public boolean isEmpty()
    {
        return ( root == null ? true : false );
    }

    public boolean isFull()
    {
        return false;
    }

    public String insert ( String element )
    {
        Node node = new Node (element);

        if ( isEmpty() )
        {
            root = node;
        }
        else
        {
            Node curr = root;

            while ( curr != null )
            {
                if ( element.compareTo (curr.getElem()) > 0 )
                {
                    if ( curr.getRight() == null )
                    {
                        curr.setRight (node);
                        curr = null;
                    }
                    else
                    {
                        curr = curr.getRight();
                    }
                }
                else if ( element.compareTo (curr.getElem()) < 0 )
                {
                    if ( curr.getLeft() == null )
                    {
                        curr.setLeft (node);
                        curr = null;
                    }
                    else
                    {
                        curr = curr.getLeft();
                    }
                }
                else
                {
                    curr.incrementCount();
                    curr = null;
                }
            }  // end while
        }
        return element;
    }


    public int search ( String element )
    {
/*
 *       if(curr.getRight() == null)
 *       {
 *         curr = null;
 *       }
 *       else
 *       {
 *         curr = curr.getRight();
 *       }
 *
 * IS EQUIVALENT TO SIMPLY
 * 
 *       curr = curr.getRight();
 */
        Node    curr = null;
        int     count = -1;


        if ( (curr = this.root) != null )
        {
            count = 0;    // not found

            do {
                if ( element.compareTo (curr.getElem()) > 0 )
                {
                    curr = curr.getRight();
                }
                else if ( element.compareTo (curr.getElem()) < 0 )
                {
                    curr = curr.getLeft();
                }
                else    //  found element
                {
                    count = curr.getCount();
                    curr = null;
                }
            } while ( curr != null );
        }
    //  else empty tree; error -1

        return count;
    }


    public int delete ( String element )
    {
        Node    curr = null;
        Node    pred = null;
        int     count = -1;

        if ( (pred = (curr = this.root)) != null )
        {
            count++;

            do {
                if ( element.compareTo (curr.getElem()) > 0 )
                {
                    pred = curr;
                    curr = curr.getRight();
                }
                else if ( element.compareTo (curr.getElem()) < 0 )
                {
                    pred = curr;
                    curr = curr.getLeft();
                }
                else    // element found
                {
                    count = curr.getCount();

                    if ( curr.getLeft() == null && curr.getRight() == null )
                    {   // leaf node; no children
                        if ( pred == curr )
                        {   // only node in tree
                            this.root = null;
                        }
                        else if ( pred.getLeft() == curr )
                        {   // only node in parent's left subtree
                            pred.setLeft (null);
                        }
                        else    // pred.getRight() == curr
                        {   // only node in parent's right subtree
                            pred.setRight (null);
                        }
                    }
                    else if ( curr.getLeft() != null && curr.getRight() != null )
                    {   // two subtrees; bugger
                        Node    node = null;    // max node in left subtree

                        pred = curr;            // no need for pred of curr
                        node = curr.getLeft();  // so reuse as replacement pred

                        // search for replacement node which is the
                        // max node less than current node
                        while ( node.getRight() != null )
                        {
                            pred = node;
                            node = node.getRight();
                        }
                        // replace current elem and count with node's values
                        curr.setCount(node.getCount());
                        curr.setElem (node.getElem());

                        if ( pred == curr )
                        {    // replacement is left child of current
                            curr.setLeft (node.getLeft());
                        }
                        else
                        {   // replacement is right grandchild of current
                            pred.setRight (node.getLeft());
                        }
                        curr = node;    // actual node to delete
                    }
                    else if ( curr.getLeft() != null )
                    {   // one subtree on the left
                        if ( pred == curr )
                        {   // current is root
                            this.root = curr.getLeft();
                        }
                        else
                        {   // current's parent linked to current's child
                            pred.setLeft (curr.getLeft());
                        }
                    }
                    else    // curr.getRight() != null
                    {   // one subtree on the right
                        if ( pred == curr )
                        {   // current is root
                            this.root = curr.getRight();
                        }
                        else
                        {   // current's parent linked to current's child
                            pred.setRight (curr.getRight());
                        }
                    }
                    // delete node
                    curr.setLeft (null);
                    curr.setRight (null);
                    curr = null;
                }
            } while ( curr != null );
        }
    //  else empty tree; error -1

        return count;
    }

    public Node getRoot ( )
    {
        return this.root;
    }

    public void inorderTraversal ( Node node , int depth )
    {
        if ( node != null )
        {
            inorderTraversal (node.getLeft(), depth + 1);
            System.out.print (depth + " " + node.getElem() + " " + node.getCount() + "\n");
            inorderTraversal (node.getRight(), depth + 1);
        }
        return;
    }

    public void preorderTraversal ( Node node , int depth )
    {
        if ( node != null )
        {
            System.out.print (depth + " " + node.getElem() + " " + node.getCount() + "\n");
            inorderTraversal (node.getLeft(), depth + 1);
            inorderTraversal (node.getRight(), depth + 1);
        }
        return;
    }

    public void postorderTraversal ( Node node , int depth )
    {
        if ( node != null )
        {
            inorderTraversal (node.getLeft(), depth + 1);
            inorderTraversal (node.getRight(), depth + 1);
            System.out.print (depth + " " + node.getElem() + " " + node.getCount() + "\n");
        }
        return;
    }

}
