package com.example.ania.projekt;

/**
 * Created by Kapibara on 2015-06-10.
 */
public class walidacjaDanych {
  public  static  boolean walidacjaDaty(String text)
    {
        String regularExpression="^(0[1-9]|[12][0-9]|3[01])[-](0[1-9]|1[012])[-]((?:19|20)[0-9][0-9])$";
        return text.matches(regularExpression);
    }
public  static boolean walidacjaCzasu(String text)
    {
        String regularExpression="^(20|21|22|23|[01][0-9]|[0-9])(([:][0-5][0-9]){1,2})$";
        return text.matches(regularExpression);
    }

}


