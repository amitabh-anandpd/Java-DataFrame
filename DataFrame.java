import java.util.*;

class DataFrame {
    private List<String> columns;
    private List<String> rows;
    private List<List<Object>> data;
    private List<Object> colType;
    
    private boolean checkRowSize(List<Object> row){
        if(this.data.get(0).size()!=row.size())
            return false;
        for(int i=0;i<row.size();i++){
            if(detectType(row.get(i))!=this.colType.get(i)){
                return false;
            }
        }
        return true;
    }
    private Class<?> detectType(Object obj){
        return (obj != null) ? obj.getClass() : null;
    }

    private static void to_csv(List<List<Object>> fulldata, List<Object> cols, String filepath)throws IOException {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filepath))){
            StringBuilder builder = new StringBuilder();
            for(int i = 0; i < cols.size(); i++){
                builder.append(cols.get(i).toString());
                if(i < cols.size() - 1)
                    builder.append(",");
            }
            writer.write(builder.toString());
            writer.newLine();
            for(List<Object> row : fulldata){
                StringBuilder nbuilder = new StringBuilder();
                for(int i = 0; i < row.size(); i++){
                    nbuilder.append(row.get(i).toString());
                    if(i < row.size() - 1)
                        nbuilder.append(",");
                }
                writer.write(nbuilder.toString());
                writer.newLine();
            }
        }
    }
    
    DataFrame() {
        this.columns = new ArrayList<>();
        this.rows = new ArrayList<>();
        this.data = new ArrayList<>();
        this.colType = new ArrayList<>();
    }

    DataFrame(List<List<Object>> data){
        this.data = data;
        for(int i=0;i<this.data.get(0).size();i++){
            this.columns.add(i+"");
            this.colType.add(detectType(this.data.get(0).get(i)));
        }
    }

    DataFrame(List<List<Object>> data,  List<String> columns) {
        if(data.get(0).size()!=columns.size()){
            return;
        }
        this.columns = columns;
        this.data = data;
        for(int i=0;i<this.data.get(0).size();i++){
            this.colType.add(detectType(this.data.get(0).get(i)));
        }
    }

    DataFrame(List<List<Object>> data,  List<String> rows, List<String> columns) {
        if(data.get(0).size()!=columns.size()){
            return;
        }
        this.columns = columns;
        this.data = data;
        for(int i=0;i<this.data.get(0).size();i++){
            this.colType.add(detectType(this.data.get(0).get(i)));
        }
    }

    void newRow(List<Object> rowData) {
        if(!checkRowSize(rowData)){
            return;
        }
        this.data.add(rowData);
        if(!this.rows.isEmpty()){
            this.rows.add((data.size()-1)+"");
        }
    }

    void newRow(String rowName, List<Object> rowData) {
        if(!checkRowSize(rowData)){
            return;
        }
        this.rows.add(rowName);
        this.data.add(rowData);
    }

    void nameRows(List<String> rows) {
        if(rows.size()!=this.data.size()){
            return;
        }
        for(int i=0;i<rows.size();i++)
            this.rows.add(rows.get(i));
    }

    void newColumn(String columnName, List<Object>  columns) {
        if(columns.size()!=this.data.size())
            return;
        this.columns.add(columnName);
        this.colType.add(detectType(columns.get(0)));
        for(int i=0;i<this.data.size();i++){
            data.get(i).add(columns.get(i));
        }
    }

    void newColumn(List<Object>  columns) {
        if(columns.size()!=this.data.size())
            return;
        this.columns.add("newColumn"+this.columns.size());
        this.colType.add(detectType(columns.get(0)));
        for(int i=0;i<this.data.size();i++){
            data.get(i).add(columns.get(i));
        }
    }

    void renameColumns(List<String>  columns) {
        if(columns.size()!=this.columns.size())
            return;
        this.columns = columns;
    }

    void newEmptyColumn(String columnName) {
        columns.add(columnName);
        for(int i=0;i<this.data.size();i++){
            data.get(i).add(null);
        }
        this.colType.add(detectType(columns.get(0)));
    }

    int count(){
        return this.data.size();
    }

    List<List<Object>> head(){
        List<List<Object>> head = new ArrayList<>();
        for(int i=0;i<5;i++)
            head.add(this.data.get(i));
        return head;
    }
    List<List<Object>> head(int n){
        if(n<=0 || n>this.data.size())
            return null;
        if(n==this.data.size())
            return this.data;
        List<List<Object>> head = new ArrayList<>();
        for(int i=0;i<n;i++)
        head.add(this.data.get(i));
        return head;
    }

    List<List<Object>> tail(){
        List<List<Object>> tail = new ArrayList<>();
        for(int i=0;i<5;i++)
            tail.add(this.data.get(this.data.size()-5+i));
        return tail;
    }
    List<List<Object>> tail(int n){
        if(n<=0 || n>this.data.size())
            return null;
        if(n==this.data.size())
            return this.data;
        List<List<Object>> head = new ArrayList<>();
        for(int i=0;i<n;i++)
        head.add(this.data.get(this.data.size()-n+i));
        return head;
    }

    Object get(int row, int column) {
        if(this.rows.size()<=row || this.columns.size()<=column)
        return null;
        return this.data.get(row).get(column);
    }
    Object get(String row, String column){
        if(!this.rows.contains(row) || !this.columns.contains(column))
        return null;
        return this.data.get(this.rows.indexOf(row)).get(this.columns.indexOf(column));
    }
    Object get(int row, String column){
        if(this.rows.size()<=row || !this.columns.contains(column))
        return null;
        return this.data.get(row).get(this.columns.indexOf(column));
    }
    Object get(String row, int column){
        if(!this.rows.contains(row) || this.columns.size()<=column)
        return null;
        return this.data.get(this.rows.indexOf(row)).get(column);
    }

    private void iterate(List<String> over, int size){
        for(int i=0;i<size;i++){
            System.out.print(over.get(i)+"\t");
        }
        System.out.println();
    }
    private void iterate(int index, List<Object> over, int size){
        if(index>9)
        System.out.print(index+"\t");
        else
        System.out.print(index+" \t");
        for(int i=0;i<size;i++){
            System.out.print(over.get(i)+"\t");
        }
        System.out.println();
    }
    void display() {
        iterate(columns, columns.size());
        for(int i=0;i<data.size();i++)
        iterate(i, data.get(i), columns.size());
    }
}
