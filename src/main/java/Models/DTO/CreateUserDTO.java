package Models.DTO;

public class CreateUserDTO {

    private String salted_password;

    private String username;

    private String hash_password;



    public CreateUserDTO(String username,String salted_password,  String hash_password) {
        this.username = username;
        this.salted_password = salted_password;
        this.hash_password = hash_password;

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSalted_password() {
        return salted_password;
    }

    public void setSalted_password(String salted_password) {
        this.salted_password = salted_password;
    }

    public String getHash_password() {
        return hash_password;
    }

    public void setHash_password(String hash_password) {
        this.hash_password = hash_password;
    }


}
