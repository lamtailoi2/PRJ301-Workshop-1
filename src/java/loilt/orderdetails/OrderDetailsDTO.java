package loilt.orderdetails;

public class OrderDetailsDTO {

    private int orderDetailId;
    private String userId;
    private String mobileId;
    private int quantity;
    private float price;
    private float total;

    public OrderDetailsDTO() {
    }

    public OrderDetailsDTO(int orderDetailId, String userId, String mobileId, int quantity, float price, float total) {
        this.orderDetailId = orderDetailId;
        this.userId = userId;
        this.mobileId = mobileId;
        this.quantity = quantity;
        this.price = price;
        this.total = total;
    }

    /**
     * @return the orderDetailId
     */
    public int getOrderDetailId() {
        return orderDetailId;
    }

    /**
     * @param orderDetailId the orderDetailId to set
     */
    public void setOrderDetailId(int orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * @return the mobileId
     */
    public String getMobileId() {
        return mobileId;
    }

    /**
     * @param mobileId the mobileId to set
     */
    public void setMobileId(String mobileId) {
        this.mobileId = mobileId;
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

    /**
     * @return the price
     */
    public float getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(float price) {
        this.price = price;
    }

    /**
     * @return the total
     */
    public float getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(float total) {
        this.total = total;
    }

}
