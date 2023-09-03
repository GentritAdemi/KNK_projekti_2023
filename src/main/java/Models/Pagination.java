package Models;

import java.util.ArrayList;

public class Pagination {

    private int page;
    private int size;

    Pagination(int page,int size) {
        this.page = page;
        this.size = size;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    private String getSqlQuery() {
        return "Limit ? Offset ?";
    }

    public ArrayList<Object> getSQLParams(){
        int offset = (this.getPage() - 1) * this.getSize();
        ArrayList<Object> params = new ArrayList<>();
        params.add(this.getSize());
        params.add(offset);
        return params;
    }
}
