package com.mycompany.baitaplon.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired private UserRepository repo;

    public List<User> listAll(){
        return (List<User>) repo.findAll();
    }

//    public  List<User> findByKey(String keyword){
//        if(keyword != null){
//            return repo.findAllByKey(keyword);
//        }
//        return (List<User>) repo.findAll();

//    }

//    public  User listUser(Integer id){
//       Optional<User> result = repo.listAll(id);
//       return  result.get();
//    }

    public void save(User user) {
         repo.save(user);
    }

    public User get(Integer id) throws UserNotFoundException{
        Optional<User> result = repo.findById(id);
        if(result.isPresent()){
            return result.get();
        }else{
            throw new UserNotFoundException("Khong tim thay user voi ID: " + id);
        }
    }

    public void delete(Integer id){

        repo.deleteById(id);
    }
}
