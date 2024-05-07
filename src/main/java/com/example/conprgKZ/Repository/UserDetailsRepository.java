package com.example.conprgKZ.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.conprgKZ.Entity.UserDetails;
@Repository
public interface UserDetailsRepository extends JpaRepository<UserDetails,Integer> {

	Optional<UserDetails> findByEmail(String email);
	
    Optional<UserDetails> findByEmailAndPassword(String email, String Password);

}
