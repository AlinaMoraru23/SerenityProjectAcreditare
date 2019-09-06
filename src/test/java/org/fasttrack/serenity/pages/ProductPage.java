package org.fasttrack.serenity.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;


public class ProductPage extends PageObject {

    @FindBy(css = ".product_title")
    private WebElementFacade productName;

    //for 1 single result, the user is re-directed to the product page
    public boolean isProductInResult(String searchItem) {
        return productName.getText().contains(searchItem);

    }

    @FindBy(css = "button[name='add-to-cart']")
    private WebElementFacade addToCartButton;

    public void clickAddToCart() {
        clickOn(addToCartButton);
    }

    @FindBy(css = "[class*='wc-forward']")
    public WebElementFacade viewCartButton;

    public void clickViewCartButton(){
        clickOn(viewCartButton);
    }

}
