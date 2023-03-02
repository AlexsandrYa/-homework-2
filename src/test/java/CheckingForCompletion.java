import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CheckingForCompletion {


@Test
    void fillFromTest(){

    open ("https://demoqa.com/automation-practice-form");
    $("").setValue("");
    $("").setValue("");
}

}