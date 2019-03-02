package part1;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Main {
    public static void main(String[] args){
        CustomMap<Integer,Integer> map=new CustomMap<Integer,Integer>();
        System.out.println("Map size is--->"+map.size());
        System.out.println("Map cap is---->"+map.cap());
        System.out.println("-----------//---------");
        System.out.println("first collision first index of two key is --->"+"first-->"+5%101+"  second-->"+106%101);
        map.put(5,1); map.showHashIndex(5);
        map.put(106,2); map.showHashIndex(106);
        System.out.println("----------------------");
        System.out.println("first collision first index of two key is --->"+"first-->"+52%101+"  second-->"+153%101);
        map.put(52,3); map.showHashIndex(52);
        map.put(153,4); map.showHashIndex(153);
        System.out.println("----------------------");
        System.out.println("first collision first index of two key is --->"+"first-->"+6%101+"  second-->"+107%101);
        map.put(6,5);map.showHashIndex(6);
        map.put(107,6); map.showHashIndex(107);
        System.out.println("----------------------");
        System.out.println("first collision first index of two key is --->"+"first-->"+99%101+"  second-->"+200%101);
        map.put(99,7); map.showHashIndex(99);
        map.put(200,8); map.showHashIndex(200);
        System.out.println("----------------------");
        System.out.println("first collision first index of two key is --->"+"first-->"+3%101+"  second-->"+104%101);
        map.put(3,9); map.showHashIndex(3);
        map.put(104,10); map.showHashIndex(104);
        System.out.println("-----------//---------");
        System.out.println("Map size is--->"+map.size());
        System.out.println("-----------//---------");
        System.out.println(map.toString());
        System.out.println("99(key) is searched in map--->"+map.containsKey(99));
        System.out.println("998(key) is searched in map--->"+map.containsKey(998));
        System.out.println("-----------//---------");
        System.out.println("1(value) is searched in map--->"+map.containsValue(1));
        System.out.println("15(value) is searched in map--->"+map.containsValue(15));
        System.out.println("-----------//---------");
        System.out.println("isEmpty Method-->"+map.isEmpty());
        System.out.println("-----------//---------");
        System.out.println("get method---->6 is searched value of 6 is 5-->"+map.get(6));
        System.out.println("get method---->41 is searched key is not list-->"+map.get(41));
        System.out.println("5 is removed from list");
        map.remove(5);
        System.out.println(map.toString());
        System.out.println("first collision first index of two key 5 before removed --->"+"first-->"+5%101);
        System.out.println("after removed--->");
        map.put(5,1); map.showHashIndex(5);
        System.out.println("putAll method. Added 3 item");
        System.out.println("All elements before putAll");
        CustomMap<Integer,Integer> newmap1 =  new CustomMap<Integer,Integer>();
        newmap1.put(1, 4);
        newmap1.put(2, 4);
        newmap1.put(3, 4);
        System.out.println("-----------//---------");
        map.putAll(newmap1);
        System.out.println("after add");
        System.out.println(map.toString());
        System.out.println("          Test2\n\n\n\n");
        CustomMap<String, Integer> map2=new CustomMap<>();
        System.out.println("Map size is--->"+map2.size());
        System.out.println("Map cap is---->"+map2.cap());
        System.out.println("-----------//---------");
        System.out.println("first index of  key is --->\"+\"first-->"+"akin".hashCode()%101);
        map2.put("akin",1); map2.showHashIndex("akin");
        System.out.println("first index of  key is --->\"+\"first-->"+"hürriyet".hashCode()%101);
        map2.put("cam",2); map2.showHashIndex("cam");
        System.out.println("-----------//---------");
        System.out.println("Map size is--->"+map2.size());
        System.out.println("-----------//---------");
        System.out.println(map2.toString());
        System.out.println("akin(key) is searched in map--->"+map2.containsKey("akin"));
        System.out.println("c(key) is searched in map--->"+map2.containsKey("c"));
        System.out.println("1(value) is searched in map--->"+map2.containsValue(1));
        System.out.println("15(value) is searched in map--->"+map2.containsValue(15));
        System.out.println("get method---->cam is searched cam of value -->"+map2.get("cam"));
        System.out.println("get method----> is searched key is not list-->"+map2.get("akinnn"));
        map2.remove("akin");
        System.out.println(map2.toString());
        System.out.println("first index before removed of  key is --->\"+\"first-->"+"akin".hashCode()%101);
        System.out.println("after removed--->");
        map2.put("akin",1); map2.showHashIndex("akin");


    }
}
