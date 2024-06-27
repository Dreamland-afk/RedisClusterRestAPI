package com.arc.redis.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * @author Swapnadeep Mondal
 * User configuration example:
 * 
 * <pre>
 * {
 *   "userName": "name",
 *   "password": "password",
 *   "isEnable": 1,
 *   "roles": {
 *     "roles": "admin"
 *   }
 * }
 * </pre>
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private String userName;
    private String password;
    private int isEnable;
    private RolesDTO roles;
}