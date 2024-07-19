package com.wallet.Wallet.Repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wallet.Wallet.Entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
    Optional<User> findByPhoneNumber(String phoneNumber);

    Optional<User> findByEmail(String email);

    List<User> findByFirstNameAndLastName(String firstName, String lastName);

}
