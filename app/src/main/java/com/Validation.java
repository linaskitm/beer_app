package com;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
    /*
    public yra ribos/matomumas, static priklauso funkciniam programavimui - nereikia kurti naujo objekto,
     kad pasinaudotume kita biblioteka/kazkokiu objektu, final - dydis galutinis, jo reiksme nesikeis, kokia priskyrem, tokia bus
    USERNAME_REGEX_PATTERN - sukurem username regular expresion pattern - sablona pasivadinom kaip norim
    */

    public static final String CREDENTIALS_PATTERN="^[a-zA-Z]{3,20}$";

    public static boolean isCredentialsValid(String credentials){
        Pattern pattern=Pattern.compile(CREDENTIALS_PATTERN); //Sukuriamas šablonas pagal mūsų taisykles
        Matcher matcher=pattern.matcher(credentials); //Pagal susikurtą šabloną palyginami susikurti duomenys
        return matcher.matches(); //Gražina true jeigu atitinka, false priešingu atveju
    }
    public static final String USERNAME_REGEX_PATTERN = "^[a-zA-Z]{3,20}$";

    public static boolean isValidUsername(String username) { //cia funkcija mes apsirasom, kaip void, tai cia boolean
        Pattern pattern = Pattern.compile(USERNAME_REGEX_PATTERN); //sukuriamas sablonas pagal musu apsirasytas taisykles (string kur susikurem virsuj)
        Matcher matcher = pattern.matcher(username); //pagal susikurta sablona palyginami vartotojo ivesti duomenys
        return matcher.matches(); //grazina true, jeigu atitinka sablona, false - priesingu atveju, kai neatitinka
    }

    public static final String PASSWORD_REGEX_PATTERN = "^[a-zA-Z0-9.!@_]{5,20}$";

    public static boolean isValidPassword(String password) {
        Pattern pattern = Pattern.compile(PASSWORD_REGEX_PATTERN);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

    public static final String EMAIL_REGEX_PATTERN = "^[a-zA-Z0-9@._-]{10,50}$";

    public static boolean isValidEmail(String email) {
        Pattern pattern = Pattern.compile(EMAIL_REGEX_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    public static final String NUMBER_REGEX_PATTERN = "^[0-9]{1,8}$";

    public static boolean isValidNumber(String number) {
        Pattern pattern = Pattern.compile(NUMBER_REGEX_PATTERN);
        Matcher matcher = pattern.matcher(number);
        return matcher.matches();
    }


}
