package org.fasttrack.serenity.steps;


import net.thucydides.core.annotations.Step;
import org.fasttrack.serenity.pages.CartPage;
import org.fasttrack.serenity.pages.ProductPage;
import org.junit.Assert;

public class CartSteps {

    private CartPage cartPage;
    private ProductPage productPage;

    @Step
    public void checkProductIsInCart(String productName){
        Assert.assertTrue("The product was not added to the cart",cartPage.isProductInCart(productName));
    }


    @Step
    public void changeProductQuantity(String quantity){
        cartPage.fillInQuantity(quantity);
        cartPage.updateCart();
    }

    @Step
    public void checkProductQuantityIsUpdated(Integer newQuantity){
        cartPage.getProductQuantity();
        Assert.assertTrue("The product quantity was not changed",cartPage.checkProductQuantityIsUpdatedInCart(newQuantity));
    }

    @Step
    public void removeFirstItemFromCart(){
        cartPage.removeItemFromCart();
    }

//method used to validate test results
    @Step
    public void displayCartElements(){
        cartPage.displayCartProductNames();
    }

    @Step
    public void checkProductWasRemovedFromCart(String removedProductName){
        Assert.assertTrue("The product was not removed from the cart",cartPage.checkProductWasRemovedFromCart(removedProductName));
    }

    @Step
    public void wait(int time){
    try{
        Thread.sleep(time);
    }catch (InterruptedException e) {
    }

    }

    @Step
    public void undoRemoveItemFromCart(){
        cartPage.undoRemoveItemFromCart();
    }

    @Step
    public void cartSubtotalCalculation(){
        cartPage.getFirstProductPrice();
        cartPage.getProductQuantity();
        cartPage.getCartProductsSubtotals();
        cartPage.calculateCartFirstLineSubtotal();

    }

    @Step
    public void verifyProductSubtotalCalculation(){
        Assert.assertTrue("The subtotal is not correct",cartPage.verifyCartFirstLineSubtotal());
    }
}
