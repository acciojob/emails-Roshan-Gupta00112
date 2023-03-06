package com.driver;

public class Email {

    private String emailId;
    private String password;

    public Email(String emailId){
        this.emailId = emailId;
        this.password = "Accio@123";
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPassword() {
        return password;
    }

    public void changePassword(String oldPassword, String newPassword){
        //Change password only if the oldPassword is equal to current password and the new password meets all of the following:
        // 1. It contains at least 8 characters
        // 2. It contains at least one uppercase letter
        // 3. It contains at least one lowercase letter
        // 4. It contains at least one digit
        // 5. It contains at least one special character. Any character apart from alphabets and digits is a special character

        if(oldPassword.equals(this.password)){
            if(isValid(newPassword)){
                //if(isContainsUpperCase(password) && isContainsLowerCase(password) && isContainsDigit(password) && isContainsSpecialChar(password)) {
                    this.password = newPassword;
                System.out.println("Password changed successfully!");
            }
            else System.out.println("The new password is not valid!");
        }
        else System.out.println("The given password does not match current password");
    }


    public boolean isValid(String password){
        boolean capitalLetter=false;
        boolean smallLetter=false;
        boolean digit=false;
        boolean specialCharacter=false;

        if(password.length()<8) return false;

        for(int i=0; i<password.length(); i++) {
            char ch = password.charAt(i);
            if ((ch >= 'A') && (ch <= 'Z')) capitalLetter = true;
            else if ((ch >= 'a') && (ch <= 'z')) smallLetter = true;
            else if ((ch >= '0') && (ch <= '9')) digit = true;
            else specialCharacter = true;
        }

        if(capitalLetter && smallLetter && digit && specialCharacter) return true;

        return false;
    }


//    public static boolean isContainsUpperCase(String password){
//        for(int i=0; i<password.length(); i++){
//            //if((int)password.charAt(i)>=65 && (int)password.charAt(i)<=90) return true;
//            if(Character.isUpperCase(password.charAt(i))) return true;
//        }
//        return false;
//    }
//
//    public static boolean isContainsLowerCase(String password){
//        for(int i=0; i<password.length(); i++){
//            //if((int)password.charAt(i)>=97 && (int)password.charAt(i)<=122) return true;
//            if(Character.isLowerCase(password.charAt(i))) return true;
//        }
//        return false;
//    }
//
//    public static boolean isContainsDigit(String password){
//        for(int i=0; i<password.length(); i++){
//            //if((int)password.charAt(i)>=48 && (int)password.charAt(i)<=57) return true;
//            if(Character.isDigit(password.charAt(i))) return true;
//        }
//        return false;
//    }

//    public static boolean isContainsSpecialChar(String password){
//        for(int i=0; i<password.length(); i++){
////            if((int)password.charAt(i)>=32 && (int)password.charAt(i)<=47) return true;
////            if((int)password.charAt(i)>=58 && (int)password.charAt(i)<=64) return true;
////            if((int)password.charAt(i)>=91 && (int)password.charAt(i)<=96) return true;
////            if((int)password.charAt(i)>=123 && (int)password.charAt(i)<=126) return true;
//
//            if(!Character.isDigit(password.charAt(i)) && !Character.isLetter(password.charAt(i)) && !Character.isWhitespace(password.charAt(i)))
//                return true;
//        }
//        return false;
//    }

}
