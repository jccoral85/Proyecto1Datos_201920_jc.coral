package model.data_structures;

public class DLL <Item extends Comparable<Item>> implements IDLL<Item>{
	 	DLLNode head; // head of list 
	    
	    public DLLNode getHead() 
	    {
			return head;
		}

		private int size =0;
	  
	   
	  
	    // Adding a node at the front of the list 
	    public void push(Item new_data) 
	    { 
	        /* 1. allocate node  
	        * 2. put in the data */
	        DLLNode new_Node = new DLLNode(new_data); 
	  
	        /* 3. Make next of new node as head and previous as NULL */
	        new_Node.next = head; 
	        new_Node.prev = null; 
	  
	        /* 4. change prev of head node to new node */
	        if (head != null) 
	            head.prev = new_Node; 
	  
	        /* 5. move the head to point to the new node */
	        head = new_Node; 
	        size ++;
	    } 
	    
	    public int getSize()
	    {
	    	return size;
	    }
	  
	    /* Given a node as prev_node, insert a new node after the given node */
	    public void InsertAfter(DLLNode prev_Node, Item new_data) 
	    { 
	  
	        /*1. check if the given prev_node is NULL */
	        if (prev_Node == null) { 
	            System.out.println("The given previous node cannot be NULL "); 
	            return; 
	        } 
	  
	        /* 2. allocate node  
	        * 3. put in the data */
	        DLLNode new_node = new DLLNode(new_data); 
	  
	        /* 4. Make next of new node as next of prev_node */
	        new_node.setNext(prev_Node.getNext()); 
	  
	        /* 5. Make the next of prev_node as new_node */
	        prev_Node.setNext(new_node); 
	  
	        /* 6. Make prev_node as previous of new_node */
	        new_node.prev = prev_Node; 
	  
	        /* 7. Change previous of new_node's next node */
	        if (new_node.next != null) 
	            new_node.next.prev = new_node; 
	        
	        size ++;
	    } 
	  
	    // Add a node at the end of the list 
	    public void append(Item new_data) 
	    { 
	        /* 1. allocate node  
	        * 2. put in the data */
	        DLLNode new_node = new DLLNode(new_data); 
	  
	        DLLNode last = head; /* used in step 5*/
	  
	        /* 3. This new node is going to be the last node, so 
	        * make next of it as NULL*/
	        new_node.next = null; 
	  
	        /* 4. If the Linked List is empty, then make the new 
	        * node as head */
	        if (head == null) { 
	            new_node.prev = null; 
	            head = new_node; 
	            return; 
	        } 
	  
	        /* 5. Else traverse till the last node */
	        while (last.next != null) 
	            last = last.next; 
	  
	        /* 6. Change the next of last node */
	        last.next = new_node; 
	  
	        /* 7. Make last node as previous of new node */
	        new_node.prev = last; 
	        
	        size ++;
	    } 
	  
	    // This function prints contents of linked list starting from the given node 
	    public void printlist(DLLNode node) 
	    { 
	    	DLLNode last = null; 
	        System.out.println("Traversal in forward Direction"); 
	        while (node != null) { 
	            System.out.print(node.data + " "); 
	            last = node; 
	            node = node.next; 
	        } 
	        System.out.println(); 
	        System.out.println("Traversal in reverse direction"); 
	        while (last != null) { 
	            System.out.print(last.data + " "); 
	            last = last.prev; 
	        } 
	    } 
	    
	    public void deleteNode(DLLNode head_ref, DLLNode del) 
	    { 
	  
	        // Base case 
	        if (head == null || del == null) { 
	            return; 
	        } 
	  
	        // If node to be deleted is head node 
	        if (head == del) { 
	            head = del.next; 
	        } 
	  
	        // Change next only if node to be deleted 
	        // is NOT the last node
	        if (del.next != null) { 
	            del.next.prev = del.prev; 
	        } 
	  
	        // Change prev only if node to be deleted 
	        // is NOT the first node 
	        if (del.prev != null) { 
	            del.prev.next = del.next; 
	        } 
	        size --;
	  
	        // Finally, free the memory occupied by del 
	        return; 
	    } 
	  
	    /* Drier program to test above functions*/
	    public static void main(String[] args) 
	    { 
	        /* Start with the empty list */
	        DLL dll = new DLL(); 
	  
	        // Insert 6. So linked list becomes 6->NULL 
	        dll.append(6); 
	  
	        // Insert 7 at the beginning. So linked list becomes 7->6->NULL 
	        dll.push(7); 
	  
	        // Insert 1 at the beginning. So linked list becomes 1->7->6->NULL 
	        dll.push(1); 
	  
	        // Insert 4 at the end. So linked list becomes 1->7->6->4->NULL 
	        dll.append(4); 
	  
	        // Insert 8, after 7. So linked list becomes 1->7->8->6->4->NULL 
	        dll.InsertAfter(dll.head.next, 8); 
	  
	        System.out.println("Created DLL is: "); 
	        dll.printlist(dll.head); 
	    } 

}
