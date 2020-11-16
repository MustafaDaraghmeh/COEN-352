/*
 *  2020. Mustafa Daraghmeh.
 */

package coen352.tut9;

// Java program to implement insert operation 
// in Red Black Tree. 

class node
{
    node left, right;
    int data;

    // red ==> true, black ==> false 
    boolean color;

    node(int data)
    {
        this.data = data;
        left = null;
        right = null;

        // New Node which is created is 
        // always red in color. 
        color = true;
    }
}

class LLRBT_Insert {

    private static node root = null;

    // utility function to rotate node anticlockwise. 
    node rotateLeft(node myNode)
    {
        System.out.print("left rotation!!\n");
        node child = myNode.right;
        node childLeft = child.left;

        child.left = myNode;
        myNode.right = childLeft;

        return child;
    }

    // utility function to rotate node clockwise. 
    node rotateRight(node myNode)
    {
        System.out.print("right rotation\n");
        node child = myNode.left;
        node childRight = child.right;

        child.right = myNode;
        myNode.left = childRight;

        return child;
    }

    // utility function to check whether 
    // node is red in color or not. 
    boolean isRed(node myNode)
    {
        if (myNode == null)
            return false;
        return (myNode.color == true);
    }

    // utility function to swap color of two 
    // nodes. 
    void swapColors(node node1, node node2)
    {
        boolean temp = node1.color;
        node1.color = node2.color;
        node2.color = temp;
    }

    // insertion into Left Leaning Red Black Tree. 
    node insert(node myNode, int data)
    {
        // Normal insertion code for any Binary 
        // Search tree. 
        if (myNode == null)
            return new node(data);

        if (data < myNode.data)
            myNode.left = insert(myNode.left, data);

        else if (data > myNode.data)
            myNode.right = insert(myNode.right, data);

        else
            return myNode;


        // case 1. 
        // when right child is Red but left child is 
        // Black or doesn't exist. 
        if (isRed(myNode.right) && !isRed(myNode.left))
        {
            // left rotate the node to make it into 
            // valid structure. 
            myNode = rotateLeft(myNode);

            // swap the colors as the child node 
            // should always be red 
            swapColors(myNode, myNode.left);

        }

        // case 2 
        // when left child as well as left grand child in Red 
        if (isRed(myNode.left) && isRed(myNode.left.left))
        {
            // right rotate the current node to make 
            // it into a valid structure. 
            myNode = rotateRight(myNode);
            swapColors(myNode, myNode.right);
        }


        // case 3 
        // when both left and right child are Red in color. 
        if (isRed(myNode.left) && isRed(myNode.right))
        {
            // invert the color of node as well 
            // it's left and right child. 
            myNode.color = !myNode.color;

            // change the color to black. 
            myNode.left.color = false;
            myNode.right.color = false;
        }

        return myNode;
    }


    // Inorder traversal 
    void inorder(node node)
    {
        if (node != null)
        {
            inorder(node.left);
            System.out.print(node.data + " ");
            inorder(node.right);
        }
    }

    public static void main(String[] args) { 
	/* LLRB tree made after all insertions are made. 
			
	1. Nodes which have double INCOMING edge means 
		that they are RED in color. 
	2. Nodes which have single INCOMING edge means 
		that they are BLACK in color. 
	
		root 
		| 
		40 
		// \ 
	20 50 
	/ \ 
	10 30 
		// 
		25 */

        LLRBT_Insert node = new LLRBT_Insert();

        root = node.insert(root, 10);
        // to make sure that root remains 
        // black is color 
        root.color = false;

        root = node.insert(root, 20);
        root.color = false;

        root = node.insert(root, 30);
        root.color = false;

        root = node.insert(root, 40);
        root.color = false;

        root = node.insert(root, 50);
        root.color = false;

        root = node.insert(root, 25);
        root.color = false;

        // display the tree through inorder traversal. 
        node.inorder(root);

    }

}
