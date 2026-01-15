package Task;

public class Task17BTester implements Task17BLogin {

    @Override
    public void enterUsername(String username) {
        System.out.println("Entering username: " + username);
    }

    @Override
    public void enterPassword(String password) {
        System.out.println("Entering password for user");
    }

    @Override
    public void clickLogin() {
        System.out.println("Clicking login button");
    }

    @Override
    public void verifyDashboardAccess() {
        System.out.println("Login successful. Dashboard loaded.");
    }

    public static void main(String[] args) {

        Task17BTester tester = new Task17BTester();

        tester.enterUsername("gymUser");
        tester.enterPassword("strongPassword123");
        tester.clickLogin();
        tester.verifyDashboardAccess();
    }
}
