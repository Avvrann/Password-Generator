package Domain;

import java.util.ArrayList;

public class KeyGenerator {
    public final String UPPER = "QWERTYUIOPLKJHGFDSAZXCVBNM";
    public final String LOWER = "qwertyuioplkjhgfdsaxcvbnm";
    public final String SPECIALS = "!@#$%^&*()_+-=[]{}|;:'\",.<>/?`~";
    public final String DIGITS = "1234567890";

    public static ArrayList<String> password = new ArrayList<>();

    public static int lenghtPassword;
    public static boolean useSpecialCharacters;
    public static boolean useUpperCaseCharaters;
    public static boolean useLowerCaseCharacters;
    public static boolean useNumbers;

    public KeyGenerator(){}

    public static void setUPPER(){useUpperCaseCharaters = true;}
    public static void setLOWER(){useLowerCaseCharacters = true;}
    public static void setSPECIALS(){useSpecialCharacters = true;}
    public static void setDIGITS (){useNumbers = true;}


    public static void disableUPPER(){useUpperCaseCharaters = false;}
    public static void disableLOWER(){useLowerCaseCharacters = false;}
    public static void disableSPECIALS(){useSpecialCharacters = false;}
    public static void disableDIGITS (){useNumbers = false;}

    public void setLenghtPasswordP(int cantiadDigitos){lenghtPassword = cantiadDigitos;}

    public void validateOneTipeOfCharacters(){
        if (!(useSpecialCharacters || useNumbers || useLowerCaseCharacters || useUpperCaseCharaters)){
            throw new IllegalArgumentException("Se requiere por lo menos un tipo de caracter");
        }
    }

    public StringBuilder appendTipesOfCharacters(){
        StringBuilder charsAppend = new StringBuilder();
        charsAppend.delete(0,charsAppend.length());
        System.out.println("=========================================");
        System.out.println(charsAppend);
        System.out.println("=========================================");
        if (useUpperCaseCharaters) charsAppend.append(UPPER);
        System.out.println("estado de las mayusculas : " + useUpperCaseCharaters);
        if (useLowerCaseCharacters) charsAppend.append(LOWER);
        System.out.println("estado de las minusculas : " + useLowerCaseCharacters);
        if (useSpecialCharacters) charsAppend.append(SPECIALS);
        System.out.println("estado de los caracteres especiales : " + useSpecialCharacters);
        if (useNumbers) charsAppend.append(DIGITS);
        System.out.println("estado de los numeros : " + useNumbers);
        return  charsAppend;
    }

    public String generatePassword(){

        try {
            StringBuilder allChars = appendTipesOfCharacters();

            for (int n = 0; n < lenghtPassword; n ++){
                int ramdomIndex = (int) (Math.random() * allChars.length());
                char caracterRamdom = allChars.charAt(ramdomIndex);
                password.add(String.valueOf(caracterRamdom));
            }
            StringBuilder passworString = new StringBuilder();

            for (String element : password){
                passworString.append(element);
            }

            password.clear();
            return passworString.toString();


        }catch (Exception e){
            System.out.println("faltan caracteres");
        }
        return null;
    }
}


