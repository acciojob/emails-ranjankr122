package com.driver;

public class Email {

    private String emailId;
    private String password;

    public Email(String emailId){
        this.emailId = emailId;
        this.password = "Accio@123";
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPassword() {
        return password;
    }

    public void changePassword(String oldPassword, String newPassword){
        if(oldPassword.equals(getPassword())){
            if (newPassword.length()>=8){
                boolean upper=false;
                boolean lower=false;
                boolean digit=false;
                boolean spacial=false;
                for (int i=0;i<newPassword.length();i++){
                    char c =newPassword.charAt(i);
                    if (c>='A' &&  c<='Z'){
                        upper =true;
                    }
                    if (c>='a' &&  c<='z'){
                        lower =true;
                    }
                    if (c>='0' &&  c<='9'){
                        digit =true;
                    }
                    if (!Character.isDigit(newPassword.charAt(i))
                            && !Character.isLetter(newPassword.charAt(i))
                            && !Character.isWhitespace(newPassword.charAt(i))) {
                        spacial=true;
                    }

                }
                if(upper && lower && digit && spacial){
                    password=newPassword;
                }
            }
        }
        else {
            System.out.println("Wrong password");
            return;
        }

        //Change password only if the oldPassword is equal to current password and the new password meets all of the following:
        // 1. It contains at least 8 characters
        // 2. It contains at least one uppercase letter
        // 3. It contains at least one lowercase letter
        // 4. It contains at least one digit
        // 5. It contains at least one special character. Any character apart from alphabets and digits is a special character
    }
}
