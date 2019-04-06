package graphicElements;

import javafx.geometry.Insets;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

public class GridPaneCreator {


    public GridPane createGridPane(){
        GridPane gridPane=new GridPane();
        gridPane.setHgap(3);
        gridPane.setVgap(3);
        gridPane.setPadding(new Insets(0,3,0,3));

        for (int i=0; i<(int)2; ++i) {
            ColumnConstraints column = new ColumnConstraints();
            column.setPercentWidth(100 / 2);
            gridPane.getColumnConstraints().add(column);
        }

        for (int i=0; i<(int)5; ++i) {
            RowConstraints row = new RowConstraints();
            row.setMinHeight(30);
            //row.setMaxHeight(50);
            //row.setPercentHeight(100/3);
            gridPane.getRowConstraints().add(row);
        }

        for (int i=6; i<(int)30; ++i) {
            RowConstraints row = new RowConstraints();
            /*if((i+2)%4==0) {
                row.setMinHeight(50);
            } else {
                row.setMinHeight(30);
            }*/
            //row.setMaxHeight(50);
            //row.setPercentHeight(100/20);
            gridPane.getRowConstraints().add(row);
        }

        return gridPane;
    }
}
