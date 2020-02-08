package presentation;

public enum ProductType {

    BRAKE("BRAKE"), CAR("CAR"), LAMP("LAMP"), RADIO("RADIO"), RIM("RIM"), SPOILER("SPOILER"), TIRE("TIRE");

    private String productType;

    ProductType(String product) {
        this.productType = product;
    }

    public static ProductType getByName(String product) {
        for (ProductType productType : values()) {
            if (productType.getValue().equals(product)) {
                return productType;
            }
        }
        return null;
    }

    public String getValue() {
        return productType;
    }

}