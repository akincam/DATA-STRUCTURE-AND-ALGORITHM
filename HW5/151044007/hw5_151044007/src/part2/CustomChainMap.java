package part2;

import part1.MapInterface;
import java.util.*;

public class CustomChainMap<K,V>  {
    /**
     *keep key and value.
     * Type=Inner class type.
     */
     public LinkedList<KeyValue>[] data;
    /**
     *final static variable
     * uses to initializes data instance variable
     */
    private static final int INIT_CAPACITY=31;
    /**
     *Load factor totalkey and deleted element
     * 0.75 is the most appropriate number or LoadFactor
     */
    /**
     *keeps element size in map
     */
    private int size;

    private Vector<KeyValue> ls=new Vector<>();


    public CustomChainMap(){
        size=0;
        data=new LinkedList[INIT_CAPACITY];
    }

    private int hash1Code(K key,int size){
        return key.hashCode()%size;
    }


    public void clear() {
        size=0;
        data=new LinkedList[INIT_CAPACITY];
    }


    public boolean containsKey(K key) {
     /*   boolean boo=false;
        int index=hash1Code(key);
        if(boo==true)
            return true;
        if(index<0)
            index=index+data.length;
        if(data[index]==null)
            return false;
        else if(data[index].get(0).key.equals(key))
            return true;
        else if(data[index]!=null&&data[index].get(0).key.equals(key)==false)
            helperContains(boo,data[index],key);
        else
            return boo;*/
        return true;

    }
 /*   private int helperContains(boolean boo, KeyValue<K, V> list[], K key){
        int index=hash1Code(key);
        if(index<0)
            index=index+data.length;
        if(list[index]==null)
            return false;
    }*/



    public int size() {
        return size;
    }


    public boolean isEmpty() {
        return size==0;
    }


    public Object get(Object o) {
        V v = null;
        data=get(o,data,v);
        return v;
    }
    private LinkedList<KeyValue>[] get(Object k,LinkedList<KeyValue>[] ls,V value) {
        int index = hash1Code((K) k, ls.length);
        if (index < 0)
            index += ls.length;
        if (ls[index] == null)
            return null;
        else if (ls[index].getFirst().key.equals(k))
            return ls;
        else if (!data[index].getFirst().key.equals(k)) {
            get(k,ls[index].getFirst().list,value);
            return ls;
        }
        else
            return null;
    }
    private void rehashTable(){
        LinkedList<KeyValue>[] save=data;
        data=new LinkedList[2*save.length+1];
        size=0;
        for(int i=0;i<save.length;i++) {
            put(ls.get(i).key, ls.get(i).value);
            ls.remove(i);
        }

    }

    public V put(K o, V o2) {
        data=put(o,o2,data,data.length);
        return null;

    }
    private LinkedList<KeyValue>[] put(K key,V value,LinkedList<KeyValue>[] list,int cap){
        int index=hash1Code(key,cap);
        if(index<0)
            index+=list.length;
        if(list[index]==null) {
            list[index] = new LinkedList<>();
            list[index].add(new KeyValue(key, value));
            ls.add(new KeyValue(key, value));
            size++;
            if(size>(3.0*data.length))
                rehashTable();
            return list;
        }
        else if(list[index].getFirst().key.equals(key)) {
            V oldV = (V) list[index].getFirst().value;
            list[index].getFirst().setValue(value);
            ls.set(ls.indexOf(new KeyValue(key, oldV)),new KeyValue(key, value));
            return list;
        }
        else if(!list[index].getFirst().key.equals(key)){
            put(key,value,list[index].getFirst().list,2);
            return list;
        }
        return null;
    }


    public V remove(Object o) {
        return null;
    }


    public class KeyValue{

        /**
         *The key
         */
        private K key;
        /**
         * The value
         */
        private V value;

        private LinkedList<KeyValue> list[];

        /**
         * assigns key to this.key and assigns value to this.value
         * @param key
         * @param value
         */
        private KeyValue(K key, V value) {
            this.key = key;
            this.value = value;
            list=new LinkedList[2];
        }

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

        public void setKey(K key) {
            this.key = key;
        }
    }
}
