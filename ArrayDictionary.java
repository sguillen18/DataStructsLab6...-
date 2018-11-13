import java.util.Arrays;

public class ArrayDictionary <K,V> implements DictionaryInterface <K,V> {

	private Entry<K,V>[] entries;
	private int numberOfEntries;
	private boolean initalizaed = false;
	@SuppressWarnings("unchecked")
	private static final int DEFAULT_CAPACITY = 50;
	
	public ArrayDictionary(int capacity) {
		entries=(Entry <K,V>[]) new Object [capacity];
		numberOfEntries = 0;
		initalizaed = true;
	}
	
	public ArrayDictionary() {
		this(DEFAULT_CAPACITY);
	}
	
	private void ensureCapacity() {
		if(numberOfEntries == entries.length) {
			entries = (Entry<K,V>[])Arrays.copyOf(entries, 2*numberOfEntries);
		}
	}
	
	private int locateIndex(K aKey) {
		int index=0;
		while(index < numberOfEntries && !aKey.equals(entries[index])) {
			index++;
		}
		return index;
	}
	
	public V add(K newKey, V newValue) {
		int index = locateIndex(newKey);
		if(index==numberOfEntries) {
			Entry<K,V> e = new Entry(newKey, newValue);
			entries[numberOfEntries] = e;
			ensureCapacity();
			return null;
		}
		V oldValue = entries[index].getValue();
		entries[index].setValue(newValue);
		return oldValue;
	}
	
	public V remove(K aKey) {
		int index=locateIndex(aKey);
		if(index==numberOfEntries) {
			return null;
		}
		V oldValue = entries[index].getValue();
		entries[index]=entries[numberOfEntries-1];
		entries[numberOfEntries-1]=null;
		numberOfEntries--;
		return oldValue;
		
	}
	
	public V getValue(K key) {
		int index=locateIndex(key);
		if(index==numberOfEntries) {
			return null;
		}
		return entries[index].getValue();
	}
	
	
	private class KeyIterator<K> implements Iterator<K>{
		
		private int nextIndex;
		
		public KeyIterator() {
			 nextIndex=0;
		}
		
		public boolean hasNext() {
			return(nextIndex<numberOfEntries);
		}
		
		public K next() {
			if(!hasNext()) {
				throw new IllegalStateException(" ");
			}
			K result = list[nextIndex].getKey();
			nextIndex++;
			return result;
		}
		
		public void remove(){
			throw new UnsupportedOperationException();
		}
		
		public Iterator<K> getKeyIterator(){
			return new KeyIterator();
		}
	}
	
	private class ValueIterator<V> implements Iterator<V>{
		//same as above just replace key and K with value and V
	}
	
	/*create private Iterator<K>
		KeyIterator{
			private int nextIndex;
			private KeyItetrator(){
				nextIndex=0;
			}
			public boolean hasNext(){
				return (nextIndex < numberOfEntires);
			}
			public K next(){
				K result = entries[nextIndex].getKey();
				nextIndex++
				return result;
			}
			public void remove(){
				throw new UnsupportedOperationException();
			}
		}
		
	
	*/
}

