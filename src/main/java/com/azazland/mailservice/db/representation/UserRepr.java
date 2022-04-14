package com.azazland.mailservice.db.representation;

import lombok.Data;

@Data
public class UserRepr {

    private String mail;
    private int userId;
    private String name;
}
