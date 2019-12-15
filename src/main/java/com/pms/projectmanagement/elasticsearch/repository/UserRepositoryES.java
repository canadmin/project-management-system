package com.pms.projectmanagement.elasticsearch.repository;

import com.pms.projectmanagement.elasticsearch.model.UserES;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepositoryES extends ElasticsearchRepository<UserES,String> {

    List<UserES> findAllByUsernameContaining(String id);

    Optional<UserES> findById(String id);

}
