/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.akajdev.hashing;

import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author CGAbhishek.Agrawal
 */
public class JavaMD5HashUsingCodec {

    public static void main(String[] args) {

        String password = "MyPassword123";

        System.out.println(DigestUtils.md5Hex(password));

    }
}
