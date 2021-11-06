package com.tutrit.registerservice.repository;

import com.tutrit.registerservice.bean.Slot;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RestResource;

@RestResource
public interface SlotDataRepository extends PagingAndSortingRepository<Slot, Long> {
    Page<Slot> findAllByDuration(long duration, Pageable pageable);
}
