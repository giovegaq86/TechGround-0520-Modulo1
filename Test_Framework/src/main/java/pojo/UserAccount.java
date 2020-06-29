package pojo;

public class UserAccount {

    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String password;
    private String subscribe;
    private String successfulMessage;
    private boolean policy;
    private boolean shouldLogin; //bandera que indica si el usuario deberia o no loguearse

    // si solo se usa para parsear de json a pojo no requiere constructor
    public UserAccount(String _firstName, String _lastName, String _phone, String _email, String _password,
                       String _subscribe, boolean _policy, boolean _shouldLogin, String _successfulMessage){
        this.setEmail(_email);
        this.setPassword(_password);
        this.setShouldLogin(_shouldLogin);
        this.setFirstName(_firstName);
        this.setLastName(_lastName);
        this.setPhone(_phone);
        this.setPolicy(_policy);
        this.setSubscribe(_subscribe);
        this.setSuccessfulMessage(_successfulMessage);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSubscribe() {
        return subscribe;
    }

    public void setSubscribe(String subscribe) {
        this.subscribe = subscribe;
    }

    public boolean getPolicy() {
        return policy;
    }

    public void setPolicy(boolean policy) {
        this.policy = policy;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSuccessfulMessage() {
        return successfulMessage;
    }

    public void setSuccessfulMessage(String successfulMessage) {
        this.successfulMessage = successfulMessage;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isShouldLogin() {
        return shouldLogin;
    }

    public void setShouldLogin(boolean shouldLogin) {
        this.shouldLogin = shouldLogin;
    }

    @Override
    public String toString(){
        return (String.format("Email: %s and password: %s", email,password));
    }
}
