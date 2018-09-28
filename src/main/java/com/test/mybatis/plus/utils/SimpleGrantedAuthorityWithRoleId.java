package com.test.mybatis.plus.utils;

import org.springframework.security.core.GrantedAuthority;
import java.util.HashMap;
import java.util.Map;

public class SimpleGrantedAuthorityWithRoleId implements GrantedAuthority {


    Map<String,Object> role=new HashMap<String,Object>();
    public SimpleGrantedAuthorityWithRoleId(String roletext,int id){
        role.put("text",roletext);
        role.put("id",id);
    }
    @Override
    public String getAuthority() {
        return (String)role.get("text");
    }
    public Map<String,Object> getRole(){
        return role;
    }
}