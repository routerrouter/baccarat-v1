/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ao.co.proevolution.baccarat.util;

import java.util.List;

/**
 *
 * @author filme
 */
public interface IDao<T> {
    
    public boolean save(T obj);
    public boolean update(T obj);
    public boolean saveOrUpdate(T obj);
    public List<T> findAll();
    public boolean delete(Long id);
}
