package sample.graphicElements;

import javafx.geometry.Insets;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;


public class GridPaneCreator {

    public GridPane createGridPane(double kol){
        GridPane gridPane=new GridPane();
        gridPane.setHgap(kol);
        gridPane.setVgap(kol);
        gridPane.setPadding(new Insets(0,kol,0,kol));

        for (int i=0; i<(int)kol; ++i) {
            ColumnConstraints column = new ColumnConstraints();
            column.setPercentWidth(100 / kol);
            gridPane.getColumnConstraints().add(column);
        }

        for (int i=0; i<(int)kol; ++i) {
            RowConstraints row = new RowConstraints();
            //row.setMinHeight(10);
            //row.setMaxHeight(50);
            row.setPercentHeight(100/kol);
            gridPane.getRowConstraints().add(row);
        }

        return gridPane;
    }
}
