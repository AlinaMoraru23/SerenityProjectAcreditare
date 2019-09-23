package org.fasttrack.serenity.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;


public class ProductPage extends PageObject {

    @FindBy(css = ".product_title")
    private WebElementFacade productName;

    @FindBy(css = "button[name='add-to-cart']")
    private WebElementFacade addToCartButton;


    @FindBy(css = "[class*='wc-forward']")
    public WebElementFacade viewCartButton;


    //for 1 single result, the user is re-directed to the product page
    public boolean isProductInResult(String searchItem) {
        return productName.getText().contains(searchItem);

    }

    public void clickAddToCart() {
        clickOn(addToCartButton);
    }

    public void clickViewCartButton(){
        clickOn(viewCartButton);
    }

}
