//Package name
  package offense.management.user;

//Imports FileIO and Scanner
  import java.io.*;
  import java.util.Scanner;

class User{

static String userName = null;
  /**********************************************************************************
   * Update "user.dat" File with new Data from User
   * @Params name -> the user name
   * @Params username -> the user inputed username
   * @Params password -> the user inputed password
  ***********************************************************************************/
      static void addData(String name, String username, String password){
        try{

          //Write the data into the file
            FileWriter writer = new FileWriter("userdata.dat", true);
            writer.write(name + ",'," + username + ",'," + password + "\n");
            writer.close();

        }catch(Exception e){}
      }

  /**********************************************************************************
   * Check "user.dat" File if the Following data exist
   * @Params username   -> the user inputed username
   * @Params password   -> the user inputed password
   * return value integer
        0 == username doesn't exist
        1 == username exist but wrong password
        2 == both username and password exist
  ***********************************************************************************/
      static int isExist(String username, String password){
        int returnVal = 0;
        try{
          File file = new File("userdata.dat");
          file.createNewFile();
          Scanner scan = new Scanner(file);

          //set scanner to scan the whole content of the file
            scan.useDelimiter("\\Z");

          //Check if the "username" is contained in the file
            if(scan.next().contains(username)){
              returnVal = 1;

              Scanner scanIn = new Scanner(new File("userdata.dat"));
              while(scanIn.hasNextLine()){

                //Tokenized a line of data from file and store to part variable
                  String[] part = scanIn.nextLine().split(",',");

                //chack is password match for the acccount username
                  if(part[1].equals(username) && part[2].equals(password)){
                    returnVal = 2;
                    userName = part[0];
                    return returnVal;
                  }

              } 
            }

        }catch(Exception e){}
      
        return returnVal;
      }

      static String getName(){
        return userName;
      }


}