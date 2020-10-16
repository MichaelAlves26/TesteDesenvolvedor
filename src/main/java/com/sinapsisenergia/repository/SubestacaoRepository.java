package com.sinapsisenergia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sinapisienergia.entity.Subestacao;

@Repository
public interface SubestacaoRepository extends JpaRepository<Subestacao, Long> {

}
