package loilt.cart;

import java.io.Serializable;
import loilt.mobile.MobileDTO;

public class CartItem implements Serializable {

    private MobileDTO mobile;
    private int quantity;

    public CartItem() {
    }

    public CartItem(MobileDTO mobile, int quantity) {
        this.mobile = mobile;
        this.quantity = quantity;
    }

    /**
     * @return the mobile
     */
    public MobileDTO getMobile() {
        return mobile;
    }

    /**
     * @param mobile the mobile to set
     */
    public void setMobile(MobileDTO mobile) {
        this.mobile = mobile;
    }

    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return String.format("Name:%s|Quantity:%d", mobile.getMobileName(), quantity);
    }

}
