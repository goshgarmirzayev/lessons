package config;

import beans.Competitor;
import beans.User;

import java.io.Serializable;

public class Config implements Serializable {

    private  User user =null;
    private  Competitor[]competitors=null;
public Config (){

    }
public Config( User user){
    this.user =user;
    }

    public  void setUser(User user){
        System.out.println("set competitor called");
       this.user=user;
     Initialization.refreshConfig();
    }

        public  Competitor[] getCompetitors() {
            return competitors;
        }

        public  void setCompetitors(Competitor[] competitors) {
          this.competitors = competitors;
            System.out.println("set competitor called");
          Initialization.refreshConfig();
        }

        public  User getUser(){

        return user;
    }

}
