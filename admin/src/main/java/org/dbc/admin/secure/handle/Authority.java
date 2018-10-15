package org.dbc.admin.secure.handle;

import java.io.Serializable;

/**
 * @Author: ray, liu.
 * @Date: 2018/10/4 16:59
 */
public class Authority implements Serializable {
    private static final long serialVersionUID = 1L;
    public static final String ANONYMOUS = "ROLE_ANONYMOUS";
    public static final String ADMIN = "ROLE_ADMIN";
    public static final String USER = "ROLE_USER";
    public static final String DEVELOPER = "ROLE_DEVELOPER";
    public static final String ROLE_SAMPLE_SOUND_USER = "ROLE_SAMPLE_SOUND_USER";
    public static final String[] AUTHENTICATED_ROLES = new String[]{"ROLE_ADMIN", "ROLE_USER", "ROLE_DEVELOPER", "ROLE_SAMPLE_SOUND_USER"};
    public static final String[] All_ROLES = new String[]{"ROLE_ANONYMOUS", "ROLE_ADMIN", "ROLE_USER", "ROLE_DEVELOPER", "ROLE_SAMPLE_SOUND_USER"};
    public static final String All_ROLES_STRING = "ROLE_ANONYMOUS,ROLE_ADMIN,ROLE_USER,ROLE_DEVELOPER,ROLE_SAMPLE_SOUND_USER";
    private String authorityName;
    private Boolean enabled;

    public Authority() {
    }

    public String getAuthorityName() {
        return this.authorityName;
    }

    public void setAuthorityName(String authorityName) {
        this.authorityName = authorityName;
    }

    public Boolean getEnabled() {
        return this.enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        } else if (that == null) {
            return false;
        } else if (this.getClass() != that.getClass()) {
            return false;
        } else {
            boolean var10000;
            label48: {
                Authority other = (Authority)that;
                if (this.getAuthorityName() == null) {
                    if (other.getAuthorityName() != null) {
                        break label48;
                    }
                } else if (!this.getAuthorityName().equals(other.getAuthorityName())) {
                    break label48;
                }

                if (this.getEnabled() == null) {
                    if (other.getEnabled() != null) {
                        break label48;
                    }
                } else if (!this.getEnabled().equals(other.getEnabled())) {
                    break label48;
                }

                var10000 = true;
                return var10000;
            }

            var10000 = false;
            return var10000;
        }
    }
@Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + (this.getAuthorityName() == null ? 0 : this.getAuthorityName().hashCode());
        result = 31 * result + (this.getEnabled() == null ? 0 : this.getEnabled().hashCode());
        return result;
    }
}

