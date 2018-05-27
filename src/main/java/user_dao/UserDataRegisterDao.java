/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user_dao;


import java.util.List;
import persistence.pojo.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author eslam java
 */
public interface UserDataRegisterDao extends CrudRepository<Users, Integer>{

   Users findByEmail(@Param("email")String email);
   Users updateUserImageUrl(@Param("imgUrl")String imageUrl,@Param("email")String email);
   
   
    
}
