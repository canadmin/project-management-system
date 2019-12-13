package com.pms.projectmanagement.elasticsearch.repository;

import com.pms.projectmanagement.elasticsearch.model.UserES;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface UserRepositoryES extends ElasticsearchRepository<UserES,String> {

    List<UserES> findAllByUserName(String id);

}
