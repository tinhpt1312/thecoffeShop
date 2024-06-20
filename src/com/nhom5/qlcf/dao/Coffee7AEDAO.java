/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom5.qlcf.dao;

import java.util.List;

/**
 *
 * @author Asus
 */
abstract public class Coffee7AEDAO<EntityType, KeyType> {
    abstract public void insert(EntityType entity);
    abstract public void update(EntityType entity);
    abstract public void delete(KeyType id);
    abstract public EntityType selectById(KeyType id);
    abstract public List<EntityType> selectAll();
    abstract protected List<EntityType> selectBySql(String sql, Object...args);
}
