import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Vector;

public class Curriculum_part1 implements CourseStructureDiagram_part1{
    private final String CSVFILE;

    public int getCourseNumber() {
        return courseNumber;
    }

    private int courseNumber;

    public List<Course_part1> getCourseData() {
        return courseData;
    }

    private List<Course_part1> courseData;
    private Course_part1 course;

    /**
     *Initilialize instance variable and reads courses from file
     */
    public Curriculum_part1() throws IOException {
        this.courseData=new LinkedList<Course_part1>();
        CSVFILE="curriculum.csv";
        course = new Course_part1();
        this.courseNumber=readCurriculum();
    }

    /**
     * Takes String filename if there is different curriculum.
     * Reads courses.
     * adds them.
     * @param fileName
     */
    public Curriculum_part1(String fileName) throws IOException {
        this.courseData=new LinkedList<Course_part1>();
        CSVFILE=fileName;
        course = new Course_part1();
        this.courseNumber=readCurriculum();

    }
    /**
     * Reads the courses in csv file.
     * @return num: total number of courses.
     * @throws IOException for an error that may be related to the file.
     */
    @Override
    public int readCurriculum() throws IOException {
        BufferedReader reader;
        String lineControl;
        String [] dividedLine;
        int num=0;
        reader= new BufferedReader(new FileReader(CSVFILE));
        lineControl=reader.readLine();//reads first title line
        while((lineControl=reader.readLine())!=null){//end of the file
            dividedLine=lineControl.split(";");//divides Strings by ;
            course = new Course_part1();//initialize course object. add qualifications of course
            course.setSemester(Integer.parseInt(dividedLine[0]));
            course.setCode(dividedLine[1]);
            course.setName(dividedLine[2]);
            course.setEcts(Integer.parseInt(dividedLine[3]));
            course.setGtu_credits(Integer.parseInt(dividedLine[4]));
            course.setHtl(dividedLine[5]);
            num++;
            courseData.add(course);
        }
        return num;
    }

    /**
     * Firstly Checks the choosen semester is legal
     * Finally add courses which are choosen semester Course_part1[] array.
     * @param semester to decide which semester is chosen.
     * @return Course_part1[] array: total course in choosen semestr.
     */
    @Override
    public Course_part1[] listSemesterCourses(int semester) {
        if(semester<1||semester>8)// checks the choosen semester is legal
            throw new NoSuchElementException("There is no matching semester");

        Vector<Course_part1> matched= new Vector<>();//to keep Course given semester.

        for(int i=0;i<courseData.size();i++)
            if(semester==courseData.get(i).getSemester())
                matched.add(courseData.get(i));//adds matching course is choosen semester
        if(matched.size()==0)//if size 0 there is no course is choosen semester.
            throw new NoSuchElementException();

        Course_part1 [] semesterCourses=new Course_part1[matched.size()];//creates Array to return matching course type of Course_part1
        for(int i=0;i<matched.size();i++) {
            semesterCourses[i] = matched.get(i);
            System.out.println(semesterCourses[i].toString());//shows matching course

        }
        return semesterCourses;
    }


    /**
     * takes index and if indexs are legal adds them Course_part1[] array.
     * @param start_index : first index of course
     * @param last_index : last index of course
     * @return :Course_part1[] array: total course in between of start_index and last_index.
     */
    @Override
    public Course_part1[] getByRange(int start_index, int last_index) {
        int num=last_index-start_index;//assings sum of choosen index range
        if(start_index<0||last_index<0||start_index>courseNumber||last_index>courseNumber||courseNumber==0||start_index>last_index)
            //checks indexs are legal
            throw new NoSuchElementException("Wrong input in getByRange!!!!!!");

        Vector<Course_part1> matched =new Vector<>();//to keep Course between start_index and last_index.

        for(int i=0;i<=(num);i++,start_index++)//adds course in choosen index
            matched.add(courseData.get(start_index));

        Course_part1 [] getByCourse=new Course_part1[num+1];//creates Array to return matching course type of Course_part1
        for(int i=0;i<matched.size();i++) {
            getByCourse[i] = matched.get(i);
            System.out.println(getByCourse[i].toString());//shows matching course
        }
        return getByCourse;
    }

    /**
     * Creates a new course.
     * @param psemester to decide which semester is chosen
     * @param pcode to add which code is assigned.
     * @param pname to add which course name is assigned.
     * @param pects to add which ects is determined.
     * @param pgtuCredits to add which gtu credit is determined.
     * @param phtl to add which htl is determined.
     * @return
     */
    @Override
    public boolean addCourse(int psemester, String pcode, String pname, int pects, int pgtuCredits, String phtl) {
        if(psemester<0||psemester>8||pects<0||pgtuCredits<0||pects>30||pgtuCredits>30)//checks inputs are legal if not throws exception
            throw new IllegalArgumentException();
        for(int i=0;i<courseNumber;i++)
            if(courseData.get(i).getSemester()==psemester&&pcode.compareTo(courseData.get(i).getCode())==0&&pname.compareTo(courseData.get(i).getName())==0)
                //finds choosen semester and checks they are same code.
                return false;
        Course_part1 cr=new Course_part1(psemester, pcode, pname, pects,  pgtuCredits, phtl);// creates Course_part1 object and creates new course
        int sem=0;
        for(int i=0;i<courseNumber;i++)
            if(cr.getSemester()==courseData.get(i).getSemester()) {
                sem = i;
                break;
            }
        courseData.add(sem,cr);// add course
        System.out.println(cr);
        return true;
    }

    /**
     *Takes a code compare the All course codes and add a Course_part1[]
     * @param code : takes codes and checks whether if true.
     * @return Course_part1[] : returns the choosen codes' course(some codes are equal(xxx xxx))
     */
    @Override
    public Course_part1[] getByCode(String code) {
        Vector<Course_part1> matched =new Vector<>();//to keep Course matching codes.
        for(int i=0;i<courseData.size();i++)//for loop continue size of course
            if((code.toUpperCase()).compareTo(courseData.get(i).getCode())==0)//checks whether there is a matching course code
                matched.add(courseData.get(i));// adds matching course
        if(matched.size()==0)//if size 0 there is no matching course throws exception
            throw new NoSuchElementException("There is no matching code!!!");

        Course_part1 [] getByCourse=new Course_part1[matched.size()];//creates Array to return matching course type of Course_part1
        for(int i=0;i<matched.size();i++) {
            getByCourse[i] = matched.get(i);
            System.out.println(getByCourse[i].toString());//shows matching course
        }

        return getByCourse;
    }

    /**
     *prints All courses(Curriculum)
     */
    @Override
    public void printCourses() {
        String leftAlignFormat = "| %-10s | %-13s | %-62s | %-13s | %-13s |  %-13s |%n";
        System.out.println("                                              Course Structure Diagram with Credits (Curriculum)\n");
        System.out.println("----------------------------------------------------------------------------------------" +
                "--------------------------------------------------------");
        System.out.println("|  Semester  |  Course code  |                           Course title                         |  ECTS credits |" +
                "  GTU credits  |  H+T+L         |");
        System.out.println("----------------------------------------------------------------------------------------" +
                "--------------------------------------------------------");
        for (int i = 0; i < courseData.size(); i++) {
            System.out.format(leftAlignFormat, courseData.get(i).getSemester(),courseData.get(i).getCode(),courseData.get(i).getName(),courseData.get(i).getEcts(),courseData.get(i).getGtu_credits()
                    ,courseData.get(i).getHtl());
        }
        System.out.println("----------------------------------------------------------------------------------------" +
                "--------------------------------------------------------");
    }
}
