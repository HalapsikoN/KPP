package universityThings;

import java.util.Objects;

public class Lecture extends Class {
    private String themeOfLecture;

    public Lecture(String subject, String themeOfLecture) {
        super(subject);
        this.themeOfLecture = themeOfLecture;
    }

    public String getThemeOfLecture() {
        return themeOfLecture;
    }

    public void setThemeOfLecture(String themeOfLecture) {
        this.themeOfLecture = themeOfLecture;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lecture lecture = (Lecture) o;
        return Objects.equals(themeOfLecture, lecture.themeOfLecture);
    }

    @Override
    public int hashCode() {
        return Objects.hash(themeOfLecture);
    }
}
