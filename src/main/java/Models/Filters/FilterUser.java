package Models.Filters;

import java.util.List;

public class FilterUser {
    private String username;

    public FilterUser(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsernameQuery() {
        return "OR like %?%";
    }
    public String getFilterQuery(){
        return null;
    }

    public List<Object> getFilterParams(){
        return null;
    }
}

