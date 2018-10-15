package org.dbc.admin.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * @Author: ray, liu.
 * @Date: 2018/10/9 15:58
 */
@Document(collection = "Sequence")
@Data
@EqualsAndHashCode(callSuper=false)
public class Sequence {
    public static final String FIELD_SEQ_ID = "seqId";
    public static final String FIELD_APP_ID = "appId";
    public static final String FIELD_ROBOT_ID = "robotId";
    public static final String FIELD_PROJECT_CODE = "projectCode";
    @Field("seqId")
    private long seqId;
    @Field("appId")
    private String appId;
    @Field("robotId")
    private String robotId;
    @Field("projectCode")
    private String projectCode;


    public long getSeqId() {
        return seqId;
    }

    public void setSeqId(long seqId) {
        this.seqId = seqId;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getRobotId() {
        return robotId;
    }

    public void setRobotId(String robotId) {
        this.robotId = robotId;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }
}
