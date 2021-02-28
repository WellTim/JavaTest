import java.io.*;

public class LinkedList {
    Node head; 

    class Node {
        int value;
        Node next;
        Node(int v)
        {
            value = v;
            next = null;
        }
    }

    public LinkedList insert(LinkedList list,int value)
    {
        Node newNode = new Node(value);
        newNode.next = null;

        if (list.head == null) {
            list.head = newNode;
        }
        else {
            Node lastNode = list.head;
            while (lastNode.next != null) {
                lastNode = lastNode.next;
            }
            lastNode.next = newNode;
        }

        return list;
    }

    public LinkedList delete(LinkedList list,int value)
    {
        Node curNode = list.head;
        Node preNode = null;

        //if value is at head
        if (curNode != null && curNode.value == value) {
            list.head = curNode.next; 

            return list;
        }

        //if value is not at head
        while (curNode != null && curNode.value != value) {
            preNode = curNode;
            curNode = curNode.next;
        }

        if (curNode != null) {
            preNode.next = curNode.next;
        }

        return list;
    }

    public void showList(LinkedList list)
    {
        Node showNode = list.head;

        int i = 1; 
        while (showNode != null) {
            System.out.print("Node" + i + ":" + showNode.value + " ");
            System.out.println();

            showNode = showNode.next;
            i = i + 1; 
        }
    }

}
