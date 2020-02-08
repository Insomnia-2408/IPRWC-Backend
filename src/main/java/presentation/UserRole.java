package presentation;

public enum UserRole {

    UNVERIFIED("UNVERIFIED"), USER("USER"), ADMIN("ADMIN");

    private String role;

    UserRole(String role) {
        this.role = role;
    }

    public static UserRole getByName(String roleName) {
        for (UserRole role : values()) {
            if (role.getValue().equals(roleName)) {
                return role;
            }
        }
        return UserRole.USER;
    }

    public String getValue() {
        return role;
    }

}