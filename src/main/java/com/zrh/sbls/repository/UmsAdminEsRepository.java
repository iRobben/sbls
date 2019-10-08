package com.zrh.sbls.repository;

import com.zrh.sbls.model.UmsAdmin;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * <p>
 *
 * </p>
 *
 * @author zhangrenhua
 * @date 2019/8/6
 */
public interface UmsAdminEsRepository extends ElasticsearchRepository<UmsAdmin,Long> {
}
