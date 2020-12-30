package com.lh.puzzle;

import com.alibaba.fastjson.JSON;
import com.lh.puzzle.model.Map;
import com.lh.puzzle.model.Node;
import com.lh.puzzle.model.Pointer;
import com.lh.puzzle.util.NodeUtils;

import java.util.Iterator;

/**
 * @auther: loneyfall
 * @date: 2020/12/30
 * @description: 暴力破解
 */
public class BruteForceMain {
    private static Node[] nodes = new Node[13];
    private static int[] rotates = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};

    public static void main(String[] args) {
        initNodes();
        Map map = new Map();
        boolean flag = map.verification(nodes[1], new Pointer(0, 0), 1);
        if (flag) {
            map.add(nodes[1], new Pointer(0, 0), 1);
        }
        System.out.println(map);
        // todo
//        循环所有可能的排列方向
//        int iterator = 0;
//        while (iterator < 13) {
//            System.out.println(JSON.toJSONString(rotates));
//            iterator = addRotates();
//        }
    }

    private static int addRotates() {
        int scan = 0;
        while (scan < 13) {
            if (rotates[scan] == 3) {
                scan++;
            } else {
                break;
            }
        }
        if (scan < 13) {
            rotates[scan]++;
            for (int i = scan - 1; i >= 0; i--) {
                rotates[i] = 1;
            }
        }
        return scan;
    }

    private static void initNodes() {
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new Node(NodeUtils.initNodeTmpByJsonFile("src/main/resources/nodes/node_" + (i + 1) + ".json"));
        }
    }
}
