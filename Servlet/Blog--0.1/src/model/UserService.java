package model;

import model.Blah;

import java.io.*;
import java.util.*;

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
    
    public List<Blah> getBlahs(Blah blah) throws IOException{
        File border = new File(USERS+"/"+blah.getUsername());
        String[] txts = border.list(filenameFilter);

        Map<Date,String> messages = new TreeMap<Date, String>(comparator);
        for(String txt: txts){
            BufferedReader reader = new BufferedReader(new InputStreamReader
                    (new FileInputStream(USERS+"/"+blah.getUsername()+"/"+txt),"UTF-8"));
            String text = null;
            StringBuilder builder = new StringBuilder();
            while ((text = reader.readLine() )!= null){
                builder.append(text);
            }
            Date date = new Date(Long.parseLong(txt.substring(0,txt.indexOf(".txt"))));
            messages.put(date,builder.toString());
        }

        List<Blah> blahs = new ArrayList<Blah>();
        for(Date date:messages.keySet())
        {
            String txt = messages.get(date);
            blahs.add(new Blah(blah.getUsername(),date,txt));
        }

        return blahs;
    }

    public void addBlah(Blah blah) throws IOException{
        String file = USERS + "/" + blah.getUsername() + "/" + blah.getDate().getTime() + ".txt";
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file),"UTF-8"));
        writer.write(blah.getTxt());
        writer.close();
    }

    public void deleteBlah(Blah blah){
        File file = new File(USERS + "/" + blah.getUsername() + "/" + blah.getDate().getTime() + ".txt");
        if(file.exists()){
            file.delete();
        }
    }
}
