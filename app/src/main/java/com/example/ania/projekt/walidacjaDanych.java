package com.example.ania.projekt;

/**
 * klasa zawierajaca metody, które obsluguja walidacje wybranych danych.
 * Created by Kapibara on 2015-06-10.
 * @autor Joanna Wójcik
 */
public class walidacjaDanych {
    /**
     * Walidacja daty o formacie DD-MM-YYYY
     * @param text sprawdzane dane
     * @return @c true, jesli @p text jest w formacie daty
     * @return @c false, jesli @p text nie jest zapisany w formacie daty
     */
  public  static  boolean walidacjaDaty(String text)
    {
        String regularExpression="^(0[1-9]|[12][0-9]|3[01])[-](0[1-9]|1[012])[-]((?:19|20)[0-9][0-9])$";
        return text.matches(regularExpression);
    }
    /**
     * Walidacja czasu o formacie gg:mm lub gg:mm:ss
     * @param text sprawdzane dane
     * @return @c true, jesli format jest poprawny
     * @return @c false, jesli format nie jest poprawny
     */
public  static boolean walidacjaCzasu(String text)
    {
        String regularExpression="^(20|21|22|23|[01][0-9]|[0-9])(([:][0-5][0-9]){1,2})$";
        return text.matches(regularExpression);
    }

}


