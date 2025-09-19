package utilities;

import java.time.Instant;
import java.util.Random;
import java.util.UUID;

public class UtilityClass  {

    public static String random_JS_Email;
    public static String random_EMP_Email;

    public String generateRandomEmail(String domain) {
        String uuid = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 8);
        return "test_" + uuid + "@" + domain;
    }

    public String generateUniquePhoneNumber() {
        Random random = new Random();
        int networkCode = random.nextInt(8) + 1; // 1–8
        String prefix = "+9231" + networkCode;
        String suffix = Long.toString(Instant.now().toEpochMilli()).substring(6); // last 7 digits
        return prefix + suffix;
    }

    public String generateRandomName() {
        String uuid = UUID.randomUUID().toString();
        String shortUuid = uuid.substring(0, 8); // First 8 characters
        return "User_" + shortUuid;
    }

    public String generateRandomComp() {
        String uuid = UUID.randomUUID().toString();
        String shortUuid = uuid.substring(0, 8); // First 8 characters
        return "Comp_" + shortUuid;
    }

    public String generateTitle() {
        String uuid = UUID.randomUUID().toString();
        String shortUuid = uuid.substring(0, 8); // First 8 characters
        return "Title_" + shortUuid;
    }

}
