package com.muggle.common.user.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.springframework.security.core.GrantedAuthority;

import java.util.Date;

/**
 * poseidon_granted_authority实体类
 *
 * @author muggle
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
@ToString
public class PoseidonGrantedAuthority implements GrantedAuthority {
    /***/
    private String id;
    /***/
    private String authority;
    /***/
    private String permissionName;
    /***/
    private Boolean enable;
    /***/
    private String hashCode;
    /***/
    private Long createId;
    /***/
    private Date createTime;
    /***/
    private Long updateId;
    /***/
    private Date updateTime;
    /***/
    private Long deleteId;
    /***/
    private Date deleteTime;

    private String url;

    private String method;

}
