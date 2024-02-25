package com.br.inocencio.repositories;

import com.br.inocencio.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer>{
    public Optional<Users> findUserByEmail(String email);
}
