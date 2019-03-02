package part1;

import java.util.*;

/**
 * Map methods are implemented by using double hashing
 * @param <K> is key which is unique id
 * @param <V> is value which is key of value
 */
public class CustomMap<K,V> implements MapInterface<K,V> {
    /**
     *keep key and value.
     * Type=Inner class type.
     */
    private KeyValue<K,V>[] data;
    /**
     *final static variable
     * uses to initializes data instance variable
     */
    private static final int INIT_CAPACITY=101;
    /**
     *there is totalkey in data(map)
     */
    private int totalkey;
    /**
     *the number of total deleted element
     */
    private int totaldelete;


    /**
     *keeps element size in map
     */
    private int size;
    /**
     * uses to put get and remove method
     * this instance variable uses in contains method
     */
    private int location;

    /**
     * keeps cap
     */
    private int cap=101;
    /**
     * private method
     * calculate the index for open adressing
     * @param key is unique id in map
     * @return index(uses hashCode and mod to find index)
     */
    private int hash1Code(K key){
        return key.hashCode()%data.length;
    }
    /**
     * private method
     * calculate the second number for double hashing
     * @param key is unique id for map values
     * @return number
     */
    private int hash2Code(K key){
        return 13-(key.hashCode()%13);
    }

    /**
     * private method
     * takes two parametr.
     * Uses double hashing formula((hash1Code(key)+num*hash2Code(key))%data.length)
     * calculate the new index for double hashing because
     * first index is either not empty or there is removed element
     * @param key is unique id for map values
     * @param num this parametr uses in double hashing formula if index is not appopriarite num increases
     * @return returns new index for unique key
     */
    private int doubleHash(K key,int num){
        return (hash1Code(key)+num*hash2Code(key))%data.length;
    }
    /**
     * No parametr constructor
     * initilizes instance variables
     */
    public CustomMap(){
        totalkey=0;
        totaldelete=0;
        size=0;
        location=0;
        data=new KeyValue[INIT_CAPACITY];
        for(int i=0;i<INIT_CAPACITY;i++)
            data[i]=new KeyValue<>();
    }
    public void showHashIndex(K key){
        containsKey(key);
        System.out.println("key "+key+" index is---->"+location);
        location=0;
    }

    public  int cap() {
        return cap;
    }

    /**
     *rehash table to keep loadfactor rate
     * First assigns main data another KeyValue<K,V> array object
     * initialize all instance variable.
     * uses put method and adds all method new locaiton with use double hashing
     */
    private void rehashTable(){
        KeyValue<K,V> save[]=data;
        data=new KeyValue[2*save.length+1];
        cap=2*save.length+1;
        totalkey=0;
        size=0;
        totaldelete=0;
        for(int i=0;i<save.length;i++)
            put(save[i].key,save[i].value);
    }
    private KeyValue getIndex(int i){
        return data[i];
    }


