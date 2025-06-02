package loilt.mobile;

public class CreateMobileError {

    private String idIsExisted;
    private String idNotValid;
    private String priceIsNotPositiveNumber;
    private String quantityIsNotPositiveNumber;
    private String yearOfProductionIsNotPositiveNumber;
    private String mobileNameLengthError;
    private String descriptionLengthError;

    public CreateMobileError() {
    }

    /**
     * @return the priceIsNotPositiveNumber
     */
    public String getPriceIsNotPositiveNumber() {
        return priceIsNotPositiveNumber;
    }

    /**
     * @param priceIsNotPositiveNumber the priceIsNotPositiveNumber to set
     */
    public void setPriceIsNotPositiveNumber(String priceIsNotPositiveNumber) {
        this.priceIsNotPositiveNumber = priceIsNotPositiveNumber;
    }

    /**
     * @return the quantityIsNotPositiveNumber
     */
    public String getQuantityIsNotPositiveNumber() {
        return quantityIsNotPositiveNumber;
    }

    /**
     * @param quantityIsNotPositiveNumber the quantityIsNotPositiveNumber to set
     */
    public void setQuantityIsNotPositiveNumber(String quantityIsNotPositiveNumber) {
        this.quantityIsNotPositiveNumber = quantityIsNotPositiveNumber;
    }

    /**
     * @return the yearOfProductionIsNotPositiveNumber
     */
    public String getYearOfProductionIsNotPositiveNumber() {
        return yearOfProductionIsNotPositiveNumber;
    }

    /**
     * @param yearOfProductionIsNotPositiveNumber the
     * yearOfProductionIsNotPositiveNumber to set
     */
    public void setYearOfProductionIsNotPositiveNumber(String yearOfProductionIsNotPositiveNumber) {
        this.yearOfProductionIsNotPositiveNumber = yearOfProductionIsNotPositiveNumber;
    }

    /**
     * @return the idIsExisted
     */
    public String getIdIsExisted() {
        return idIsExisted;
    }

    /**
     * @param idIsExisted the idIsExisted to set
     */
    public void setIdIsExisted(String idIsExisted) {
        this.idIsExisted = idIsExisted;
    }

    /**
     * @return the mobileNameLengthError
     */
    public String getMobileNameLengthError() {
        return mobileNameLengthError;
    }

    /**
     * @param mobileNameLengthError the mobileNameLengthError to set
     */
    public void setMobileNameLengthError(String mobileNameLengthError) {
        this.mobileNameLengthError = mobileNameLengthError;
    }

    /**
     * @return the descriptionLengthError
     */
    public String getDescriptionLengthError() {
        return descriptionLengthError;
    }

    /**
     * @param descriptionLengthError the descriptionLengthError to set
     */
    public void setDescriptionLengthError(String descriptionLengthError) {
        this.descriptionLengthError = descriptionLengthError;
    }

    /**
     * @return the idNotValid
     */
    public String getIdNotValid() {
        return idNotValid;
    }

    /**
     * @param idNotValid the idNotValid to set
     */
    public void setIdNotValid(String idNotValid) {
        this.idNotValid = idNotValid;
    }

}
