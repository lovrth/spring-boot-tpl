package com.lovrth.tpl.v1.model;

import com.amdelamar.jhash.Hash;
import com.amdelamar.jhash.algorithms.Type;
import com.amdelamar.jhash.exception.InvalidHashException;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String nickname;

    private String password;

    /**
     * 设置密文密码
     *
     * @param password 原始密码
     */
    public void setPasswordEncrypt(String password) {
        char[] chars = password.toCharArray();
        this.password = Hash.password(chars).algorithm(Type.PBKDF2_SHA256).create();
    }

    /**
     * 验证加密密码
     *
     * @param password 密文密码
     * @return valid
     */
    public boolean verify(String password) {
        char[] chars = password.toCharArray();
        try {
            return Hash.password(chars).verify(this.password);
        } catch (InvalidHashException e) {
            return false;
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nickname=" + nickname +
                ", password=" + password +
                "}";
    }
}
