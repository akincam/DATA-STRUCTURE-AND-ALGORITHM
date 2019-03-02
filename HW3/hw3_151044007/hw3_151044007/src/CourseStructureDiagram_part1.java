import java.io.IOException;

public interface CourseStructureDiagram_part1 {
    /**
     * Reads the courses in csv file.
     * @return num: total number of courses.
     * @throws IOException for an error that may be related to the file.
     */
    public int readCurriculum() throws IOException;

    /**
     * Firstly Checks the choosen semester is legal
     * Finally add courses which are choosen semester Course_part1[] array.
     * @param semester to decide which semester is chosen.
     * @return Course_part1[] array: total course in choosen semestr.
     */
    public Course_part1[] listSemesterCourses (int semester);

    /**
     * takes index and if indexs are legal adds them Course_part1[] array.
     * @param start_index : first index of course
     * @param last_index : last index of course
     * @return :Course_part1[] array: total course in between of start_index and last_index.
     */
    public Course_part1[] getByRange(int start_index, int last_index);

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
    public boolean addCourse(int psemester,String pcode,String pname,int pects,int pgtuCredits,String phtl);

    /**
     *Takes a code compare the All course codes and add a Course_part1[]
     * @param code : takes codes and checks whether if true.
     * @return Course_part1[] : returns the choosen codes' course(some codes are equal(xxx xxx))
     */
    public Course_part1[] getByCode(String code);

    /**
     *prints All courses(Curriculum)
     */
    public void printCourses();

}
