import Util.MenuUtil;
import Util.UserUtil;
import beans.User;
import config.Config;
import config.Initialization;

public class Main {
public static Config config =null;

    public static void main(String[] args) {
        User user = UserUtil.requireInputsAndLogin(1,true);
        Initialization.initializeConfig(user);
        System.out.println("Hello, " + user.getUsername());
        MenuUtil.showMenuInfinite();

    }
}
