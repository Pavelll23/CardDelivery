import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;


public class CardDiliveryTest {

    @Test
    void shoulCardDesign() {
        Configuration.holdBrowserOpen = true;

        open("http://localhost:9999/");
        $x("//span[@data-test-id='city']").setValue("См");
        $x("//span[contains(text(),'Смоленск')]//parent::div").click();
        $x("//span[@data-test-id='date']").setValue("27.03.2023");
        $x("//span[@data-test-id='name']").setValue("Сидоров-Петров Иван");
        $x("//span[@data-test-id='phone']").setValue("+79200000000");
        $x("//label[@data-test-id='agreement']").click();
        $x("//span[@class='button__content']//parent::button").click();


    }
}
