import java.io.*;

/**
 *write and read room's information
 */
public  class WriteReadCsvFile {

    private int roomNumber;
    private PrintWriter writer;
    private BufferedReader reader;
    private String controlLine;
    private String [] lines;
    private StringBuilder string;
    private static final String NOBOOK = "NO BOOK";
    private static final String ROOMFILE = "RoomsInformation.csv";

    /**
     * write room's information
     *control value total room number
     * uses .csv file
     * informations split by ;
     * @param h
     * @throws IOException
     */
    public  void writeCsvFile(Hotel h) throws IOException {
        writer=new PrintWriter(new FileWriter(ROOMFILE));
        string = new StringBuilder();
        roomNumber=h.getRoomNumber();
        for(int i=0;i<roomNumber;i++){
            string.append(h.getRooms(i).getRoomId());
            string.append(";");
            string.append(h.getRooms(i).getName());
            string.append(";");
            string.append(h.getRooms(i).getSurname());
            string.append(";");
            string.append(h.getRooms(i).getId());
            string.append(";");
            string.append(h.getRooms(i).getIsBook());
            string.append(";");
            string.append(h.getRooms(i).getIsCheckin());
            string.append(";");
            string.append(h.getRooms(i).getIsDate());
            string.append(";");
            string.append(h.getRooms(i).getIsFinishDate());
            string.append("\n");
        }
        writer.write(string.toString());
        writer.close();

    }
    /**
     *reads room informations from file
     * if user guest not shows full room informations
     * @param h
     * @throws IOException
     */
    public void readCsvFile(Hotel h,char c) throws IOException {
        reader=new BufferedReader(new FileReader(ROOMFILE));
        System.out.println();
        while ((controlLine=reader.readLine())!=null){
            lines =controlLine.split(";");

            if(lines[4].compareTo(NOBOOK)!=0&&c=='g'||c=='G')
                System.out.println(lines[0]+"|"+lines[1]+"|"+lines[2]+"|"+
                        "------" +"|"+lines[4]+"|"+lines[5]+"|"+lines[6]+"|"+lines[7]+"\n");
            else
                System.out.println(lines[0]+"|"+lines[1]+"|"+lines[2]+"|"+
                               lines[3] +"|"+lines[4]+"|"+lines[5]+"|"+lines[6]+"|"+lines[7]+"\n");

        }
        reader.close();
    }

    /**
     * initializes file again to take success test result and to clear implementations in other tests
     * @param hotel
     * @throws IOException
     */
    public void clearFileToUnitTest(Hotel hotel) throws IOException{
        writeCsvFile(hotel);
    }
}
