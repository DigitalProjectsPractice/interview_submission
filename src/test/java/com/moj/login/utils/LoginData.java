package com.moj.login.utils;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginData {
    private String result;
    private String username;
    private String password;
}
