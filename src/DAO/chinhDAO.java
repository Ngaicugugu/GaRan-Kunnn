/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.util.List;

/**
 *
 * @author Thinkpad T490
 */
public abstract class chinhDAO <E,K> {
    abstract public void insert(E entity);
    abstract public void update(E entity);
    abstract public void delete(K key);
    abstract public List<E> selectAll();
    abstract public E selectByid(K key);
    abstract protected List<E> selectBySql(String sql,Object...agrs);
}
