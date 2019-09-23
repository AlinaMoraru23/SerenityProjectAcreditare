package org.fasttrack.serenity.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://qa5.fasttrackit.org:8008/wp-admin/edit.php?post_type=shop_coupon")
public class AdminCouponsPage extends BasePageAdmin {

    protected BasePageAdmin basePageAdmin;

    @FindBy(css = ".page-title-action")
    private WebElementFacade addCouponButton;

    @FindBy(id = "title")
    private WebElementFacade couponTitleField;

    @FindBy(id = "discount_type")
    private WebElementFacade discountTypeDropdown;

    @FindBy(id = "coupon_amount")
    private WebElementFacade couponAmountField;

    @FindBy(id ="publish")
    private WebElementFacade publishButton;

    @FindBy(id="post-search-input")
    private WebElementFacade searchField;

    public void clickAddCoupon() {
        clickOn(addCouponButton);
    }

    public void setCouponTitle(String couponTitle) {
        typeInto(couponTitleField, couponTitle);
    }

    public void selectDiscountType(String discountType) {
        clickOn(discountTypeDropdown);
        discountTypeDropdown.selectByVisibleText(discountType);
    }

    public void setCouponAmount(String couponAmount) {
        typeInto(couponAmountField, couponAmount);
    }


    public void clickPublishButton(){
        clickOn(publishButton);
    }

    public void setSearchField(String searchItem){
        typeInto(searchField,searchItem);
    }

}
