package part2;

import part1.CustomMap;

import java.security.Key;
import java.util.*;

public class ChainingHashSet<K> {

        private boolean boo;
        /**
         *keeps data
         */
        public LinkedList<KeyValue>[] data;

        /**
         *init capacity
         */
        private static final int INIT_CAPACITY=31;
        /**
         *size
         */
        private int size;
        /**
         *to use chaining
         */
        private Stack<Integer> prime=new Stack();
        /**
         *to use rehash
         */
        private Vector<K> ls=new Vector();

        private int location;
        /**
         *
         * @param num integer numer
         * @return num if num is prime else return -1
         */
        private int isPrime(int num) {
            if (num < 2)
                return -1;
            else if (num == 2)
                return 2;
            else if (num % 2 == 0)
                return -1;
            for (int i = 3; i * i <= num; i += 2)
                if (num % i == 0)
                    return -1;
            return num;
        }

        /**
         *adds prime numner in stack to do chain hash
         */
        private void addPrime(){
            Random rand=new Random();
            int num=rand.nextInt(150);
            for(int i=0;i<1000;i++){
                if(isPrime(i)!=-1)
                    prime.add(i);
            }
        }

        /**
         *no parametr consturtor
         */
        public ChainingHashSet(){
            size=0;
            data=new LinkedList[INIT_CAPACITY];
            addPrime();
        }
    public void showHashIndex(K key){
       contains(key);
        System.out.println("key "+key+" index is---->"+location);
        location=0;
    }
        /**
         * calculates index with use key and hashcode
         * @param key set key
         * @param size hashtable.lenght
         * @return index
         */
        private int hash1Code(K key,int size){
            return key.hashCode()%size;
        }

        /**
         * returns size
         * @return size
         */
        public int size() {
            return size;
        }

        /**
         * checks whether set is empty
         * @return bool
         */
        public boolean isEmpty() {
            return (size==0);
        }

        /**
         *
         * @param o parametr to find in set
         @return bool if find return true else return false
         */
        public boolean contains(Object o) {
            data=find((K) o,this.data);
            return boo;
        }

        /**
         *if hashcode index is null return false.
         * if finds return true.
         * else calls method recursively with keyvalue instance variable(LinkedList<Keyvalue[])
         * @param key generic set value
         * @param list linked list
         * @return bool if find return true else return false
         */
        private LinkedList<KeyValue>[] find(K key, LinkedList<KeyValue>[] list){
            int index=hash1Code(key,list.length);
            if(index<0)
                index+=list.length;
            if(list[index]==null) {
                boo=false;
                return list;
            }
            else if(list[index].getFirst().deleted!=null&&list[index].getFirst().deleted.equals(list[index].getFirst().value))
                if(list[index].getFirst().list!=null)
                    find(key,list[index].getFirst().list);
                else {
                    boo=false;
                    return list;
                }
            else if(list[index].getFirst().value.equals(key)) {
                location=index;
                boo=true;
                return list;
            }
            else if(!list[index].getFirst().value.equals(key)){
                find(key,list[index].getFirst().list);
            }
            boo=false;
            return list;
        }

        /**
         *rehash method
         * initializes with new size
         * initializes prime number for chain hashing
         */
        private void rehashTable(){
            LinkedList<KeyValue>[] save=data;
            data=new LinkedList[2*save.length+1];
            size=0;
            for(int i=0;i<save.length;i++) {
                add(ls.get(i));
                ls.remove(i);
            }
            prime=new Stack<>();
            addPrime();
        }

        /**
         * try to add element int list
         * @param o addable element in set
         * @return boolean
         */
        public boolean add(Object o) {
            boo=false;
            data=put((K) o,data,data.length,boo);
            return boo;
        }

        /**
         * if hashcode index is null add element. increase size checks loadfactor
         * if hashcode index is not null but its value is removed add there and increase size and return list
         * if there is a element return list and boo is false
         * if hascode index is not null calls method again with keyvalue list recursively return list
         * @param key generic set value
         * @param list linked list
         * @param cap to find hashcode
         * @param boo to determine main method return value
         * @return LinkedList
         */
        private LinkedList<KeyValue>[] put(K key, LinkedList<KeyValue>[] list, int cap, boolean boo){
            int index=hash1Code(key,list.length);
            if(index<0)
                index+=list.length;
            if(list[index]==null) {
                this.boo=true;
                list[index] = new LinkedList<>();
                list[index].add(new KeyValue(key));
                ls.add(key);
                size++;
                if(size>(3.0*data.length))
                    rehashTable();
                return list;
            }
            else if(list[index].getFirst().deleted!=null&&list[index].getFirst().deleted.equals(list[index].getFirst().value)&&list[index].getFirst().list!=null){
                put(key,list[index].getFirst().list,list[index].getFirst().list.length,boo);
            }
            else if(list[index].getFirst().value.equals(key)) {
                this.boo=false;
                return list;
            }
            else if(!list[index].getFirst().value.equals(key)){
                this.boo=false;
                if(list[index].getFirst().list==null) {
                    list[index].getFirst().list = new LinkedList[(int) prime.pop()];
                    System.out.println("chaning index->" + list[index].getFirst().list.length);
                }
                put(key,list[index].getFirst().list,list[index].getFirst().list.length,boo);
                return list;
            }
            return null;
        }

        /**
         * if element is in list  remove element from list return rrue
         * else return false
         * @param o element
         * @return boolean
         */
        public boolean remove(Object o) {
            data= remove((K) o,this.data);
            return boo;
        }

        /**
         *if hashcode index is null returns false
         * if there is a matching set element remove it, decrease size return true
         * if there is no key calls recursively method
         * @param key generic set value
         * @param list linked list
         * @return
         */
        private LinkedList<KeyValue>[] remove(K key, LinkedList<KeyValue>[] list){
            int index=hash1Code(key,list.length);
            if(index<0)
                index+=list.length;
            if(list[index]==null) {
                boo=false;
                return list;
            }
            else if(list[index].getFirst().deleted==null&&list[index].getFirst().value.equals(key)) {
                list[index].getFirst().deleted=key;
                size--;
                ls.remove(key);
                boo=true;
                return list;
            }
            else if(list[index].getFirst().deleted.equals(list[index].getFirst().value))
                if(list[index].getFirst().list!=null)
                    find(key,list[index].getFirst().list);
                else {
                    boo=false;
                    return list;
                }
            else if(!list[index].getFirst().value.equals(key)){
                find(key,list[index].getFirst().list);
            }
            boo=false;
            return list;
        }

        /**
         *clear data and initializes instsnce variable
         */
        public void clear() {
            size=0;
            data=new LinkedList[INIT_CAPACITY];
        }


    /**
         *private inner class
         */
        private class KeyValue{

            /**
             *The key
             */
            private K value;
            private K deleted;

            private LinkedList<KeyValue> list[];

            /**
             * assigns key to this.key and assigns value to this.value
             * @param key
             */
            private KeyValue(K key) {
                this.value = key;
            }

            /**
             * no parametr consturtor
             */
            public KeyValue() {
                value=null;
            }
            /**
             * Retrieves the key
             * @return key
             */
            public K getValue() {
                return value;
            }


            /**
             * Set the value
             * @param value new value
             * @return the old value
             */
            public K setValue(K value) {
                K addReturn=value;
                this.value = value;
                return addReturn;
            }
        }
}

