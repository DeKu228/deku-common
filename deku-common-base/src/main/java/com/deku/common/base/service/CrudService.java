package com.deku.common.base.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * All rights Reserved, Designed by xxxx
 *
 * @Author: deku
 * @Date: 2019/11/2
 */
public interface CrudService<DOMAIN, ID> {

    @NonNull
    List<DOMAIN> listAll();

    @NonNull
    List<DOMAIN> listAll(@NonNull Sort sort);

    @NonNull
    Page<DOMAIN> listAll(@NonNull Pageable pageable);

    @NonNull
    List<DOMAIN> listAllByIds(@Nullable Collection<ID> ids);

    @NonNull
    List<DOMAIN> listAllByIds(@Nullable Collection<ID> ids, @NonNull Sort sort);

    @NonNull
    Optional<DOMAIN> fetchById(@NonNull ID id);

    @NonNull
    DOMAIN getById(@NonNull ID id);

    @Nullable
    DOMAIN getByIdOfNullable(@NonNull ID id);

    boolean existsById(@NonNull ID id);

    void mustExistById(@NonNull ID id);

    long count();

    @NonNull
    @Transactional
    DOMAIN create(@NonNull DOMAIN domain);

    @NonNull
    @Transactional
    List<DOMAIN> createInBatch(@NonNull Collection<DOMAIN> domains);

    @NonNull
    @Transactional
    DOMAIN update(@NonNull DOMAIN domain);

    void flush();

    @NonNull
    @Transactional
    List<DOMAIN> updateInBatch(@NonNull Collection<DOMAIN> domains);

    @NonNull
    @Transactional
    DOMAIN removeById(@NonNull ID id);

    @Nullable
    @Transactional
    DOMAIN removeByIdOfNullable(@NonNull ID id);

    @Transactional
    void remove(@NonNull DOMAIN domain);

    @Transactional
    void removeInBatch(@NonNull Collection<ID> ids);

    @Transactional
    void removeAll(@NonNull Collection<DOMAIN> domains);

    @Transactional
    void removeAll();
}
