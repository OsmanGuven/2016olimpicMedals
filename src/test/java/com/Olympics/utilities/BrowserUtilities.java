package com.Olympics.utilities;

import org.openqa.selenium.WebElement;

import java.util.List;

public class BrowserUtilities {

    /**
     * Thread.sleep method utilized
     *
     * @param seconds int parameter
     */
    public static void wait(int seconds) {
        try {
            Thread.sleep(1000 * seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //TODO
    public static String[] elementsToStringArray(List<WebElement> elements) {
        int size = elements.size();
        String[] retArr = new String[size];

        for (int i = 0; i < elements.size(); i++) {
            retArr[i] = elements.get(i).getText();
        }

        return retArr;
    }


    //TODO
    public static int[] convertStringArrayToIntArray(String[] strArr) {
        int[] retArr = new int[strArr.length];

        for (int i = 0; i < strArr.length; i++) {

            for (int y = 0; y < strArr[i].length(); y++) {
                if (!Character.isDigit(strArr[i].charAt(y)))
                    strArr[i] = strArr[i].substring(0, y);
                else
                    continue;
            }

            if (strArr[i].isEmpty())
                retArr[i] = 0;
            else
                retArr[i] = Integer.parseInt(strArr[i]);

        }


        return retArr;
    }
}