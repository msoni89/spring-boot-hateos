package com.sample.pagination.repository;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.sample.pagination.entity.PinCodeEntity;

public interface IPinCodeRepository extends PagingAndSortingRepository<PinCodeEntity, Long>{
	
}
