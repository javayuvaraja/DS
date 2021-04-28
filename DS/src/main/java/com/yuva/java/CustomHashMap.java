package com.yuva.java;

public class CustomHashMap <K,V> {
	private CustomEntry<K, V>[] table; 
	private int capacity = 16;
	
    public CustomHashMap(){
        table = new CustomEntry[capacity];
    }

    public CustomHashMap(int capacity){
        this.capacity = capacity;
        table = new CustomEntry[capacity];
    }
    
    public void put(K key, V value){
        int index = index(key);
        CustomEntry<K,V> newEntry = new CustomEntry<K,V>(key, value, null);
        if(table[index] == null){
            table[index] = newEntry;
        }else {
        	CustomEntry<K, V> previousNode = null;
        	CustomEntry<K, V> currentNode = table[index];
            // Checking whether already key exists
        	while(currentNode != null){
                if(currentNode.getKey().equals(key)){
                    currentNode.setValue(value);
                    break;
                }
                previousNode = currentNode;
                currentNode = currentNode.getNext();
            }
        	// adding to the end of the list
            if(previousNode != null)
                previousNode.setNext(newEntry);
            }
    }
    
    public void remove(K key){
        int index = index(key);
        CustomEntry<K, V> previous = null;
        CustomEntry<K,V> entry = table[index];
        while (entry != null){
        	if(entry.getKey().equals(key)){
                if(previous == null){
                    entry = entry.getNext();
                    table[index] = entry;
                    return;
                }else {
                    previous.setNext(entry.getNext());
                    return;
                }
            }
            previous = entry;
            entry = entry.getNext();
        }
    }
    
    public V get(K key){
        V value = null;
        int index = index(key);
        CustomEntry<K, V> entry = table[index];
        while (entry != null){
            if(entry.getKey().equals(key)) {
                value = entry.getValue();
                break;
            }
            entry = entry.getNext();
        }
        return value;
    }
    
    private int index(K key){
        if(key == null){
            return 0;
        }
        return Math.abs(key.hashCode() % capacity);
    }
}
