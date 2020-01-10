package presentation;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum UserRole {

    UNVERIFIED, USER, ADMIN

}
