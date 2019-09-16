package model.data_structures;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListIterator<Item> implements Iterator<Item>{

	private Node current = null;
	public ListIterator(Node pCurrent)
	{
		current = pCurrent;
	}
	
	public boolean hasNext()  
	{
		return current != null;                     
	}
	public void remove()     
	{
		throw new UnsupportedOperationException();  
	}

	public Item next() 
	{
		if (!hasNext()) throw new NoSuchElementException();
		Item item = (Item) current.getItem();
		current = current.getNext(); 
		return item;
	}

}
