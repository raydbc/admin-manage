package org.dbc.admin.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

/**
 * @Author: ray, liu.
 * @Date: 2018/10/11 15:08
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class BaseEntity {

    /**
     * Id(AI)
     **/
    protected Integer id;

    /**
     * 创建时间
     **/
    @CreatedDate
    protected java.util.Date createTime;

    /**
     * 创建人
     **/
    @CreatedBy
    protected String createBy;

    /**
     * 修改时间
     **/
    @LastModifiedDate
    protected java.util.Date modifiedTime;

    /**
     * 修改人
     **/
    @LastModifiedDate
    protected String modifiedBy;

    /**
     * 1 有效 0无效
     **/
    protected Integer enabled = 1;

    /**
     * 版本
     **/
    protected Integer version;
}

