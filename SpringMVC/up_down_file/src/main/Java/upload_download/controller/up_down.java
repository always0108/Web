package upload_download.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import upload_download.model.User;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;


@Controller
@RequestMapping("/")
public class up_down {

    //展示表单
    @RequestMapping(value = "/upload", method = RequestMethod.GET)
    public ModelAndView student() {
        return new ModelAndView("upload", "user", new User());
    }

    //上传
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String processRegistration(@ModelAttribute("user") User user, Model model) {

        MultipartFile profilePicture = user.getImage();
        try{
            File dest = new File("/tmp/uploads/" + profilePicture.getOriginalFilename());
            if(!dest.exists()){
                dest.createNewFile();
            }
            profilePicture.transferTo(dest);
        }catch (IOException ex){
            ex.printStackTrace();
            return "error";
        }

        //将用户添加到model
        model.addAttribute("user", user);
        return "userInfo";
    }

    //下载
    @RequestMapping(value="/download",method = RequestMethod.GET)
    public ResponseEntity<byte[]> download(HttpServletRequest request,
                                           @RequestParam("filename") String filename,
                                           Model model)throws Exception {

        File file = new File("/tmp/uploads/" + filename);
        byte[] body = null;
        InputStream is = new FileInputStream(file);
        body = new byte[is.available()];
        is.read(body);
        HttpHeaders headers = new HttpHeaders();
        //通知浏览器以attachment（下载方式）打开图片,注意转码,防止出现乱码
        headers.setContentDispositionFormData("attachment", new String(filename.getBytes("utf-8"), "ISO8859-1"));
        //application/octet-stream ： 二进制流数据（最常见的文件下载）。
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return new ResponseEntity<byte[]>(body, headers, HttpStatus.CREATED);
    }
}
