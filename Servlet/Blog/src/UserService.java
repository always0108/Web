import java.io.*;
import java.util.Comparator;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

public class UserService {

    private String USERS;

    public  UserService(String USERS){
        this.USERS = USERS;
    }

    //判断用户名是否合法
    public boolean isInvalidUsername(String username){
        for(String file:new File(USERS).list()){
            if(file.equals(username)){
                return true;
            }
        }
        return false;
    }

    //创建用户
    public void createUserData(String email,String username,
                                String password) throws IOException {
        File userhome = new File(USERS + "/" + username);
        userhome.mkdir();
        BufferedWriter writer = new BufferedWriter(new FileWriter(userhome+"/profile"));
        writer.write(email + "\t" + password);
        writer.close();
    }

    //检查登录口令
    public boolean checkLogin(String username,String password) throws IOException{
        if(username!=null && password != null){
            for(String file : new File(USERS).list()){
                if(file.equals(username)){
                    BufferedReader reader = new BufferedReader
                            (new FileReader(USERS+"/"+file+"/profile"));
                    String passwd = reader.readLine().split("\t")[1];
                    if (passwd.equals(password)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    //过滤.txt文件名
    private class TxtFilenameFilter implements FilenameFilter {
        @Override
        public boolean accept(File dir,String name){
            return  name.endsWith(".txt");
        }
    }

    private TxtFilenameFilter filenameFilter = new TxtFilenameFilter();

    //TreeMap排序用,因为希望信息的日期越近的越靠前显示
    private class DateComparator implements Comparator<Date> {
        @Override
        public int compare(Date d1,Date d2){
            return -d1.compareTo(d2);
        }
    }

    private DateComparator comparator = new DateComparator();

    //以时间顺序创建消息Map
    public Map<Date,String> readMessage(String username) throws IOException{
        File border = new File(USERS+"/"+username);
        String[] txts = border.list(filenameFilter);

        Map<Date,String> messages = new TreeMap<Date, String>(comparator);
        for(String txt: txts){
            BufferedReader reader = new BufferedReader(new InputStreamReader
                    (new FileInputStream(USERS+"/"+username+"/"+txt),"UTF-8"));
            String text = null;
            StringBuilder builder = new StringBuilder();
            while ((text = reader.readLine() )!= null){
                builder.append(text);
            }
            Date date = new Date(Long.parseLong(txt.substring(0,txt.indexOf(".txt"))));
            messages.put(date,builder.toString());
        }
        return  messages;
    }

    //增加一条信息
    public void addMessage(String username,String blabla) throws IOException{
        String file = USERS + "/" + username + "/" + new Date().getTime() + ".txt";
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file),"UTF-8"));
        writer.write(blabla);
        writer.close();
    }

    //删除一条信息
    public void deleteMessage(String username,String message){
        File file = new File(USERS + "/" + username + "/" + message + ".txt");
        if(file.exists()){
            file.delete();
        }
    }
}
