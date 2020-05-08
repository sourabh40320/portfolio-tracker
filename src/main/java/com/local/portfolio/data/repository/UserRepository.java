package com.local.portfolio.data.repository;

import com.local.portfolio.data.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Sourabh
 **/
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
