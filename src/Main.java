public class Main {
    public static void main(String[] args) {
//        String login = "k_kwaksa123";
//        String password = "ilonmask";
//        String confirmPassword = "ilonmask";

        try {
            checkEnteredData("k_kwaksa123", "ilonmask_абрикос", "ilonmas_не_абрикос");
        } catch (WrongLoginException e) {
            System.out.println(e.getMessage());
            System.out.println("""
                    Логин может содержать буквы латиницы, цифры и знак подчеркивания ("_")\
                    
                    Длина логина не должна превышать 20 символов\

                    Проверьте логин и попробуйте снова.""");
        } catch (WrongPasswordException e) {
            System.out.println(e.getMessage());
            System.out.println("""
                    Пароль может содержать буквы латиницы, цифры и знак подчеркивания\
                    
                    Длина пароля не должна превышать 20 символов\

                    Кроме того, проверьте одинаковы ли пароли и попробуйте снова.""");
        } finally {
            System.out.println("\nПроверка окончена\n");
        }
    }

    private static void checkEnteredData(String login, String password, String confirmPassword) {
        if (login.length() > 20) {
            throw new WrongLoginException("Логин слишком длинный!");
        } else if (!isValid(login)) {
            throw new WrongLoginException("Логин содержит некорректные символы!");
        } else if (password.length() > 20) {
            throw new WrongPasswordException("Пароль слишком длинный!");
        } else if (!isValid(password)) {
            throw new WrongPasswordException("Пароль содержит некорректные символы!");
        } else if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Пароли не совпадают!");
        }
    }

    private static boolean isValid(String str) {
        char[] cArray = str.toCharArray();
        for (char c : cArray) {
            if (!(Character.getNumericValue(c) >= 10 && Character.getNumericValue(c) <= 35)
                    && !Character.isDigit(c)
                    && c != '_') {
                return false;
            }
        }
        return true;
    }
}
