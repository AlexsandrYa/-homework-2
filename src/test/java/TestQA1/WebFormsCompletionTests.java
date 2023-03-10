package TestQA1;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class WebFormsCompletionTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.browser = "Firefox";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void testingWebForm() {

        open("/automation-practice-form");

        // Устранение банеров
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        //Данные пользователя
        $("#firstName").setValue("Sasha");
        $("#lastName").setValue("Yavtushenko");
        $("#userEmail").setValue("aassyy@yandex.ru");
        $("#userNumber").setValue("8988555777");
        $("#dateOfBirthInput").click();

        // Выбераем пол
        $("#gender-radio-1").parent().click();

        // Дата рождения
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("December");
        $(".react-datepicker__year-select").selectOption("1991");
        $(".react-datepicker__day--016").click();

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
        $(".modal-body").shouldHave(text("1212.png"));
        $(".modal-body").shouldHave(text("Krasnodar is the best city"));
        $(".modal-body").shouldHave(text("NCR Delhi"));
        $("#closeLargeModal").click();

        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");


    }
}



