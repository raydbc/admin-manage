package org.dbc.admin.domain;

import lombok.Data;
import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.mapping.Field;
import java.util.Date;

/**
 * @Author: ray, liu.
 * @Date: 2018/10/4 16:31
 */
@Data
public class BaseModel {
    private static final long serialVersionUID = -1724006418603950L;
    public static final String FIELD_ID = "id";
    public static final String FIELD_CREATED_TIME = "createdTime";
    public static final String FIELD_CREATED_BY = "createdBy";
    public static final String FIELD_MODIFIED_TIME = "modifiedTime";
    public static final String FIELD_MODIFIED_BY = "modifiedBy";
    public static final String FIELD_ENABLED = "enabled";
    @Id
    protected String id;
    @Field("createdTime")
    @CreatedDate
    protected Date createdTime;
    @Field("createdBy")
    @CreatedBy
    protected String createdBy;
    @Field("modifiedTime")
    @LastModifiedDate
    protected Date modifiedTime;
    @Field("modifiedBy")
    @LastModifiedBy
    protected String modifiedBy;
    @Field("enabled")
    protected Boolean enabled = Boolean.valueOf(true);
}
