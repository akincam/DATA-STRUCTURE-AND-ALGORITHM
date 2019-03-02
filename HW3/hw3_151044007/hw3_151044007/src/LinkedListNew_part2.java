import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Objects;
import java.util.Vector;

/**
 * This class extends LinkedList and implements methods of  LinkedListNewMethods_part2
 * if a  item which can disable disable the item and index add disable,disable order. The list add lastStuation. remove the item
 * if a can item enable Find own neighbour in lastStuation and add linked list relative index.
 * @param <E>
 */
public class LinkedListNew_part2<E> extends LinkedList<E> implements LinkedListNewMethods_part2<E> {

    /**
     * keep disable items.
     */
    private LinkedList<E> disable;
    /**
     * keeps the linkedlist items to add when a items enable(compare and put their old neighbour)
     */
    private Vector<E> lastStuation;
    /**
     * keeps disable items index.
     */
    private LinkedList<Integer> disableOrder;

    /**
     *
     * @param o object parameters
     * @return true the objects are equal else return false
     */
    @Override
    public boolean equals(Object o) {
        for(int i=0;i<disable.size();i++)
            if(o instanceof LinkedListNew_part2&& this.disable.get(i).equals(((LinkedListNew_part2) o).disable.get(i)))
                return true;
        return false;
    }

    /**
     * to String method
     * @return String
     */
    @Override
    public String toString() {
        for(int i=0;i<this.size();i++)
            for(int k=0;k<disableOrder.size();k++){
                if(disableOrder.get(k)==i)
                    i++;
                else
                    System.out.println(this.get(i));
            }
        return this.toString();
    }

    /**
     * overrride Hascode method.
     * @return
     */
    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), disable, disableOrder);
    }

    /**
     * No parametr constructor
     * Initializes disable,disableOrder,LastStuation.
     */
    public LinkedListNew_part2(){
        disable=new LinkedList<>();
        disableOrder=new LinkedList<>();
        lastStuation=new Vector<>();

    }

    /**
     * Add new item lastStuation to compare items find old location or nearest location.
     * @param e takes generic type.
     */
    @Override
    public void addFirst(E e) {
        lastStuation.add(0,e);
        super.addFirst(e);
    }

    /**
     * Add new item lastStuation to compare items find old location or nearest location.
     * @param e takes generic type.
     */
    @Override
    public void addLast(E e) {
        lastStuation.addElement(e);
        super.addLast(e);
    }

    /**
     * Add new item lastStuation to compare items find old location or nearest location.
     * @param e takes generic type.
     * @return true if methods can add else return false
     */
    @Override
    public boolean add(E e) {
        lastStuation.addElement(e);
        return super.add(e);
    }

    /**
     * add new item lastStuation to compare items find old location or nearest location.
     * @param i index to add
     * @param e takes generic type.
     * throws exception if cant add
     */
    @Override
    public void add(int i, E e) {
        lastStuation.add(i,e);
        super.add(i, e);
    }

    /**
     * checks given parametr whether is disabled. If disabled shows message.
     * if parametr can disable, disable it eturn true else return false.
     * @param disabled : to disable.(checks disabled is legal,same object and not disabled method.)
     * @return if given parametr is convenient and can disable return true else false
     */
    @Override
    public boolean disabled(E disabled) {

        int csize=disable.size();
        for(int i=0;i<disable.size();i++){
            if(disabled.equals(disable.get(i))==true){//if there is no matching method.
                System.out.println("This is already disabled!");
                return false;
            }
        }
        for(int i=0;i<this.size();i++)
            if(disabled.equals(this.get(i))){//if disabled matching a item in LinkedList
                disable.add(disabled);//adds disabled object in disable(LinkedList)
                disableOrder.add(i);//add disable items'S index
                remove(i);//remove the items from list
            }
        if(csize<disable.size())//if disable size increases this means that there is matching item and disable it
            return true;

        return false;
    }

    /**
     *
     * @param i index to check
     * @param enabled disable item
     * @return nearest old index of disable item
     */
    private int setEnableindex(int i,E enabled){
        int sze=0;
        int k=0;
        if(size()>lastStuation.size())
            sze=size();
        else
            sze=lastStuation.size();
        if(i==0)//disable items's old index is 0
            return 0;
        else if(i==size()+disableOrder.size()-1)//disable items's old index is last index from list
            return size();
        else if(lastStuation.indexOf(enabled)-1>=0&&indexOf(lastStuation.get(lastStuation.indexOf(enabled)-1))>0)
            //if enable items's old neighbour is in list adds enable item after the neighbour
            return indexOf(lastStuation.get(lastStuation.indexOf(enabled)-1))+1;
        for(k=0;k<sze;k++)//if above the conditions isn't valid checks list and last stuation add best location
            if(!get(k).equals(lastStuation.get(k)))
                break;
        return k;
    }

    /**
     * checks whether E enable is in disable
     * if true add best index.
     * remove enabled and its index from disable and disableOrder
     * @param enabled : to enable.(checks enabled is legal,same object and not enabled method.)
     * @return if true items can enable else return false
     */
    @Override
    public boolean enabled(E enabled) {
        int csize=disable.size();
        for(int i=0;i<disable.size();i++)
            if (disable.get(i).equals(enabled)){
                this.add(setEnableindex(disableOrder.get(i),enabled),disable.get(i));
                disable.remove(i);
                disableOrder.remove(i);

            }
        if(csize>disable.size())//if disable size decreases this means that there is matching item and disable it
            return true;
        return false;
    }

    /**
     * Shows disable items takes disable items from disable.
     * @return false if there is no disable items else return true and shows items
     */
    @Override
    public boolean showDisabled() {
        if(disable.size()==0){
            System.out.println("No items disabled");
            return false;
        }
        System.out.println("Disabled items are ordered:");
        for(int i=0;i<disable.size();i++){
            System.out.println("-->   "+disable.get(i));
        }
        return true;
    }

    /**
     * if items enable return 1
     * if items disable return 2
     * if there is no matching item return 3
     * @param eORd control item
     * @return 1 ,2 or 3
     */
    @Override
    public int EnabledOrDisabled(E eORd) {
        for(int i=0;i<disable.size();i++)
            if(eORd.equals(disable.get(i)))
                return 2;
        for(int i=0;i<this.size();i++)
            if(eORd.equals(this.get(i)))
                return 1;
        return 3;
    }

    /**
     * if enable shows enable items
     * if disable shows disable items
     * @param s Enable or disable
     */
    @Override
    public void printItems(String s) {
        String str=new String();
        str=s.toUpperCase();
        switch (str){
            case "ENABLE":
                if(this.size()==0)
                    System.out.println("No items!");
                else{
                    for(int i=0;i<this.size();i++)
                        System.out.println(this.get(i));
                }
                break;
            case "DISABLE":
                if(disable.size()==0)
                    System.out.println("No disable items");
                else{
                    for(int i=0;i<disable.size();i++)
                        System.out.println(disable.get(i));
                }
                break;
            default:
                System.out.println("Incorrect input");

        }
    }



}
