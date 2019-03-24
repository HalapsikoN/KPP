package universityThings;

import java.util.Random;

public class Student {

    private String name;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean visitLecture(Lecture lecture){
        boolean result=false;
        Random random=new Random();

        String themeOfLeacture=lecture.getThemeOfLecture();

        if (themeOfLeacture.length()<random.nextInt(20) && themeOfLeacture.length()>0){
            result=true;
        }

        return result;
    }

}
