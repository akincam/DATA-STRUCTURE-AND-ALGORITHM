package part1;

import static org.junit.jupiter.api.Assertions.*;

class CustomMapTest {

    @org.junit.jupiter.api.Test
    void containsKey() {
        CustomMap cs=new CustomMap();
        cs.put("akin","akin");
        System.out.println("a element which is in map searched. return is true-->");
        System.out.println(cs.containsKey("akin"));
        assertEquals(cs.containsKey("akin"),true);
        System.out.println("a element which isn't in map searched. return is false-->");
        assertEquals(cs.containsKey("akinn"),false);
        System.out.println(cs.containsKey("akinn"));
    }

    @org.junit.jupiter.api.Test
    void get() {
        CustomMap cs=new CustomMap();
        cs.put("akin","akin");
        cs.put("ak21in","akin11");
        System.out.println("a element which is in map gets. return is akin-->");
        System.out.println(cs.get("akin"));
        assertEquals(cs.get("akin"),"akin");
        System.out.println("a element which isn't in map get. return is null-->");
        assertEquals(cs.get("akinn"),null);
        System.out.println(cs.get("akinn"));
    }

    @org.junit.jupiter.api.Test
    void put() {
        CustomMap cs=new CustomMap();

        System.out.println("a element which isnt in map put this element. return is null-->");
        assertEquals(cs.put("akin","akin"),null);

        System.out.println("a element which is in map put this element. return is before value-->");
        assertEquals(cs.put("akin","ebru"),"akin");
    }

    @org.junit.jupiter.api.Test
    void remove() {
        CustomMap cs=new CustomMap();
        cs.put("akin","akin");
        cs.put("ak21in","akin11");
        System.out.println("a element which isnt in map put this element. return is null-->");
        assertEquals(cs.remove("a"),null);
        System.out.println("a element which is in map put this element. return is  value-->");
        assertEquals(cs.remove("akin"),"akin");
    }
}