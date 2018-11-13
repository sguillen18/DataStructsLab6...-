
public class SortedLinkedDictionary <K extends Comparable<? super K>, V> implements DictionaryInterface <K,V>{

	private DictNode head;
	private DictNode tail;
	private int numberOfEntries;
	
	public SortedLinkedDictionary() {
		head = null;
		tail = null;
		numberOfEntries=0;
	}
	
	private class DictNode{
		private K key;
		private V value;
		private DictNode next;
		private DictNode prev;
		
		public DictNode(K key, V value) {
			this.key = key;
			this.value = value;
			next = null;
			prev = null;
		}
		
		private DictNode getNodeAfterKey(K aKey) {
			DictNode curr = head;
			while (curr != null & (aKey.compareTo(curr.getKey()) > 0)) {
				curr = curr.getNext();
				return curr;
			}
		}

		public V add(K newKey, V newValue) {
			
			DictNode toAdd = new DictNode(newKey, newValue);
			DictNode nodeAfter = getNodeAfterKey(newKey);
			if(isEmpty()) {
				head=toAdd;
				tail=toAdd;
			}
			//define setNext and setPrev in node class
			else if(nodeAfter == null) {
				tail.setNext(toAdd);
				toAdd.setPrev(tail);
				tail = toAdd;
			}
			else if(newKey.equals(nodeAfter.getKey())){
				V oldValue = nodeAfter.getValue();
				nodeAfter.setValue(newValue);
				return oldValue;
			}
			else if (nodeAfter == head) {
				toAdd.setNext(head);
				head.setPrev(toAdd);
				head = toAdd;
			}
			else {
				DictNode previous = nodeAfter.getPrev();
				previous.setNext(toAdd);
				toAdd.setNext(nodeAfter);
				nodeAfter.setPrev(toAdd);
				toAdd.setPrev(previous);
			}
		}
	}
	
	
}
