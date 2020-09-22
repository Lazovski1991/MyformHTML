import config.DataBaseConn;
import model.User;

import java.lang.reflect.InvocationTargetException;

public class Mail {
    public static void main(String[] args)   {
        DataBaseConn dataBaseConn = new DataBaseConn();
        User user = new User("Alexander", "vski1991@gml.com", "some text");
        dataBaseConn.addDatabase(user);
    }
}
