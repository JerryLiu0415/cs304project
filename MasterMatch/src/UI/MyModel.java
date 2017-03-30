package UI;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

/**
 * Created by Jerry on 2017-03-28.
 */
// class that extends the AbstractTableModel

public class MyModel extends AbstractTableModel {
    public ArrayList<ArrayList<String>> data;
    public ArrayList<String> cols;

    public MyModel(ArrayList<ArrayList<String>> data, ArrayList<String> header) {
        this.data = data;
        this.cols = header;
    }


    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return cols.size();
    }

    @Override
    public String getValueAt(int rowIndex, int columnIndex) {
        return data.get(rowIndex).get(columnIndex);
    }

    @Override
    public String getColumnName(int column) {
        return cols.get(column);
    }

    public void addRow(ArrayList<String> row) {
        data.add(row);
    }




}
