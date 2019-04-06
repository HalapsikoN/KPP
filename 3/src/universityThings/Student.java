package universityThings;

import univercityActions.StudentDuties;

import java.util.Objects;
import java.util.Random;

public class Student implements StudentDuties {

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

    @Override
    public boolean visitLecture(Lecture lecture){
        boolean result=false;
        Random random=new Random();

        String themeOfLecture=lecture.getThemeOfLecture();

        if (themeOfLecture.length()<random.nextInt(20) && themeOfLecture.length()>0){
            result=true;
        }

        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return name.equals(student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
