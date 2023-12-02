package offense.management.user;

import java.util.Scanner;

public class UserController{
  public static int accountCheck(String username, String password){
      return User.isExist(username, password);
  }

  public static void addDataInFile(String name, String username, String password){
      User.addData(name, username, password);
  }
  public static String getName(){
    return User.getName();
  }

}

