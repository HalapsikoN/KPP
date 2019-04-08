package customExceptions;

public class HugeLectureSize extends Exception{

    public HugeLectureSize(){
        super("Max size of lectures is 3, sorry");
    }
}
