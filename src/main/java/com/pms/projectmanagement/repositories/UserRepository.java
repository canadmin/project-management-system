package com.pms.projectmanagement.repositories;

import com.pms.projectmanagement.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface UserRepository extends CrudRepository<User, UUID> {

}
