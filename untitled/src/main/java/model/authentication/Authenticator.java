package model.authentication;

public abstract class Authenticator {
    public boolean authenticate(String username, String password) {
        if (isLoginExists(username)){
            String storedPassword = getPassword(username);
            return storedPassword != null && storedPassword.equals(password);
        }
        return false;
    }

    protected abstract boolean isLoginExists(String username);

    protected abstract String getPassword(String username);

    public static void main(String[] args){
        Authenticator mapAuthenticator = new MapAuthenticator();
        boolean isAuthenticatedWithMap = mapAuthenticator.authenticate("MaelS", "azeaze");
        System.out.println("authentification via map réussie?" + isAuthenticatedWithMap);

    }
}

