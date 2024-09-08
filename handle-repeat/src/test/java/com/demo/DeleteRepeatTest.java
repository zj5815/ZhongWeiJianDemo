package com.demo;

import org.junit.Test;

/**
 * @author zwj
 * @date 2024/8/30 13:23
 * @desc
 */
public class DeleteRepeatTest {

    /**
     * 测试
     */
    @Test
    public void testHandle(){
        DeleteRepeat deleteRepeat = new DeleteRepeat();
        deleteRepeat.handel("aabcccbbad");
    }
}