import java.util.HashMap;

public class AuthService {

    private HashMap<String, String> users = new HashMap<>();

    public void register(String username, String password) {
        if (users.containsKey(username)) {
            System.out.println("❌ User already exists!");
        } else {
            users.put(username, password);
            System.out.println("✅ Registration successful!");
        }
    }

    public boolean login(String username, String password) {
        return users.containsKey(username) &&
               users.get(username).equals(password);
    }
}
