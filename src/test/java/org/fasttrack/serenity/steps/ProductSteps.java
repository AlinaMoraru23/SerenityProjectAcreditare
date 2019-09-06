package org.fasttrack.serenity.steps;

import net.thucydides.core.annotations.Step;
import org.fasttrack.serenity.pages.ProductPage;

public class ProductSteps {

    private ProductPage productPage;

    @Step
    public void addProductToCart() {
        productPage.clickAddToCart();
    }

    @Step
    public void clickViewCart() {
        productPage.clickViewCartButton();
    }
}
