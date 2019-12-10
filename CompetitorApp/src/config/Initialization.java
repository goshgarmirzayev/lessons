package config;

import Util.FileUtil;
import beans.User;

public class Initialization {
    public static Config config =null;
    public static void initializeConfig(User user){
        config =new Config(user);

        try{
            Object configObj = FileUtil.readObjectFromFile("config.ser");

            config = (Config)configObj;


        }catch (Exception ex){


        }



    }
    public static void refreshConfig(){
        FileUtil.writeObjectToFile(config,"config.ser");
    }

}
