package com.lh.puzzle.util;

import com.alibaba.fastjson.JSON;
import com.lh.puzzle.model.Map;
import com.lh.puzzle.model.Node;
import com.lh.puzzle.model.NodeTmp;
import org.junit.Test;

/**
 * @auther: loneyfall
 * @date: 2020/12/28
 * @description:
 */
public class NodeUtilsTest {

    @Test
    public void testInitNodeTmpByJson() {
        NodeTmp nodeTmp = NodeUtils.initNodeTmpByJson(JSON.parseObject("{\"2\":{\"2\":{\"1\":{\"1\":{}}}}}"));
        System.out.println(nodeTmp);
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
}
