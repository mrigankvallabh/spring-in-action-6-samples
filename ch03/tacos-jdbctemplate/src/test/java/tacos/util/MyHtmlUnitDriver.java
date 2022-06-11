package tacos.util;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class MyHtmlUnitDriver extends HtmlUnitDriver {

    public WebElement findElementByCssSelector(String string) {
        return findElement(By.cssSelector(string));
    }

    public List<WebElement> findElementsByClassName(String string) {
        return findElements(By.className(string));
    }

    public WebElement findElementByTagName(String string) {
        return findElement(By.tagName(string));
    }
    
}
