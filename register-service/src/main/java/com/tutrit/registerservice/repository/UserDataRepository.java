package com.tutrit.registerservice.repository;

import com.tutrit.registerservice.bean.Slot;
import com.tutrit.registerservice.bean.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RestResource;

@RestResource
public interface UserDataRepository extends PagingAndSortingRepository<User, Long> {
}
