package part1;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * Map interface class
 * Includes map methods
 * @param <K> K which is unique id of each value is key
 * @param <V> V is value of unique key
 */
public interface MapInterface<K,V> {
    /**
     * Removes all of the mappings from this map
     */
    void clear();

    /**
     * searchs a mapping for the specified key
     * @param key is unique key in map
     * @return true if this map contains a mapping for the specified key else returns false
     */
    boolean containsKey(K key);

    /**
     * searchs a mapping for the value
     * @param value is unique id's value
     * @return true if this map maps one or more keys to the specified value.
     */
    boolean containsValue(V value);

    /**
     * the number of key-value mappings in this map.
     * @return  the number of key-value mappings in this map.
     */
    public int size();

    /**
     * checks whether map is empty
     * @return true if this map contains no key-value mappings.
     */
    public boolean isEmpty();

    /**
     *
     * @param o is key
     * @return  the value to which the specified key is mapped, or null if this map contains no mapping for the key.
     */
    public Object get(Object o);

    /**
     *
     * @param o is key which is unique id
     * @param o2 is value of key
     * @return associates the specified value with the specified key in this map (
     */
    public V put(K o, V o2);

    /**
     * Removes the mapping for a key from this map if it is present
     * @param o is key of removable value
     * @return null is if there is no key else returns removed value
     */
    public V remove(Object o);

    /**
     *
     * @param map copies all of the mappings from the specified map to this map.
     */
    public void putAll(Object map);

    /**
     *
     * @return  a Set view of the keys contained in this map.
     */
    public Set keySet();

    /**
     *
     * @return a Collection view of the values contained in this map.
     */
    public Collection values();

    /**
     *
     * @return
     */
    public Set<Object> entrySet();



}