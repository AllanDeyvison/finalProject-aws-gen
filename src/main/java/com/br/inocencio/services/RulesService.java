package com.br.inocencio.services;

import com.br.inocencio.models.Users;
import com.br.inocencio.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RulesService {

    @Autowired
    private UsersRepository usersRepository;

    public Optional<Users> existingUser(Users user){
        Optional<Users> existingUser = usersRepository.findUserByEmail(user.getEmail());
        if (existingUser.isPresent())  {
            return Optional.empty();
        }else {
            usersRepository.save(user);
            return Optional.ofNullable(usersRepository.save(user));
        }
    }

}
