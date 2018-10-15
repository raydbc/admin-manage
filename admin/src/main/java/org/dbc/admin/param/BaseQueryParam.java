package org.dbc.admin.param;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;
import org.dbc.admin.utils.DateJsonDeserialize;

import javax.validation.constraints.Max;
import java.io.Serializable;

/**
 * @Author: ray, liu.
 * @Date: 2018/10/11 22:48
 */
@Data
public class BaseQueryParam implements Serializable {
    /**
     * Id(AI)
     **/
    protected Integer id = 0;

    /**
     * 版本
     **/
    protected Integer version = 0;

    /**
     * 创建时间
     **/
    protected java.util.Date createTime;

    /**
     * 创建人
     **/
    protected String createBy;

    /**
     * 修改时间
     **/
    protected java.util.Date modifiedTime;

    /**
     * 修改人
     **/
    protected String modifiedBy;

    /**
     * 1 有效 0无效
     **/
    protected Integer enabled = 1;

    /**
     * 查询条件额外字段开始日期
     */
    @JsonDeserialize(using = DateJsonDeserialize.class)
    protected java.util.Date createTimeBegin;
    /**
     * 查询条件额外字段开始日期
     */
    @JsonDeserialize(using = DateJsonDeserialize.class)
    protected java.util.Date createTimeEnd;

    /**哪一页**/
    protected int pageNum = 0;

    /**每页返回的数量**/
    @Max(100)
    protected int listSize = 20;
}