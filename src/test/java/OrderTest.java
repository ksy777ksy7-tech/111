import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.*;

public class OrderTest extends BaseTest {

    @Test
    void shouldSendFormSuccessfully() {

        driver.get("http://localhost:9999");

        // 1. Вводим имя
        driver.findElement(By.cssSelector("[data-test-id='name'] input"))
                .sendKeys("Иванов Иван");

        // 2. Вводим телефон
        driver.findElement(By.cssSelector("[data-test-id='phone'] input"))
                .sendKeys("+79991234567");

        // 3. Ставим галочку
        driver.findElement(By.cssSelector("[data-test-id='agreement']"))
                .click();

        // 4. Жмём кнопку
        driver.findElement(By.cssSelector("button[type='button']"))
                .click();

        // 5. Проверяем успех (видимость + текст)
        WebElement successMessage = driver.findElement(
                By.cssSelector("[data-test-id='order-success']")
        );

        assertTrue(successMessage.isDisplayed());

        assertEquals(
                "Ваша заявка успешно отправлена!",
                successMessage.getText().trim()
        );
    }
}