package com.sinapsisenergia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sinapisienergia.entity.RedeMt;

@Repository
public interface RedeMtRepository extends JpaRepository<RedeMt, Long> {

}
