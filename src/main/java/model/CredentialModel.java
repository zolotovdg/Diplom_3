package model;

public class CredentialModel {
    private String email;
    private String password;

    public CredentialModel(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
