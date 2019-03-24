package universityThings;

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
}
