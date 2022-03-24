package emlakburada.util;

public class UserUtil {

	private UserUtil() {

	}

	public static boolean isValidPassword(String password, String password2) {
		return password.equals(password2);
	}

}
