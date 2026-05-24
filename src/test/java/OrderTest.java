import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

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

        // 5. Проверяем успех
        boolean successVisible = driver.findElement(
                By.cssSelector("[data-test-id='order-success']")
        ).isDisplayed();

        assertTrue(successVisible);
    }
}