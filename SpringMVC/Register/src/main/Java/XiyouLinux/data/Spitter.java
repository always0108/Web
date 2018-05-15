package XiyouLinux.data;



import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class Spitter {

    @NotNull
    @Size(min = 5, max = 16, message = "{firstname.size}")
    private String firstname;

    @NotNull
    @Size(min = 5, max = 25, message = "{lastname.size}")
    private String lastname;

    @NotNull
    @Size(min = 2, max = 30, message = "{username.size}")
    private String username;

    @NotNull
    @Size(min = 2, max = 30, message = "{password.size}")
    private String password;


    public Spitter(){

    }

    public Spitter(String firstname,String lastname,String username,String password){
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }


}
