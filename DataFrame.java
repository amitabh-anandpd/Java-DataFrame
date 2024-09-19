import java.util.*;

class DataFrame {
    List<String> columns;
    List<String> rows;
    List<Integer> index;
    List<List<Object>> data;

    private boolean checkDataSize(List<List<Object>> data){
        if(!this.data.isEmpty() && checkRowSize(data.get(0)))
            return  false;
        return true;
    }
    private boolean checkRowSize(List<Object> row){
        if(this.data.get(0).size()!=row.size())
            return false;
        return true;
    }
    DataFrame() {
        columns = new ArrayList<>();
        rows = new ArrayList<>();
        index = new ArrayList<>();
        data = new ArrayList<>();
    }

    DataFrame(List<List<Object>> data){
        if(!checkDataSize(data)){
            return;
        }
        this.data = data;
        for(int i=0;i<this.data.size();i++)
            this.index.add(i);
        for(int i=0;i<this.data.get(0).size();i++)
            this.columns.add(i+"");
    }

    DataFrame(List<List<Object>> data,  List<String> columns) {
        if(!checkDataSize(data)){
            return;
        }
        this.columns = columns;
        this.data = data;
        index.add(this.data.size()-1);
    }


    void addRow(List<Object> rowData) {
        if(!checkRowSize(rowData)){
            return;
        }
        data.add(rowData);
        index.add(data.size() - 1);
    }

    void setRow(List<String> rows) {
        if(rows.size()!=this.index.get(index.size()-1)){
            return;
        }
        for(int i=0;i<rows.size();i++)
            this.rows.add(rows.get(i));
    }

    void Columns(List<String>  columns) {
        if(columns.size()!=this.columns.size())
            return;
        this.columns = columns;
    }

    void addColumn(String columnName) {
        columns.add(columnName);
    }

    void display() {
        System.out.println("Columns: " + columns);
        System.out.println("Rows: " + rows);
        System.out.println("Index: " + index);
        System.out.println("Data: " + data);
    }
}
