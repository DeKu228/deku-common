package com.deku.common.base.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

import java.util.List;

/**
 * All rights Reserved, Designed by xxxx
 *
 * @Author: deku
 * @Date: 2019/11/2
 */
public interface BaseRepository<DOMAIN, ID> extends JpaRepository<DOMAIN, ID> {

    @NonNull
    List<DOMAIN> findAllByIdIn(@NonNull Iterable<ID> ids, @NonNull Sort sort);

    @NonNull
    Page<DOMAIN> findAllByIdIn(@NonNull Iterable<ID> ids, @NonNull Pageable pageable);

    long deleteByIdIn(@NonNull Iterable<ID> ids);

}
