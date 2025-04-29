package Domain;

import java.net.PortUnreachableException;
import java.util.ArrayList;

public class KeyGenerator {
    public final String UPPER = "QWERTYUIOPLKJHGFDSAZXCVBNM";
    public final String LOWER = "qwertyuioplkjhgfdsaxcvbnm";
    public final String SPECIALS = "!@#$%^&*()_+-=[]{}|;:'\",.<>/?`~";
    public final String DIGITS = "1234567890";

    public static ArrayList<String> password = new ArrayList<>();

    private int lenghtPassword= 10;
    private boolean useSpecialCharacters;
    private boolean useUpperCaseCharaters;
    private boolean useLowerCaseCharacters;
    private boolean useNumbers;

    public KeyGenerator(){}

    public KeyGenerator(boolean useSpecialCharacters,
                        boolean useNumbers,
                        boolean useLowerCase,
                        boolean useUpperCase,
                        int lenghtPassword){

        this.useNumbers = useNumbers;
        this.lenghtPassword = lenghtPassword;
        this.useLowerCaseCharacters = useLowerCase;
        this.useUpperCaseCharaters = useUpperCase;
        this.useSpecialCharacters = useSpecialCharacters;

        validateOneTipeOfCharacters();
    }

    public void setUPPER(){
        this.useUpperCaseCharaters = true;
    }
    public void setLOWER(){
        this.useLowerCaseCharacters = true;
    }
    public void setSPECIALS(){
        this.useSpecialCharacters = true;
    }
    public void setDIGITS (){
        this.useNumbers = true;
    }

    public void validateOneTipeOfCharacters(){
        if (!(useSpecialCharacters || useNumbers || useLowerCaseCharacters || useUpperCaseCharaters)){
            throw new IllegalArgumentException("Se requiere por lo menos un tipo de caracter");
        }
    }

    public StringBuilder appendTipesOfCharacters(){
        StringBuilder charsAppend = new StringBuilder();
        if (useUpperCaseCharaters) charsAppend.append(UPPER);
        if (useLowerCaseCharacters) charsAppend.append(LOWER);
        if (useSpecialCharacters) charsAppend.append(SPECIALS);
        if (useNumbers) charsAppend.append(DIGITS);
        return  charsAppend;
    }

    public String generatePassword(){
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
        return passworString.toString();
    }
}


