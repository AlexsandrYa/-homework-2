package TestLesson;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CheckingForCompletion {

    @BeforeAll
    static void beforeAll(){

        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }


@Test
    void fillFromTest(){

    open ("/text-box");
    $("#userName").setValue("Sasha");
    $("#userEmail").setValue("yaya@yandex.ru");
    $("#currentAddress").setValue("Krasnodar");
    $("#permanentAddress").setValue("Saratov");
    $("#submit").click();

    $("#output").shouldHave(text("Sasha"), text("yaya@yandex.ru"), text("Krasnodar"),
            text("Saratov"));
}

}