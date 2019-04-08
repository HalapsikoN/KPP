package customExceptions;

public class NotEnoughSubjects extends Exception {

    public NotEnoughSubjects(){
        super("Number of subjects must be tha same as lectures");
    }
}
