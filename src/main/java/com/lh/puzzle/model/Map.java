package com.lh.puzzle.model;

import com.lh.puzzle.view.LinkAndWay;

/**
 * 模拟拼图基座
 * 可以抽象为一个9层的双金字塔结构的二维数组
 *
 * @auther: loneyfall
 * @date: 2020/12/29
 * @description: 棋盘
 */
public class Map {
    private boolean[][] maps;

    public Map() {
        maps = new boolean[][]{new boolean[5], new boolean[6], new boolean[7], new boolean[8], new boolean[9], new boolean[8], new boolean[7], new boolean[6], new boolean[5]};
    }

    /**
     * 验证区块是否能放进棋盘
     *
     * @param node
     * @param pointer
     * @param rotate
     * @return
     */
    public boolean verification(Node node, Pointer pointer, int rotate) {
        if (pointer.verification(this)) {
            LinkAndWay[] ways = node.getNextWay(rotate);
            if (ways != null) {
                for (int i = 0; i < ways.length; i++) {
                    Pointer next_pointer = pointer.next(ways[i].getWay());
                    if (null == next_pointer || !next_pointer.verification(this)) {
                        return false;
                    }
                    if (!verification(ways[i].getLink().getNode(), next_pointer, rotate)) {
                        return false;
                    }
                }
            }
        } else {
            return false;
        }
        return true;
    }

    /**
     * 区块添加进棋盘
     *
     * @param node
     * @param pointer
     * @param rotate
     */
    public void add(Node node, Pointer pointer, int rotate) {
        maps[pointer.getX()][pointer.getY()] = true;

        LinkAndWay[] ways = node.getNextWay(rotate);
        if (ways != null) {
            for (int i = 0; i < ways.length; i++) {
                Pointer next_pointer = pointer.next(ways[i].getWay());
                add(ways[i].getLink().getNode(), next_pointer, rotate);
            }
        }
    }

    public boolean[][] getMaps() {
        return maps;
    }

    /**
     * 清空棋盘
     */
    public void clear() {
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length; j++) {
                maps[i][j] = false;
            }
        }
    }

    public void clear(Node node, Pointer pointer, int rotate) {
        maps[pointer.getX()][pointer.getY()] = false;

        LinkAndWay[] ways = node.getNextWay(rotate);
        if (ways != null) {
            for (int i = 0; i < ways.length; i++) {
                Pointer next_pointer = pointer.next(ways[i].getWay());
                clear(ways[i].getLink().getNode(), next_pointer, rotate);
            }
        }
    }
}
