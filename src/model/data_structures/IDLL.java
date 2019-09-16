package model.data_structures;

public interface IDLL <Item>{
public void push(Item new_data);
	
	public int getSize();
	
	public void InsertAfter(DLLNode prev_Node, Item new_data);
	 
	void append(Item new_data);
	
	void deleteNode(DLLNode head_ref, DLLNode del);
	
}
