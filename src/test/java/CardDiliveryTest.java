import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Selenide.*;


public class CardDiliveryTest {

    @Test
    void shoulCardDesign() {
        Configuration.holdBrowserOpen = true;
        String currentDate = LocalDate.now().plusDays(3).format(DateTimeFormatter.ofPattern("dd.MM.YYYY"));
        open("http://localhost:9999/");

        $("[data-test-id=city] input").setValue("Смоленск");
        $("[data-test-id=date]").click();
        $("[data-test-id=date] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE);
        $("[data-test-id=date] input").sendKeys(currentDate);
        $("[data-test-id=name] input").setValue("Сидоров-Петров Иван");
        $("[data-test-id=phone] input").setValue("+79200000000");
        $("[data-test-id='agreement']").click();
        $x("//span[@class='button__content']//parent::button").click();
        $("[data-test-id=notification]").shouldBe(Condition.visible, Duration.ofSeconds(15));


    }
}
