import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        AuthService auth = new AuthService();
        boolean isLoggedIn = false;

        while (true) {
            System.out.println("\n--- LOGIN SYSTEM ---");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Secured Page");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Username: ");
                    String rUser = sc.nextLine();
                    System.out.print("Password: ");
                    String rPass = sc.nextLine();
                    auth.register(rUser, rPass);
                    break;

                case 2:
                    System.out.print("Username: ");
                    String lUser = sc.nextLine();
                    System.out.print("Password: ");
                    String lPass = sc.nextLine();

                    if (auth.login(lUser, lPass)) {
                        isLoggedIn = true;
                        System.out.println("✅ Login successful!");
                    } else {
                        System.out.println("❌ Invalid credentials!");
                    }
                    break;

                case 3:
                    if (isLoggedIn) {
                        System.out.println("🔒 Welcome to secured page!");
                    } else {
                        System.out.println("⛔ Please login first!");
                    }
                    break;

                case 4:
                    System.out.println("👋 Goodbye!");
                    sc.close();
                    return;

                default:
                    System.out.println("❌ Invalid choice");
            }
        }
    }
}
