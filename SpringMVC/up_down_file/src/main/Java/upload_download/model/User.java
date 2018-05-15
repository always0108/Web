package upload_download.model;

import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

public class User implements Serializable {

    private String username;
    private MultipartFile image;


    public User(){

    }

    public User(String username,MultipartFile image){
        this.username = username;
        this.image = image;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

    public String getUsername() {
        return username;
    }

    public MultipartFile getImage() {
        return image;
    }
}
