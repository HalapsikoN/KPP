package graphicElements;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import universityThings.*;

import java.util.List;
import java.util.Map;

public class ButtonCreator {
    public Button createButtonToCopyText(String text, GridPane gridPane){
        Button button=new Button(text);
        //для изменения раззмеров вместе со всем окном
        button.setMaxSize(Double.MAX_VALUE,Double.MAX_VALUE);
        button.setAlignment(Pos.CENTER);

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event){
                handleButton(gridPane);
            }
        });

        return button;
    }

    private void handleButton(GridPane gridPane){
        TextField lectureField=(TextField) gridPane.getChildren().get(3);
        TextField subject1Field=(TextField) gridPane.getChildren().get(1);
        TextField teacherField=(TextField) gridPane.getChildren().get(5);
        //TextField subject2Field=(TextField) gridPane.getChildren().get(7);
        TextField studentField=(TextField) gridPane.getChildren().get(7);


        University university=new University();

        String string=lectureField.getText();
        String string1=subject1Field.getText();
        university.makePlanOfClasses(string1, string);

        string=teacherField.getText();
        string1=subject1Field.getText();
        university.hireTeacher(string,string1);

        string=studentField.getText();
        university.enrollStudent(string);

        List<Lecture> listLecture=university.getLectureList();
        List<Student> listStudent=university.getStudentList();
        List<Teacher> listTeacher=university.getTeacherList();

        for(int k=0;k<listLecture.size();++k) {
            Lecture lecture = listLecture.get(k);
            Map register = new Headman(listStudent.get(0).getName()).checkPresence(listStudent, lecture);

            String output = "";
            for (int i = 0; i < listStudent.size(); ++i) {
                output += listStudent.get(i).getName();
                output += "\n";
            }
            String output2 = "";
            for (int i = 0; i < listStudent.size(); ++i) {
                output2 += (((boolean) register.get(listStudent.get(i).getName())) ? "+" : "-");
                output2 += "\n";
            }

            Label l = (Label) gridPane.getChildren().get(11+k*4);
            l.setText(output);
            l = (Label) gridPane.getChildren().get(12+k*4);
            l.setText(output2);

            l = (Label) gridPane.getChildren().get(13+k*4);
            l.setText("Lecture - "+lecture.getThemeOfLecture());
            if (k<listTeacher.size()) {
                String prepod = "Teacher - " + listTeacher.get(k).getName();
            /*for (int i = 0; i < listTeacher.size(); ++i) {
                if (lecture.getSubject().equals(listTeacher.get(i).getSubject().getSubject())) {
                    prepod+= listTeacher.get(i).getName();
                    break;
                }
            }*/
                l = (Label) gridPane.getChildren().get(14 + k * 4);
                l.setText(prepod);
            }
        }
    }
}
