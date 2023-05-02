package exceptions;

public class ItemNotFoundException extends Exception{
	public ItemNotFoundException() {
		super("Item does not exist.");
	}
}
