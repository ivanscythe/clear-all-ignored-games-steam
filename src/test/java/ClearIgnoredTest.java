import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class ClearIgnoredTest {

    @Test
    public void clearAllIgnored() {
        open("https://store.steampowered.com/login/?redir=%3Fl%3Drussian&redir_ssl=1&snr=1_4_4__global-header");
        getWebDriver().manage().window().maximize();
        $(byXpath("//*[@id=\"responsive_page_template_content\"]/div[3]/div[1]/div/div/div/div[2]/div/form/div[1]/input")).setValue("логин");
        $(byXpath("//*[@id=\"responsive_page_template_content\"]/div[3]/div[1]/div/div/div/div[2]/div/form/div[2]/input")).setValue("пароль");
        $(byXpath("//*[@id=\"responsive_page_template_content\"]/div[3]/div[1]/div/div/div/div[2]/div/form/div[4]/button")).click();
        Selenide.sleep(10000);
        open("https://store.steampowered.com/account/notinterested/");

        while (true) {
            ElementsCollection buttons = $$(".btnv6_blue_hoverfade.btn_small_thin");
            for (SelenideElement button : buttons) {
                if (button.is(visible)) {
                    button.click();
                    Selenide.sleep(500);
                }
                else break;
            }
            Selenide.refresh();
        }




    }
}