    /**
     *Removes all element in map and initializes hashtable again
     * no returns
     */
    @Override
    public void clear() {
        data=null;
        size=0;
        data=new KeyValue[INIT_CAPACITY];
        totalkey=0;
    }
    /**
     * searches the key
     * @param key is unique key in map
     * @return true if the key mapping in map else return false
     */
    @Override
    public boolean containsKey(K key) {
        int num=0;
        int index=doubleHash(key,num);
        if(index<0)
           index+=data.length;
        boolean boo=false;
        //while loop continues if key isn't find and boo is false
         while(boo==false&&data[index].key!=null){
           if(data[index].key!=null&&data[index].value==null) {//if this area used before calls method doublehash and returns above the while
               num++;
               index = doubleHash(key, num);
           }
           else if(data[index].key.equals(key))//if key is matches in list boo is true this meeans that key is found*/
               boo=true;
           else{//calls doublehash method.
               index=doubleHash(key,num);
               if(index<0)
                   index +=data.length;
               num++;//to use formula for double hashing
           }
       }
       location=index;
       return boo;
    }
    /**
     * if there is in map given parametr value returns true
     * else returns false
     * @param value is unique id's value
     * @return boolean(true or false)
     */
    @Override
    public boolean containsValue(V value) {
        boolean boo=false;
        for(int i=0;i<data.length&&boo==false;i++){
            if(data[i].getValue()!=null&&data[i].value.equals(value)){
                location=i;
                boo=true;
            }
        }
        return boo;
    }
    /**
     * returns size
     * @return size
     */
    @Override
    public int size() {
        return size;
    }
    /**
     * checks size if size is 0 return true else returns false
     * @return true or false
     */
    @Override
    public boolean isEmpty() {
        return (size==0);
    }
    /**
     * if object null returns null
     * else calls contains method.
     * if contains returns true returns value
     * else return null
     * @param o is key
     * @return null or value
     */
    @Override
    public Object get(Object o) {
        if(o==null)
            return null;
       boolean boo=containsKey((K) o);
       if(boo==false)
           return null;
       else
           return data[location].value;
    }
    /**
     * uses contains method.
     * if element isn't in map initializes there and add element.
     * checks load factor if load factor is changed rehash map
     * else change key of value
     * @param o is key which is unique id
     * @param o2 is value of key
     * @return value or null. if element can added returns value else return null
     */
    @Override
    public V put(K o, V o2) {
        boolean boo=containsKey(o);
        if(boo==false){
            data[location]=new KeyValue<>(o,o2);
            totalkey++;
            size++;
            double load=(double)(totalkey+totaldelete)/data.length;
            if(load>0.75)
                rehashTable();
            return null;
        }
        else{
            V oldV=data[location].value;
            data[location].setValue(o2);
            return oldV;
        }
    }
    /**
     * remove value. assings a point deleted area
     * @param o is key of removable value
     * @return value. if there is no element returns null
     */
    @Override
    public V remove(Object o) {
        boolean boo=containsKey((K) o);
        if(boo==false)
            return null;
        else{
            V oldV= data[location].value;
            data[location].value=null;
            totaldelete++;
            totalkey--;
            System.out.println();
            return oldV;
        }
    }

    /**
     * add all elements in given map objects with use put method
     * @param map copies all of the mappings from the specified map to this map.
     */
    @Override
    public void putAll(Object map) {
       CustomMap<K,V> cm= (CustomMap<K, V>) map;
        if(cm.size()!=0) {
            for (int i = 0; i < cm.data.length; i++) {
                if (cm.data[i].key!= null) {
                    put(cm.data[i].key, cm.data[i].value);
                }
            }
        }
    }

    /**
     *creates set objects
     * adds all map key in set objects and return this set object
     * @return set object
     */
    @Override
    public Set keySet() {
        Set set=new HashSet();
        for(int i=0;i<data.length;i++){
            if(data[i].key!=null)
                set.add(data[i].key);
        }
        return set;
    }

    /**
     *creates set objects
     * adds all map values in set objects and return this set object
     * @return set object
     */
    @Override
    public Collection values() {
        Set set=new HashSet();
        for(int i=0;i<data.length;i++){
            if(data[i].key!=null)
                set.add(data[i].value);
        }
        return set;
    }

    /**
     * creates set objects
     * adds all map elements in set objects and return this set object
     * @return set object
     */
    @Override
    public Set<Object> entrySet() {
        Set<KeyValue> set=new HashSet<KeyValue>();
        for(int i=0;i<data.length;i++){
            if(data[i].key!=null) {
                System.out.println("key-->"+data[i].key+"  "+"value-->"+data[i].value);
                set.add(data[i]);
            }
        }
        return Collections.singleton(set);
    }

    @Override
    public String toString() {
        System.out.println("-------------------");
        entrySet();
        return "-------------------";
    }

    /**
     *
     * @param <K>
     * @param <V>
     */
    private class KeyValue<K,V>{

        /**
         *The key
         */
        private K key;
        /**
         * The value
         */
        private V value;

        /**
         * assigns key to this.key and assigns value to this.value
         * @param key map key
         * @param value map value
         */
        public KeyValue(K key, V value) {
            this.key = key;
            this.value = value;
        }

        /**
         * no parametr constructor
         */
        public KeyValue() {
            key=null;
            value=null;
        }

        /**
         * Retrieves the key
         * @return key
         */
        public K getKey() {
            return key;
        }

        /**
         * Retrieves the value
         * @return value
         */
        public V getValue() {
            return value;
        }

        /**
         * Set the value
         * @param value new value
         * @return the old value
         */
        public V setValue(V value) {
            V addReturn=value;
            this.value = value;
            return addReturn;
        }

        /**
         * set key given parametr
         * @param key assigns to thisçkey
         */
        public void setKey(K key) {
            this.key = key;
        }
    }
}
