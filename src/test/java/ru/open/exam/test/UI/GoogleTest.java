package ru.open.exam.test.UI;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.open.exam.test.helper.Helper;


import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class GoogleTest {

    String regexp = "примерно [\\d\\s]* \\(";
    String selector = "div#resultStats";

    @Test
    public void  checkSearchResultTest(){
        open("http://google.com");
        $(By.name("q")).setValue("Открытие").pressEnter();

        String resultSearch = $(By.cssSelector(selector)).getText();
        int resultCount = Helper.parseStringToInteger(regexp, resultSearch);
        Assert.assertTrue(resultCount >= 10_000);
    }
}