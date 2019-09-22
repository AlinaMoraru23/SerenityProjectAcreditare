package org.fasttrack.serenity.pages;


import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import java.util.ArrayList;
import java.util.List;


public class CartPage extends BasePage {

    protected BasePage basePage;

    @FindBy(css = "[class*='cart-item'] .product-name")
    private List<WebElementFacade> cartProductNames;

    @FindBy(css = "[class*='cart-item'] .product-price")
    private WebElementFacade cartFirstProductPrice;

    @FindBy(css = "[class*='cart-item'] .product-subtotal")
    private List<WebElementFacade> cartProductSubtotal;

    @FindBy(css = "[class*='cart-item'] .product-remove a")
    private WebElementFacade removeItemFromCartLink;

    @FindBy(css = ".restore-item")
    private WebElementFacade undoRemoveItemFromCartLink;

    @FindBy(css = ".woocommerce-cart-form")
    private WebElementFacade cartContainer;

    @FindBy(css = ".woocommerce-message")
    private WebElementFacade cartMessage;

    @FindBy(css = "[class*='cart-item'] [class*='product-quantity']")
    private WebElementFacade productQuantityField;

    @FindBy(css = ".quantity input")
    private WebElementFacade productQuantityInputField;

    @FindBy(css = "button[name='update_cart']")
    private WebElementFacade updateCartButton;

    @FindBy(css = ".cart-subtotal td")
    private WebElementFacade cartSubtotal;

    @FindBy(css = ".order-total td")
    private WebElementFacade cartTotal;

    @FindBy(css = ".cart-discount td")
    private WebElementFacade cartDiscount;

    @FindBy(css = ".checkout-button")
    private WebElementFacade checkoutLink;

    @FindBy(id = "coupon_code")
    private WebElementFacade couponCodeField;

    @FindBy(css = "[name='apply_coupon']")
    private WebElementFacade applyCouponButtor;

    @FindBy(css = ".cart_totals")
    private WebElementFacade cartTotalsContainer;


    public void removeItemFromCart() {
        clickOn(removeItemFromCartLink);
    }

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


    public void fillInQuantity(String quantity) {
        typeInto(productQuantityInputField, quantity);
    }


    public void updateCart() {
        clickOn(updateCartButton);
        basePage.waitABit(2000);
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

    List<Integer> cartProductsSubtotalValues = new ArrayList<>();

    //method creates a list with the price subtotal values of all cart items
    public List<Integer> getCartProductsSubtotals() {
        for (WebElementFacade element : cartProductSubtotal) {
            productSubtotal = productSubtotal.valueOf(element.getText().replaceAll("[^0-9]", ""));
            cartProductsSubtotalValues.add(productSubtotal);
        }
        return cartProductsSubtotalValues;
    }


    private Integer lineSubtotal;

    public void calculateCartFirstLineSubtotal() {
        lineSubtotal = cartFirstProductPriceValue * productQuantity;
    }


    public boolean verifyCartFirstLineSubtotal() {
        return (lineSubtotal.equals(getCartProductsSubtotals().get(0)));
    }

    private Integer cartSubtotalValue;

    public void getCartSubtotal() {
        cartSubtotalValue = cartSubtotalValue.valueOf(cartSubtotal.getText().replaceAll("[^0-9]", ""));
    }

    private Integer cartDiscountValue;

    public void getCartDiscountValue(){
        cartDiscountValue = cartDiscountValue.valueOf(cartDiscount.getText().replaceAll("[^0-9]",""));
    }

    private Integer cartTotalValue;

    public void getCartTotalValue(){
        cartTotalValue = cartTotalValue.valueOf(cartTotal.getText().replaceAll("[^0-9]",""));
    }


    private Integer cartSubtotalCalculation;

    public void calculateCartSubtotal() {
        cartSubtotalCalculation = 0;
        for (Integer i : cartProductsSubtotalValues) {
            cartSubtotalCalculation = cartSubtotalCalculation + i;
        }
    }

    public boolean verifyCartSubtotalCalculation() {
        return (cartSubtotalCalculation.equals(cartSubtotalValue));
    }

    public void waitForTextToAppearInCart(String text) {
        waitForTextToAppear(cartContainer, text);
    }

    public void waitForTextToDisappearFromCart(String text) {
        waitForTextToDisappear(cartContainer, text);

    }

    public void clickCheckoutLink() {
        clickOn(checkoutLink);
    }

    public void enterCouponCode(String couponCode) {
        typeInto(couponCodeField, couponCode);
    }

    public void clickApplyCouponButton() {
        clickOn(applyCouponButtor);
        basePage.waitABit(2000);
    }

    public boolean verifyCouponCodeIsDisplayedInCartTotals(String couponCode) {
        return cartTotalsContainer.containsText(couponCode);
    }

    private Integer calculatedCartTotal;
    public boolean verifyCartTotalCalculationWithDiscount(){
        calculatedCartTotal = cartSubtotalValue - cartDiscountValue;
        return calculatedCartTotal.equals(cartTotalValue);
    }

    private Integer calculatedCartDiscount;
    public boolean verifyPercentageDiscountCalculation(Integer discountPercentage){
        calculatedCartDiscount = (cartSubtotalValue * discountPercentage)/100;
        return calculatedCartDiscount.equals(cartDiscountValue);

    }

}