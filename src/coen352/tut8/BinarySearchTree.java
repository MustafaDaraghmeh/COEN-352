/*
 *  2020. Mustafa Daraghmeh.
 */

package coen352.tut8;

public class BinarySearchTree {
    public static  DataNode root;
    public BinarySearchTree(){
        this.root = null;
    }

    public boolean find(int id){
        DataNode current = root;
        while(current!=null){
            if(current.data==id){
                return true;
            }else if(current.data>id){
                current = current.left;
            }else{
                current = current.right;
            }
        }
        return false;
    }
    public boolean delete(int id){
        DataNode parent = root;
        DataNode current = root;
        boolean isLeftChild = false;
        while(current.data!=id){
            parent = current;
            if(current.data>id){
                isLeftChild = true;
                current = current.left;
            }else{
                isLeftChild = false;
                current = current.right;
            }
            if(current ==null){
                return false;
            }
        }
        //if i am here that means we have found the DataNode
        //Case 1: if DataNode to be deleted has no children
        if(current.left==null && current.right==null){
            if(current==root){
                root = null;
            }
            if(isLeftChild ==true){
                parent.left = null;
            }else{
                parent.right = null;
            }
        }
        //Case 2 : if DataNode to be deleted has only one child
        else if(current.right==null){
            if(current==root){
                root = current.left;
            }else if(isLeftChild){
                parent.left = current.left;
            }else{
                parent.right = current.left;
            }
        }
        else if(current.left==null){
            if(current==root){
                root = current.right;
            }else if(isLeftChild){
                parent.left = current.right;
            }else{
                parent.right = current.right;
            }
        }else if(current.left!=null && current.right!=null){

            //now we have found the minimum element in the right sub tree
            DataNode successor	 = getSuccessor(current);
            if(current==root){
                root = successor;
            }else if(isLeftChild){
                parent.left = successor;
            }else{
                parent.right = successor;
            }
            successor.left = current.left;
        }
        return true;
    }

    public DataNode getSuccessor(DataNode deleleDataNode){
        DataNode successsor =null;
        DataNode successsorParent =null;
        DataNode current = deleleDataNode.right;
        while(current!=null){
            successsorParent = successsor;
            successsor = current;
            current = current.left;
        }
        //check if successor has the right child, it cannot have left child for sure
        // if it does have the right child, add it to the left of successorParent.
//		successsorParent
        if(successsor!=deleleDataNode.right){
            successsorParent.left = successsor.right;
            successsor.right = deleleDataNode.right;
        }
        return successsor;
    }
    public void insert(int id){
        DataNode newDataNode = new DataNode(id);
        if(root==null){
            root = newDataNode;
            return;
        }
        DataNode current = root;
        DataNode parent = null;
        while(true){
            parent = current;
            if(id<current.data){
                current = current.left;
                if(current==null){
                    parent.left = newDataNode;
                    return;
                }
            }else{
                current = current.right;
                if(current==null){
                    parent.right = newDataNode;
                    return;
                }
            }
        }
    }
    public void display(DataNode root){
        if(root!=null){
            display(root.left);
            System.out.print(" " + root.data);
            display(root.right);
        }
    }
    public static void main(String arg[]){
        BinarySearchTree b = new BinarySearchTree();
        b.insert(3);b.insert(8);
        b.insert(1);b.insert(4);b.insert(6);b.insert(2);b.insert(10);b.insert(9);
        b.insert(20);b.insert(25);b.insert(15);b.insert(16);
        System.out.println("Original Tree : ");
        b.display(b.root);
        System.out.println("");
        System.out.println("Check whether DataNode with value 4 exists : " + b.find(4));
        System.out.println("Delete DataNode with no children (2) : " + b.delete(2));
        b.display(root);
        System.out.println("\n Delete DataNode with one child (4) : " + b.delete(4));
        b.display(root);
        System.out.println("\n Delete DataNode with Two children (10) : " + b.delete(10));
        b.display(root);
    }
}

class DataNode{
    int data;
    DataNode left;
    DataNode right;
    public DataNode(int data){
        this.data = data;
        left = null;
        right = null;
    }
}