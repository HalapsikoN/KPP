package graphicElements;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import universityThings.*;

import java.util.HashMap;
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

    private void handleButton(GridPane gridPane) {
        TextField lectureField = (TextField) gridPane.getChildren().get(3);
        TextField subject1Field = (TextField) gridPane.getChildren().get(1);
        TextField teacherField = (TextField) gridPane.getChildren().get(5);
        //TextField subject2Field=(TextField) gridPane.getChildren().get(7);
        TextField studentField = (TextField) gridPane.getChildren().get(7);

        String clear=" ";
        for (int j=11; j<50; ++j){
            Label label = (Label) gridPane.getChildren().get(j);
            label.setText(clear);
        }

        University university = new University();

        String string = lectureField.getText();
        String string1 = subject1Field.getText();
        university.makePlanOfClasses(string1, string);

        if (string.isEmpty() || string1.isEmpty())
            return;

        string = teacherField.getText();
        string1 = subject1Field.getText();
        university.hireTeacher(string, string1);

        if (string.isEmpty() || string1.isEmpty())
            return;

        string = studentField.getText();
        university.enrollStudent(string);

        if (string.isEmpty())
            return;

        List<Lecture> listLecture = university.getLectureList();
        List<Student> listStudent = university.getStudentList();
        List<Teacher> listTeacher = university.getTeacherList();


        Register teacherRegister = listTeacher.get(0).getRegister(listStudent, listLecture);
        Register headmanRegister = new Headman(listStudent.get(0).getName()).getRegister(listStudent, listLecture);

        int k;



       /* for(k=0;k<headmanRegister.getStringRegisters().size();++k){
            StringRegister stringRegister=headmanRegister.getStringRegisters().get(k);

            String output = "";
            for (int i = 0; i < listStudent.size(); ++i) {
                output += listStudent.get(i).getName();
                output += "\n";
            }
            String output2 = "";
            for (int i = 0; i < listStudent.size(); ++i) {
                output2 += (((boolean) stringRegister.getVisit().get(listStudent.get(i).getName())) ? "+" : "-");
                output2 += "\n";
            }
            Label label = (Label) gridPane.getChildren().get(11+k*4);
            label.setText(output);
            label = (Label) gridPane.getChildren().get(12+k*4);
            label.setText(output2);


        }
*/


        for (k = 0; k < listLecture.size() && k < 4; ++k) {
            Lecture lecture = listLecture.get(k);

            String output = "";
            for (int i = 0; i < listStudent.size(); ++i) {
                output += listStudent.get(i).getName();
                output += "\n";
            }
            String output2 = "";
            for (int i = 0; i < listStudent.size(); ++i) {
                output2 += (((boolean) headmanRegister.getStringRegisters().get(i).getVisit().get(lecture)) ? "+" : "-");
                output2 += "\n";
            }

            Label label = (Label) gridPane.getChildren().get(11 + k * 4);
            label.setText(output);
            label = (Label) gridPane.getChildren().get(12 + k * 4);
            label.setText(output2);

            label = (Label) gridPane.getChildren().get(13 + k * 4);
            label.setText("Lecture - " + lecture.getThemeOfLecture());
            if (k < listTeacher.size()) {
                String prepod = "Teacher - ";
                for (int i = 0; i < listTeacher.size(); ++i) {
                    if (lecture.getSubjectName().equals(listTeacher.get(i).getSubject().getSubjectName())) {
                        prepod += listTeacher.get(i).getName();
                        break;
                    }
                }
                label = (Label) gridPane.getChildren().get(14 + k * 4);
                label.setText(prepod);
            }
        }

        k = 14 + k * 4;
        k++;

        Label label = (Label) gridPane.getChildren().get(k++);
        label.setText("----------------------------------------Headman register(up)----------------------------------------");
        label = (Label) gridPane.getChildren().get(k++);
        label.setText("----------------------------------------Teacher register(down)--------------------------------------");

        for (k = 0; k < listLecture.size() && k < 4; ++k) {
            Lecture lecture = listLecture.get(k);

            String output = "";
            for (int i = 0; i < listStudent.size(); ++i) {
                output += listStudent.get(i).getName();
                output += "\n";
            }
            String output2 = "";
            for (int i = 0; i < listStudent.size(); ++i) {
                output2 += (((boolean) teacherRegister.getStringRegisters().get(i).getVisit().get(lecture)) ? "+" : "-");
                output2 += "\n";
            }

            label = (Label) gridPane.getChildren().get(29 + k * 4);
            label.setText(output);
            label = (Label) gridPane.getChildren().get(30 + k * 4);
            label.setText(output2);

            label = (Label) gridPane.getChildren().get(31 + k * 4);
            label.setText("Lecture - " + lecture.getThemeOfLecture());
            if (k < listTeacher.size()) {
                String prepod = "Teacher - ";
                for (int i = 0; i < listTeacher.size(); ++i) {
                    if (lecture.getSubjectName().equals(listTeacher.get(i).getSubject().getSubjectName())) {
                        prepod += listTeacher.get(i).getName();
                        break;
                    }
                }
                label = (Label) gridPane.getChildren().get(32 + k * 4);
                label.setText(prepod);
            }
        }
        k = 32+k*4;
        k++;

        label = (Label) gridPane.getChildren().get(k++);
        label.setText("-------------------------------------------------------------------------------------------------------");
        label = (Label) gridPane.getChildren().get(k++);
        label.setText("--------------------------------------------------------------------------------------------------------");


        //map.equals(map1);
        label = (Label) gridPane.getChildren().get(k++);
        label.setText("The registers of headman and teacher are");
        String output2 = (headmanRegister.equals(teacherRegister)) ? "the SAME" : "DIFFERENT";
        label = (Label) gridPane.getChildren().get(k++);
        label.setText(output2);


    }
}
