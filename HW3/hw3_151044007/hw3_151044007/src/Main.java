import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        String test1[]={"CSE 222","3","6","3","cse 2214","-1","3","-55","2","cse 112","Computer","4","7","2+2+0"};
	    System.out.println("------------------Part1 test--------------------");
        try {
            Curriculum_part1 cr = new Curriculum_part1();
            cr.printCourses();
            System.out.println("------------------getByCode--------------------");
            cr.getByCode(test1[0]);
            System.out.println("------------------getByRange--------------------");
            cr.getByRange(Integer.parseInt(test1[1]),Integer.parseInt(test1[2]));
            System.out.println("------------------listSemesters--------------------");
            cr.listSemesterCourses(Integer.parseInt(test1[3]));
            System.out.println("------------------addCourse--------------------");
            cr.addCourse(Integer.parseInt(test1[8]),test1[9],test1[10],Integer.parseInt(test1[11]),Integer.parseInt(test1[12]),test1[13]);
            System.out.println("------------------getByCode(Exception)--------------------");
            cr.getByCode(test1[4]);


        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        try{
            Curriculum_part1 cr = new Curriculum_part1();
            System.out.println("------------------getByRange(Exception)--------------------");
            cr.getByRange(Integer.parseInt(test1[5]),Integer.parseInt(test1[6]));

        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try{
            Curriculum_part1 cr = new Curriculum_part1();
            System.out.println("------------------listSemester(Exception)--------------------");
            cr.listSemesterCourses(Integer.parseInt(test1[7]));

        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("------------------------------------------------");
        System.out.println("------------------------------------------------");
        System.out.println("------------------------------------------------");
        System.out.println("------------------Part2 test--------------------");
        String test2[]={"2","23","23"};
        Curriculum_part1 cr1 = new Curriculum_part1();
        LinkedListNew_part2<Course_part1> ls=new LinkedListNew_part2<>();
        for(int i=0;i<cr1.getCourseNumber();i++)
            ls.add(cr1.getCourseData().get(i));
        System.out.println("----------------soon to be disabled element--------------------");
        System.out.println(cr1.getCourseData().get(Integer.parseInt(test2[0])));
        System.out.println("-----------------------before disabled size-------------------------");
        System.out.println(ls.size());
        ls.disabled(cr1.getCourseData().get(Integer.parseInt(test2[0])));
        System.out.println("-----------------------before disabled size-------------------------");
        System.out.println(ls.size());
        System.out.println("----------------soon to be disabled element--------------------");
        System.out.println(cr1.getCourseData().get(Integer.parseInt(test2[0])));
        System.out.println("-----------------------before disabled size-------------------------");
        System.out.println(ls.size());
        ls.disabled(cr1.getCourseData().get(Integer.parseInt(test2[1])));
        System.out.println("-----------------------after disabled size-------------------------");
        System.out.println(ls.size());
        System.out.println("-------------------ShowsDisabled---------------------");
        ls.showDisabled();
        System.out.println("-------------------before Enable second disabled element index ---------------------");
        System.out.println(ls.get(Integer.parseInt(test2[2])));
        System.out.println("-------------------after Enable second disabled element index ---------------------");
        ls.enabled(cr1.getCourseData().get(Integer.parseInt(test2[2])));
        System.out.println(ls.get(Integer.parseInt(test2[2])-1));

        System.out.println("------------------------------------------------");
        System.out.println("------------------------------------------------");
        System.out.println("------------------------------------------------");
        System.out.println("------------------Part2 test--------------------\n\n\n");
        try {
            String test3[] = {"a", "e", "f", "enable", "e", "enable", "a", "enable", "disable"};
            LinkedListNew_part2<String> ls1 = new LinkedListNew_part2<>();
            ls1.add("a");
            ls1.add("b");
            ls1.add("c");
            ls1.add("d");
            ls1.add("e");
            ls1.add("f");
            ls1.add("g");
            System.out.println("-------------------ShowsSize---------------------");
            System.out.println(ls1.size());
            ls1.disabled(test3[0]);
            ls1.disabled(test3[1]);
            ls1.disabled(test3[2]);

            System.out.println("-------------------ShowsSizeafterdisable---------------------");
            System.out.println(ls1.size());
            System.out.println("-------------------ShowsDisabled---------------------");
            ls1.showDisabled();
            System.out.println("-------------------ShowsEnabled---------------------");
            ls1.printItems(test3[3]);
            ls1.enabled(test3[4]);
            System.out.println("-------------------ShowsEnabled---------------------");
            ls1.printItems(test3[5]);
            System.out.println("-------------------ShowsSize---------------------");
            System.out.println(ls1.size());
            ls1.enabled(test3[6]);
            System.out.println("-------------------ShowsEnabled---------------------");
            ls1.printItems(test3[7]);
            System.out.println("-------------------Showsdisabled---------------------");
            ls1.printItems(test3[8]);
        }
        catch (Exception e){
            e.getMessage();
        }
        System.out.println("------------------------------------------------");
        System.out.println("------------------------------------------------");
        System.out.println("------------------------------------------------");
        System.out.println("------------------Part3 test--------------------\n\n\n");
        int test4[] = {1,15,3,21};
        try{
            Curriculum_part1 crs=new Curriculum_part1();
            CircularCustomList_part3 circular=new CircularCustomList_part3<>(crs);
            circular.chooseSemester(test4[0]);
            System.out.println(circular.nextSemester());
            System.out.println(circular.nextSemester());
            System.out.println(circular.nextSemester());
            System.out.println(circular.nextSemester());
            System.out.println(circular.nextSemester());
            System.out.println(circular.nextSemester());
            System.out.println(circular.nextSemester());
            System.out.println(circular.nextSemester());
            System.out.println("--------------------returns first index--------------------------");
            System.out.println(circular.nextSemester());
            System.out.println("--------------------wrong semester--------------------------");
            circular.chooseSemester(test4[1]);
            System.out.println("--------------------normally next--------------------------");
            System.out.println(circular.next());
            System.out.println(circular.next());
            System.out.println(circular.next());
            System.out.println(circular.next());
            System.out.println(circular.next());
            System.out.println(circular.next());
            System.out.println(circular.next());
            System.out.println(circular.next());
            System.out.println(circular.next());
            System.out.println(circular.next());
            System.out.println("--------------------size--------------------------");
            System.out.println(circular.size());
            System.out.println("--------------------get method--------------------------");
            System.out.println(circular.get(test4[2]));
            System.out.println("--------------------clear all things looks size--------------------------");
            circular.clear();
            System.out.println(circular.size());
            System.out.println("-----------------remove element from index----------------");
            System.out.println(circular.remove(test4[3]));
        }
        catch (Exception e){
            e.getMessage();
        }



    }
}
