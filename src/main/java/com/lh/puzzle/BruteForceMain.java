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

    private static Pointer[] initPoints() {
        return new Pointer[]{new Pointer(0, 0), new Pointer(0, 0), new Pointer(0, 0), new Pointer(0, 0),
                new Pointer(0, 0), new Pointer(0, 0), new Pointer(0, 0), new Pointer(0, 0), new Pointer(0, 0),
                new Pointer(0, 0), new Pointer(0, 0), new Pointer(0, 0), new Pointer(0, 0)};
    }

    public static void main(String[] args) {
        initNodes();
        Map map = new Map();
//        boolean flag = map.verification(nodes[1], new Pointer(0, 0), 1);
//        if (flag) {
//            map.add(nodes[1], new Pointer(0, 0), 1);
//        }
//        System.out.println(map);


//        循环所有可能的排列方向
        int iterator = 0;
        while (iterator < 13) {
//            System.out.println(JSON.toJSONString(rotates));
            bruteForce(map);
            map.clear();
            iterator = addRotates();
        }
    }

    /**
     * 开始破解！！！！！！！
     *
     * @param map
     */
    private static void bruteForce(Map map) {
//        System.out.println("开始破解：" + JSON.toJSONString(rotates));
        Pointer[] points = initPoints();
        int point_index = 0;
        while (true) {
            if (point_index >= 13) {
                // 如果成功遍历所有区块，代表所有区块都成功放入，破解成功
                System.out.println("破解成功" + JSON.toJSONString(rotates));
                System.out.println(JSON.toJSONString(points));
                break;
            }
            // 循环遍历当前区块，点位是否能够放入
            while (null != points[point_index]) {
                if (map.verification(nodes[point_index], points[point_index], rotates[point_index])) {
                    map.add(nodes[point_index], points[point_index], rotates[point_index]);
                    break;
                }
                points[point_index] = points[point_index].next();
            }
            // 如果点位为空，则代表循环完成过后还是无法放入
            if (null == points[point_index]) {
                // 当前点位还原
                points[point_index] = new Pointer(0, 0);
                // 点位遍历回滚
                point_index--;
                // 如果回滚到头了，代表所有可能性都已经遍历完，该组合无解
                if (point_index < 0) {
//                    System.out.println("破解失败,该组合无解！");
                    break;
                } else {
                    // 清除上个点位数据
                    map.clear(nodes[point_index], points[point_index], rotates[point_index]);
                    // 移动到下个点位
                    points[point_index] = points[point_index].next();
                }
            } else {
                // 否则代表放入成功，开始遍历下一个点位
                point_index++;
            }
        }
//        System.out.println("破解完成：" + JSON.toJSONString(rotates));
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
