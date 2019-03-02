/**
 * This class contains all the features to be kept for a course.
 */
public class Course_part1 {
    private int semester;
    private String code;
    private String name;
    private int ects;
    private int gtuCredits;
    private String htl;


    /**
     *This constructor initializes instance variable.
     */
    public Course_part1(){
        semester=0;
        code="empty";
        name="empty";
        ects=-1;
        gtuCredits=-1;
        htl="empty";

    }

    /**
     *Creates a new course.
     * @param semester to decide which semester is chosen
     * @param code to add which code is assigned.
     * @param name to add which course name is assigned.
     * @param ects to add which ects is determined.
     * @param gtuCredits to add which gtu credit is determined.
     * @param htl to add which htl is determined.
     */
    public Course_part1(int semester,String code,String name,int ects,int gtuCredits,String htl){
        if(semester>0&&semester<9)//checks whether the choosen semester is between 1 and 8
            setSemester(semester);
        setCode(code);
        setName(name);
        if(ects>0&&ects<31)//checks whether the  ects is between 1 and 30 (a semester is approximately 30 credicts sum of the all courses' credits)
            setEcts(ects);
        if(gtuCredits>0&&gtuCredits<31)//checks whether the gtu credits is between 1 and 30
            setGtu_credits(gtuCredits);
        setHtl(htl);
    }

    /**
     *
     * @return semester : gets semester
     */
    public int getSemester() {
        return semester;
    }

    /**
     *
     * @param semester : sets the curriculum semester
     */
    public void setSemester(int semester) {

        this.semester = semester;
    }

    /**
     *
     * @return code : gets the course of code
     */
    public String getCode() {
        return code;
    }

    /**
     *
     * @param code : sets the assigned code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     *
     * @return name : gets the course name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name : sets the course name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return ects : gets number of ects credits is choosen lecture
     */
    public int getEcts() {
        return ects;
    }

    /**
     *
     * @param ects sets number of ects is choosen lecture
     */
    public void setEcts(int ects) {
        this.ects = ects;
    }

    /**
     *
     * @return gtuCredits : gets number of credits is choosen lecture
     */
    public int getGtu_credits() {
        return gtuCredits;
    }

    /**
     *
     * @param gtuCredits : sets number of credits is choosen lecture
     */
    public void setGtu_credits(int gtuCredits) {
        this.gtuCredits = gtuCredits;
    }

    /**
     *
     * @return htl : gets number of courses and applications
     */
    public String getHtl() {
        return htl;
    }

    /**
     *
     * @param htl :sets number of courses and applications
     */
    public void setHtl(String htl) {
        this.htl = htl;
    }

    /**
     *toString method: prints all the features to be kept for a course.
     */
    @Override
    public String toString() {
        return "Course--->{\n|\n" +
                "| semester-->" + semester +"\n"+
                "| code-->" + code +"\n"+
                "| name-->" + name +"\n"+
                "| ects-->" + ects +"\n"+
                "| gtuCredits-->" + gtuCredits +"\n"+
                "| htl-->" + htl +"\n"+
                "|\n}"+"\n";
    }

}
