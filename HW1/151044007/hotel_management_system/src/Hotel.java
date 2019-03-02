import java.util.Scanner;

/**
 *The Hotel class holds only rooms.
 * rooms was created with the help of Room class.
 */
public class Hotel {

    private int roomNumber;
    private Room[] rooms;
    private int roomID;
    private static final  int DEFAULTROOMNUM = 10;
    private static final  String NOBOOK = "NO BOOK";
    private static final  String NOCHECK ="NO CHECK-IN";
    private static final  String NONAME ="NO NAME";
    private static final  String NOSURNAME="NO SURNAME";
    private static final  String NOID ="NO ID";
    private static final  String NODATE ="00/00/0000";

    /**
     *Takes room number default 10 and initialize room array.
     * InıtializeRooms method is called to initialize rooms.
     */
    public Hotel() {
        roomNumber = DEFAULTROOMNUM;
        rooms = new Room[roomNumber];
        for(int i=0;i<roomNumber;i++)
            rooms[i] = new Room();
        InitializeRooms(roomNumber);
    }
    public Room[] getRooms() {
        return rooms;
    }
    /**
     *takes the total number of rooms as a parameter(integer type).
     *InıtializeRooms method is called to initialize rooms.
     *if parametre is not legal; Takes room number default 10 and initialize room array.
     * InıtializeRooms method is called to initialize rooms.
     *
     * @param roomNum
     */
    public Hotel(int roomNum) {
        if (setRoomNumber(roomNum)) {
            rooms = new Room[roomNumber];
            for (int i = 0; i < roomNumber; i++)
                rooms[i] = new Room();
            InitializeRooms(roomNumber);
        }
        else {
            rooms = new Room[DEFAULTROOMNUM];
            for (int i = 0; i < DEFAULTROOMNUM; i++)
                rooms[i] = new Room();
            InitializeRooms(roomNumber);
        }
    }

    /**
     * Takes index(type of integer)
     * return rooms array's index
     * @param i
     * @return Room
     */
    public Room getRooms(int i) {
        return rooms[i];
    }

    /**
     * return total room number.
     * @return int
     */
    public int getRoomNumber() {
        return roomNumber;
    }

    /**
     *Takes total room number,assings roomNumber(private instance variable)
     * return true
     * @param num
     * @return boolean
     */
    public boolean setRoomNumber(int num) {
        this.roomNumber = num;
        return true;

    }

    /**
     * Returns room id
     * @return int
     */
    public int getRoomID(){
        return roomID;
    }

    /**
     *Use for loop. Control statement is(number parametr) total roomNumber
     * initialize room id,name,surname,id,checkin,isdate ifinishdate for all room.
     * ınitialize values likes "empty"
     * @param number
     */
    private void InitializeRooms(int number) {
        roomID=1;
        for (int i = 0; i < number; i++) {
            rooms[i].setRoomId(roomID);
            rooms[i].setName(NONAME);
            rooms[i].setSurname(NOSURNAME);
            rooms[i].setId(NOID);
            rooms[i].setIsBook(NOBOOK);
            rooms[i].setIsCheckin(NOCHECK);
            rooms[i].setIsDate(NODATE);
            rooms[i].setIsFinishDate(NODATE);
            roomID +=1;
        }
    }

    /**
     * This class is inner class.
     *to keep the knowledge of each room.
     */
    public class Room {
        private int roomId=1;
        private String name;
        private String surname;
        private String id;
        private String isBook;
        private String isCheckin;
        private String isDate;
        private String isFinishDate;
        /**
         *return checkout date for total check in day.
         * @return String
         */
        public String getIsFinishDate() {
            return isFinishDate;
        }

        /**
         * set checkout date for total check in day.
         * @param isFinishDate
         */
        public void setIsFinishDate(String isFinishDate) {
            this.isFinishDate = isFinishDate;
        }

        /**
         *return getdate
         * @return String
         */
        public String getIsDate() {
            return isDate;
        }

        /**
         *take string date parametr and assigns this.
         * @param isDate
         */
        public void setIsDate(String isDate) {
            this.isDate = isDate;
        }


        /**
         *return room id type integer
         * @return int
         */
        public int getRoomId() {
            return roomId;
        }

        /**
         * set room id and assings roomId
         * @param roomId
         */
        public void setRoomId(int roomId) {
            this.roomId = roomId;
        }

        /**
         *return name hotel's the room's book or check-in user
         * @return String
         */
        public String getName(){
            return this.name;
        }

        /**
         * set name
         * @param name
         */
        public void setName(String name){
            this.name=name;
        }

        /**
         *return surname hotel's the room's book or check-in user
         * @return String
         */
        public String getSurname() {
            return surname;
        }

        /**
         *set surname
         * @param surname
         */
        public void setSurname(String surname) {
            this.surname = surname;
        }

        /**
         *eturn user id hotel's the room's book or check-in user
         * @return String
         */
        public String getId() {
            return id;
        }

        /**
         * set id
         * @param id
         */
        public void setId(String id) {
            this.id = id;
        }

        /**
         *return room is book(date) or not
         * @return String
         */
        public String getIsBook() {
            return isBook;
        }

        /**
         *set isBook
         * @param isBook
         */
        public void setIsBook(String isBook) {
            this.isBook = isBook;
        }

        /**
         *return whether check in
         * @return String
         */
        public String getIsCheckin() {
            return isCheckin;
        }

        /**
         *set check in status
         * @param isCheckin
         */
        public void setIsCheckin(String isCheckin) {
            this.isCheckin = isCheckin;
        }
    }
}
