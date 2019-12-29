import Util.FileUtil;
import Util.MenuUtil;
import Util.UserUtil;
import beans.Competitor;
import beans.User;
import config.Config;
import config.Initialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {
public static Config config =null;

    public static void main(String[] args) throws Exception {
//        User user = UserUtil.requireInputsAndLogin(1,true);
//        Initialization.initializeConfig(user);
//        System.out.println("Hello, " + user.getUsername());
//        MenuUtil.showMenuInfinite();
        Competitor[] competitors =new Competitor[2];
        competitors[0]=new Competitor("Sarkhan","Rasullu",25);
        competitors[1]=new Competitor("Fikret","Memmedov",26) ;
//        FileUtil.writeObjectToFile(competitors,"competitors.ser");
//       Competitor[] com=(Competitor[]) FileUtil.readObjectFromFile("competitors.ser");
//        System.out.println(com.length);
//        System.out.println(com);
//        FileOutputStream fos =new FileOutputStream("competitors.ser",true);
//        ObjectOutputStream oos = new ObjectOutputStream(fos);
//        for(int i=0;i<competitors.length;i++){
//            Competitor c= competitors[i];
//            oos.writeObject(c);
//        }


        FileUtil.writeObjectByObject(competitors,"competitors.ser",true);
       Object[] com = FileUtil.readObjectByObject(2,"competitors.ser");
//        Competitor[] com = new Competitor[2];
//        FileInputStream fis= new FileInputStream("competitors.ser");
//        ObjectInputStream input =new ObjectInputStream(fis);
//        for (int i=0;i<2;i++){
//            Object obj =input.readObject();
//            com[i]=(Competitor)obj;
//        }
        for(int i =0;i<com.length;i++){
            Competitor c= (Competitor) com[i];
            System.out.println(c.getName());
        }
    }
}
