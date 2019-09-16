package model.data_structures;
import java.lang.*;

public class DLLNode <Item> {
	Item data; 
	  

	DLLNode prev; 
    

	DLLNode next; 

    // Constructor to create a new node 
    // next and prev is by default initialized as null 
    public DLLNode(Item d) { 
    	data = d; 
    } 

    public Item getData() {
    	return data;
    }

  	public void setData(Item data) {
  		this.data = data;
  	}
  	public DLLNode getPrev() {
		return prev;
	}

	public void setPrev(DLLNode prev) {
		this.prev = prev;
	}

	public DLLNode getNext() {
		return next;
	}

	public void setNext(DLLNode next) {
		this.next = next;
	}

}
