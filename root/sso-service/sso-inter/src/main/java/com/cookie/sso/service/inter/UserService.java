package com.cookie.sso.service.inter;

public interface UserService {
    public String getById(Integer id);

    public void deleteById(Integer id);

    public boolean save(String name);
}
