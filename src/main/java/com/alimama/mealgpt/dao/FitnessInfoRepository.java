package com.alimama.mealgpt.dao;

import com.alimama.mealgpt.entity.FitnessInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface FitnessInfoRepository extends JpaRepository<FitnessInfo, Integer> {
    List<FitnessInfo> findTop5ByUserNameOrderByIdDesc(String userName);
}