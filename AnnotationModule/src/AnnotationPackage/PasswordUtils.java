package AnnotationPackage;

import java.util.List;

public class PasswordUtils {

    @UseCase(id=47,description = "Passwd must contain at least one numeric")
    public boolean validatePassword(String passwd){
       return true;
    }

    @UseCase(id=48)
    public String encryptPasswd(String passwd){
        return "";
    }

    @UseCase(id=49,description = "new passwords can't equal preivously used ones")
    public boolean checkForNewPasswd(List<String> prevPasswd,String passwd){
        return !prevPasswd.contains(passwd);
    }
}
