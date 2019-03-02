/**
 * extends NewCustomList_part3
 * adding circular list.
 * override next method.
 * adding nextSemester method for Course_part1 object and Curriculum(course structure diagram)
 * @param <E>
 */
public class CircularCustomList_part3<E> extends NewCustomList_part3<E>{
    /**
     * keeps which semester is choosen
     */
    private int semester1=0;
    /**
     * keeps number of each semester's course
     */
    private int ASemesterCourseNum[]=new int[8];
    /**
     * keeps the total start and last index of course number
     */
    private int totalNumber[]=new int[8];
    /**
     * semesterCount;
     */
    private int semesterCount=0;

    /**
     * takes Courriculum_part1 parametr and add them newlist
     * addCourses method is called there.
     * @param curriculum
     */
    public CircularCustomList_part3(Curriculum_part1 curriculum){
        for(int i=0;i<curriculum.getCourseData().size();i++) {
            add((E) curriculum.getCourseData().get(i));
        }
        nextNum=0;
        addCourses(curriculum);

    }

    /**
     * find each semester course number
     * find course number of given indexs
     * @param cr takes Curriculum parametr
     */
    private void addCourses(Curriculum_part1 cr){
        int count=1;
        while(count<9){//loop continues last semester
            ASemesterCourseNum[count-1]=cr.listSemesterCourses(count).length;//adds each semester course number
            if(count==1)
                totalNumber[count-1]=cr.listSemesterCourses(count).length;
            else
                totalNumber[count-1]=cr.listSemesterCourses(count).length+totalNumber[count-2]; // adds course number of given indexs
            count++;
        }
    }
    /**
     * checks if choosen semester's course is last index return first index of choosen semestr
     * @return Course_part1 object
     */
    public E nextSemester(){
        Node<E> current = null;
        if(nextNum==totalNumber[semester1-1]) {
            current=connectSemesters(semester1,totalNumber);
            if(semester1==1)
                nextNum=1;
            else
                nextNum=totalNumber[semester1-1]-totalNumber[semester1-2]+1;
            return current.data;
        }
        else
            return this.next();



    }




    /**
     * takes semester number
     * @param i semester number
     * @return
     */
    public boolean chooseSemester(int i){
        if(i<0||i>8) {
            System.out.println("Wrong semester!!! Enter the 1-8");
            return false;
        }
        else {
            semester1 = i;
            if(semester1==1)
                nextNum = 0;
            else
                nextNum=totalNumber[semester1-2];
        }
        return true;
    }

    /**
     *
     * @return passed generic item
     */
    @Override
    public E next() {
        Node<E> current;
        if(size==0)//if there is no element return null
            return null;
        else if(size==1) {//if size=1
            return null;
        }
        else if((nextNum+1)==size)
            return null;
        else{
            nextNum++;
            getSemester();
           current=gnode(nextNum-1);
           return current.data;

        }
    }
    private void getSemester(){
        Node<Course_part1> current;
        current= (Node<Course_part1>) gnode(nextNum-1);

        semester1=current.data.getSemester();
        System.out.println(semester1);

    }
}