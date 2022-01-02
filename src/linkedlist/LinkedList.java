package linkedlist;

import java.util.Scanner;
class LinkedList {
 
    Node head; // head of list
 
    // Linked list Node.
    // Node is a static nested class
    // so main() can access it
    static class Node {
 
        String data;
        Node next;
 
        // Constructor
        Node(String d)
        {
            data = d;
            next = null;
        }
    }
 
    // Method to insert a new node
    public static LinkedList insert(LinkedList list,
                                    String data)
    {
        // Create a new node with given data
        Node new_node = new Node(data);
        new_node.next = null;
 
        // If the Linked List is empty,
        // then make the new node as head
        if (list.head == null) {
            list.head = new_node;
        }
        else {
            // Else traverse till the last node
            // and insert the new_node there
            Node last = list.head;
            while (last.next != null) {
                last = last.next;
            }
 
            // Insert the new_node at last node
            last.next = new_node;
        }
 
        // Return the list by head
        return list;
    }
 
    // Method to print the LinkedList.
    public static void printList(LinkedList list)
    {
        Node currNode = list.head;
 
        System.out.print("LinkedList: ");
 
        // Traverse through the LinkedList
        while (currNode != null) {
            // Print the data at current node
            System.out.print(" | " + currNode.data);
 
            // Go to next node
            currNode = currNode.next;
        }
        System.out.print(" |");
        System.out.println();
    }
 
    // *****DELETION BY KEY*****
 
    // Method to delete a node in the LinkedList by KEY
    public static LinkedList deleteByKey(LinkedList list,
                                         String key)
    {
        // Store head node
        Node currNode = list.head, prev = null;
 
        //
        // CASE 1:
        // If head node itself holds the key to be deleted
 
        if (currNode != null && currNode.data == key) {
            list.head = currNode.next; // Changed head
 
            // Display the message
            System.out.println(key + " found and deleted");
 
            // Return the updated List
            return list;
        }
 
        //
        // CASE 2:
        // If the key is somewhere other than at head
        //
 
        // Search for the key to be deleted,
        // keep track of the previous node
        // as it is needed to change currNode.next
        while (currNode != null && currNode.data != key) {
            // If currNode does not hold key
            // continue to next node
            prev = currNode;
            currNode = currNode.next;
        }
 
        // If the key was present, it should be at currNode
        // Therefore the currNode shall not be null
        if (currNode != null) {
            // Since the key is at currNode
            // Unlink currNode from linked list
            prev.next = currNode.next;
 
            // Display the message
            System.out.println(key + " found and deleted");
        }
 
        //
        // CASE 3: The key is not present
        //
 
        // If key was not present in linked list
        // currNode should be null
        if (currNode == null) {
            // Display the message
            System.out.println(key + " not found");
        }
 
        // return the List
        return list;
    }
    
 // *****SORTING METHOUD*****
    
    public static void sortList(LinkedList list)
    {
 
        // Node current will point to head
        Node current = list.head, index = null;
 
        String temp;
 
        if (list.head == null) {
            return;
        }
        else {
            while (current != null) {
                // Node index will point to node next to
                // current
                index = current.next;
 
                while (index != null) {
                    // If current node's data is greater
                    // than index's node data, swap the data
                    // between them
                    if (!current.equals(index)) {
                        temp = current.data;
                        current.data = index.data;
                        index.data = temp;
                    }
 
                    index = index.next;
                }
                current = current.next;
            }
        }
    }
    
    
    // ***** Search METHOD****
    
    public static void search(LinkedList list, String data) {  
        Node current = list.head;  
        int i = 1;  
        boolean flag = false;  
        //Checks whether list is empty  
        if(list.head == null) {  
            System.out.println("List is empty");  
        }  
        else {  
            while(current != null) {  
                 //Compares node to be found with each node present in the list  
                if(current.data.equals(data)) {  
                    flag = true;  
                    break;  
                }  
                i++;  
                current = current.next;  
            }  
        }  
        if(flag)  
             System.out.println("Element is present in the list at the position : " + i);  
        else  
             System.out.println("Element is not present in the list");  
    }  
 
    // *****MAIN METHOD*****
 
    // method to create a Singly linked list with n nodes
    public static void main(String[] args)
    {
        /* Start with the empty list. */
    	LinkedList list = new LinkedList();
    	menu(list);
        
        

    }
 // *****MENU METHOD*****
    public static void menu(LinkedList list) {
    	System.out.println("===   MENU   ===" + "\n" + "Choices:" + "\n" + "1- Enter Student" + "\n2- Delet Student" + "\n3- Display Student" + "\n4- Sorting Student" + "\n5- Search about Student" + "\n6- Exit");
    	System.out.println("====================\nEnter your Choice : ");
        Scanner scanner = new Scanner(System.in);
        int key = scanner.nextInt();
        switch (key) {
        case 1:
        {
        	System.out.println("Enter the student name to store : ");
        	Scanner s = new Scanner(System.in);
        	String inputString = s.nextLine();
        	list = insert(list, inputString);
        	menu(list);
        } break;
        
        case 2:
        {
        	System.out.println("Enter the student name to delete : ");
        	Scanner s = new Scanner(System.in);
        	String inputString = s.nextLine();
        	deleteByKey(list, inputString);
        	menu(list);
        } break;
        
        case 3:
        {
        	System.out.println("======  The List  ======");
        	printList(list);
        	menu(list);
        }break;
        
        case 4:
        {
        	System.out.println("======  The List Befor Sorting  ======");
        	printList(list);
        	sortList(list);
        	System.out.println("======  The List After Sorting  ======");
        	printList(list);
        	menu(list);
        }break;
        
        case 5:
        {
        	System.out.println("======  Enter Student name to search  ======");
        	Scanner s = new Scanner(System.in);
        	String inputString = s.nextLine();
        	search(list, inputString);
        	menu(list);
        }break;
        
        case 6:
        {
        	System.exit(0);
        }break;
        
        default: 
        	System.out.println("Marwan Adnan");
        	
        }
    }
}