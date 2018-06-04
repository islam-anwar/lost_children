/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reporting_dao;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import persistence.pojo.Found;
import persistence.pojo.Users;

/**
 *
 * @author eslam java
 */
public interface FoundDao extends CrudRepository<Found, Integer>  {
    
    List<Found>findByReturned(@Param("returned") String value);
    
}
