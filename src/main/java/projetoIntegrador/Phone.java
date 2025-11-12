package projetoIntegrador;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Phone {

    private String phone;
    private String REGEX_PHONE = "^\\(?(?:[14689][1-9]|2[12478]|3[1234578]|5[1345]|7[134579])\\)? ?(?:9\\d{4}|\\d{4})[-]?\\d{4}$";
    private Pattern PATTERN = Pattern.compile(REGEX_PHONE);

    public Phone(String phone) {
        this.setPhone(phone);
    }

    public String getPhone() {
        return this.maskPhone(this.phone);
    }

    public Boolean setPhone(String phone) {
        if (!this.isPhoneValid(phone)) {
           return false;
        }
        this.phone = phone;
        return true;
    }

    public boolean isPhoneValid(String phone) {
        if (phone == null || phone.trim().isEmpty()) {
            return false;
        }

        Matcher matcher = PATTERN.matcher(phone);

        return matcher.matches();
    }

    public String maskPhone(String phone) {
        if (!isPhoneValid(phone)) {
            return "Número de phone inválido";
        }

        String onlyDigits = phone.replaceAll("[^0-9]", "");

        int phoneLength = onlyDigits.length();

        return switch (phoneLength) {
            case 11 -> "(" + onlyDigits.substring(0, 2) +
                    ") " + onlyDigits.substring(2, 7) +
                    "-" + onlyDigits.substring(7, 11);
            case 10 -> "(" + onlyDigits.substring(0, 2) +
                    ") " + onlyDigits.substring(2, 6) +
                    "-" + onlyDigits.substring(6, 10);
            case 9 -> onlyDigits.substring(0, 5) +
                    "-" + onlyDigits.substring(5, 9);
            case 8 -> onlyDigits.substring(0, 4) +
                    "-" + onlyDigits.substring(4, 8);
            default -> phone;
        };

    }
}