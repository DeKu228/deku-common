package com.deku.common.base.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.deku.common.base.utils.DateUtils;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

/**
 * Base entity.
 *
 * @author johnniang
 * @date 3/20/19
 */
@Data
@ToString
@MappedSuperclass
@EqualsAndHashCode
public class BaseEntity {

    //创建时间
    @Column(name = "create_time", columnDefinition = "timestamp default CURRENT_TIMESTAMP COMMENT '创建时间'")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    //更新时间
    @Column(name = "update_time", columnDefinition = "timestamp default CURRENT_TIMESTAMP COMMENT '更新时间'")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    //删除标识
    @Column(name = "deleted", columnDefinition = "TINYINT default 0 COMMENT '删除标识'")
    private Boolean deleted = false;

    @PrePersist
    protected void prePersist() {
        deleted = false;
        Date now = DateUtils.now();
        if (createTime == null) {
            createTime = now;
        }

        if (updateTime == null) {
            updateTime = now;
        }
    }

    @PreUpdate
    protected void preUpdate() {
        updateTime = new Date();
    }

    @PreRemove
    protected void preRemove() {
        updateTime = new Date();
    }

}
