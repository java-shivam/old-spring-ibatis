package com.example.service;

import com.example.model.User;
import com.ibatis.sqlmap.client.SqlMapClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    private SqlMapClient sqlMapClient;

    public User getUserById(int id) throws Exception {
        return (User) sqlMapClient.queryForObject("UserMapper.getUserById", id);
    }

    public Map<String, Object> callStoredProcedure(int id) throws Exception {
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        sqlMapClient.queryForObject("UserMapper.callGetUserById", params);
        return params;
    }
}