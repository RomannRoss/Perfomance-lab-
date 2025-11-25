package enums;

public enum DepartmentNaming {
    SWAGLABS("Swag Labs"),
    CART("Your Cart");

    private final String displayName;

    DepartmentNaming(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
