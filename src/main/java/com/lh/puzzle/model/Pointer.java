package com.lh.puzzle.model;

/**
 * 棋盘中的一个点位
 * 就是二维数组的坐标
 *
 * @auther: loneyfall
 * @date: 2020/12/29
 * @description: 点位
 */
public class Pointer {
    private int x;
    private int y;

    public Pointer(int i, int j) {
        x = i;
        y = j;
    }

    public Pointer next(int way) {
        // todo
        return null;
    }

    @Override
    public String toString() {
        return "Pointer{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
