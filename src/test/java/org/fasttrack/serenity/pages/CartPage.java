package org.fasttrack.serenity.pages;



import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;



import java.util.ArrayList;
import java.util.List;

public class CartPage extends PageObject {

    @FindBy(css = "[class*='cart-item'] .product-name")
    private List<WebElementFacade> cartProductNames;


    @FindBy(css = "[class*='cart-item'] .product-price")
    private WebElementFacade cartFirstProductPrice;

    @FindBy(css = "[class*='cart-item'] .product-subtotal")
    private List<WebElementFacade> cartProductSubtotal;

    @FindBy(css = "[class*='cart-item'] .product-remove a")
    private WebElementFacade removeItemFromCartLink;

    public void removeItemFromCart() {
        clickOn(removeItemFromCartLink);
    }

    @FindBy(css = ".restore-item")
    private WebElementFacade undoRemoveItemFromCartLink;

    public void undoRemoveItemFromCart() {
        clickOn(undoRemoveItemFromCartLink);
    }

    public boolean isProductInCart(String productName) {
        for (WebElementFacade element : cartProductNames) {
            if (element.getText().contains(productName)) {
                return true;
            }

        }
        return false;
    }


    @FindBy(css = "[class*='cart-item'] [class*='product-quantity']")
    private WebElementFacade productQuantityField;

    @FindBy(css = ".quantity input")
    private WebElementFacade productQuantityInputField;


    public void fillInQuantity(String quantity) {
        typeInto(productQuantityInputField, quantity);
    }

    @FindBy(css = "button[name='update_cart']")
    private WebElementFacade updateCartButton;

    public void updateCart() {
        clickOn(updateCartButton);
    }

    private Integer productQuantity;

    public Integer getProductQuantity() {
        productQuantity = productQuantity.valueOf(productQuantityInputField.getAttribute("value"));
        return productQuantity;
    }

    public boolean checkProductQuantityIsUpdatedInCart(Integer newQuantity) {
        return getProductQuantity().equals(newQuantity);
    }

    public void displayCartProductNames() {
        for (WebElementFacade element : cartProductNames) {
            System.out.println(element.getText());
        }
    }


    public boolean checkProductWasRemovedFromCart(String removedProductName) {
        for (WebElementFacade element : cartProductNames) {
            return !element.getText().contains(removedProductName);
        }
        return false;
    }

    private Integer cartFirstProductPriceValue;

    public void getFirstProductPrice() {
        cartFirstProductPriceValue = cartFirstProductPriceValue.valueOf(cartFirstProductPrice.getText().replaceAll("[^0-9]", ""));
    }


    private Integer productSubtotal;

    public List<Integer> getCartProductsSubtotals() {
        List<Integer> cartProductsSubtotalValues = new ArrayList<>();
        for (WebElementFacade element : cartProductSubtotal) {
            productSubtotal = productSubtotal.valueOf(element.getText().replaceAll("[^0-9]", ""));
            cartProductsSubtotalValues.add(productSubtotal);
        }
        return cartProductsSubtotalValues;
    }


    private Integer lineSubtotal;
    public void calculateCartFirstLineSubtotal(){
        lineSubtotal=cartFirstProductPriceValue*productQuantity;

    }


    public boolean verifyCartFirstLineSubtotal(){
        return (lineSubtotal.equals(getCartProductsSubtotals().get(0)));
    }
}