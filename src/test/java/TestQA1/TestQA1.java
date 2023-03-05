package TestQA1;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestQA1 {
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.browser = "Firefox";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void TestQA1() {
        open("/automation-practice-form");

        //Характеристики пользователя
        $("#firstName").setValue("Sasha");
        $("#lastName").setValue("Yavtushenko");
        $("#userEmail").setValue("aassyy@yandex.ru");
        $("#userNumber").setValue("8988555777");
        $("#dateOfBirthInput").click();

        // Выбераем пол
        $("#gender-radio-1").parent().click();

        // Дата рождения
        $(".react-datepicker__month-select").selectOption("December");
        $(".react-datepicker__year-select").selectOption("1991");
        $(".day react-datepicker__day--016").click();


        //$(by("class", "react-datepicker__year-select")).$(byText("1991")).click();
        //$(by("class", "react-datepicker__month-select")).$(byText("December")).click();
        //$(by("class", "react-datepicker__month-container")).$(byText("16")).click();

        // Добовления Subjects и Hobbies
        $("#subjectsInput").setValue("Commerce").pressEnter();
        $("#hobbiesWrapper").$(byText("Music")).click();

        //Загрузка файла
        $("#uploadPicture").uploadFromClasspath("img/1212.png");

        //Добавление текущего адреса
        $("#currentAddress").setValue("Krasnodar is the best city");
        $("#state").click();
        $("#state").$(byText("NCR")).click();
        $("#city").click();
        $("#city").$(byText("Delhi")).click();
        $("#submit").click();

        //Результаты заполнения
        $(".modal-body").shouldHave(text("Sasha Yavtushenko"));
        $(".modal-body").shouldHave(text("aassyy@yandex.ru"));
        $(".modal-body").shouldHave(text("Male"));
        $(".modal-body").shouldHave(text("8988555777"));
        $(".modal-body").shouldHave(text("16 December "));
        $(".modal-body").shouldHave(text("Commerce"));
        $(".modal-body").shouldHave(text("Music"));
        $(".modal-body").shouldHave(text("ToolForm.png"));
        $(".modal-body").shouldHave(text("Moscow never sleep"));
        $(".modal-body").shouldHave(text("NCR Delhi"));
        $("#closeLargeModal").click();





    }
}

