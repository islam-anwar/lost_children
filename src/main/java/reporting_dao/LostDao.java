/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reporting_dao;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import persistence.pojo.Lost;


/**
 *
 * @author eslam java
 */
public interface LostDao extends CrudRepository<Lost, Integer>  {
    
        List<Lost>findByReturned(@Param("returned") String value);

    
}
