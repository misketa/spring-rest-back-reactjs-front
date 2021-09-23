package com.OnlineStore.utils;

import com.OnlineStore.model.role.RoleName;
import com.OnlineStore.security.UserPrincipal;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class ApplicationUtilities{

        public static boolean isUserProdavac(UserPrincipal userPrincipal) {
            return userPrincipal.getAuthorities().contains(new SimpleGrantedAuthority(RoleName.ROLE_PRODAVAC.toString()));
        }
}
