package model.data_structures;


public class Node<Item> 
{
	private Item item;
	

	private Node next;
	
	public Node(Item pItem)
	{
		item = pItem;
		next = null;
	}
	
	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}
	
}
