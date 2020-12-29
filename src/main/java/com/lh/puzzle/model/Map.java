package com.lh.puzzle.model;

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

    public void scanLinkTest(Pointer pointer) {

    }
}
