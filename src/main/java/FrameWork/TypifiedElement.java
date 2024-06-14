package FrameWork;

import com.fasterxml.jackson.databind.util.Named;
import org.openqa.selenium.*;

import java.util.List;

public abstract class TypifiedElement implements WrapsElement, Named, WebElement {
    private final WebElement wrappedElement;
    private String name;

    protected TypifiedElement(WebElement wrappedElement) {
        this.wrappedElement = wrappedElement;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return this.name;
    }

    public boolean exists() {
        try {
            this.getWrappedElement().isDisplayed();
            return true;
        } catch (NoSuchElementException var2) {
            return false;
        }
    }

    public WebElement getWrappedElement() {
        return this.wrappedElement;
    }

    public void click() {
        this.getWrappedElement().click();
    }

    public void submit() {
        this.getWrappedElement().submit();
    }

    public void sendKeys(CharSequence... keysToSend) {
        this.getWrappedElement().sendKeys(keysToSend);
    }

    public void clear() {
        this.getWrappedElement().clear();
    }

    public String getTagName() {
        return this.getWrappedElement().getTagName();
    }

    public String getAttribute(String name) {
        return this.getWrappedElement().getAttribute(name);
    }

    public boolean isSelected() {
        return this.getWrappedElement().isSelected();
    }

    public boolean isEnabled() {
        return this.getWrappedElement().isEnabled();
    }

    public String getText() {
        return this.getWrappedElement().getText();
    }

    public List<WebElement> findElements(By by) {
        return this.getWrappedElement().findElements(by);
    }

    public WebElement findElement(By by) {
        return this.getWrappedElement().findElement(by);
    }

    public boolean isDisplayed() {
        return this.getWrappedElement().isDisplayed();
    }

    public Point getLocation() {
        return this.getWrappedElement().getLocation();
    }

    public Dimension getSize() {
        return this.getWrappedElement().getSize();
    }

    public Rectangle getRect() {
        return this.getWrappedElement().getRect();
    }

    public String getCssValue(String propertyName) {
        return this.getWrappedElement().getCssValue(propertyName);
    }

    public <X> X getScreenshotAs(OutputType<X> target) {
        return this.getWrappedElement().getScreenshotAs(target);
    }
}
