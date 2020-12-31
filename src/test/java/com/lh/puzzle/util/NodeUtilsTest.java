package com.lh.puzzle.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lh.puzzle.model.Map;
import com.lh.puzzle.model.Node;
import com.lh.puzzle.model.NodeTmp;
import com.lh.puzzle.model.Pointer;
import org.junit.Test;

import java.io.*;

/**
 * @auther: loneyfall
 * @date: 2020/12/28
 * @description:
 */
public class NodeUtilsTest {


    @Test
    public void testInitNodeTmpByJson() {
//        NodeTmp nodeTmp = NodeUtils.initNodeTmpByJson(JSON.parseObject("{\"2\":{\"2\":{\"1\":{\"1\":{}}}}}"));
//        System.out.println(nodeTmp);
        NodeTmp nodeTmp1 = NodeUtils.initNodeTmpByJsonFile("src/main/resources/nodes/node_2.json");
        System.out.println(nodeTmp1);
    }

    @Test
    public void testNodeInit() {
        NodeTmp nodeTmp = NodeUtils.initNodeTmpByJson(JSON.parseObject("{\"2\":{\"2\":{\"1\":{\"1\":{}}}}}"));
        Node node = new Node(nodeTmp);
        System.out.println(node);
        node.rotate();
        node.rotate();
        node.rotate();
        node.rotate();
        System.out.println(node);
    }

    @Test
    public void testMapInit() {
        Map map = new Map();
        System.out.println(map);
    }

    @Test
    public void scanLinkTest() {
        scanLinkTest(new Pointer(4, 4));
    }

    private void scanLinkTest(Pointer pointer) {
        if (!pointer.verification()) {
            System.out.println("选中的点不在基座上");
            return;
        }
        for (int i = 1; i <= 6; i++) {
            System.out.println("scan next=>" + i);
            System.out.println(pointer.next(i));
        }
    }

    private void testMapAddAndClear() {
        Map map = new Map();

    }
}
