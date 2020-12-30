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

    private int[] lens = new int[]{5, 6, 7, 8, 9, 8, 7, 6, 5};

    public Pointer(int i, int j) {
        x = i;
        y = j;
    }

    /**
     * 验证坐标是否在棋盘上
     *
     * @param i
     * @param j
     * @return
     */
    public boolean verification(int i, int j) {
        if (i >= 0 && i < 9) {
            if (j >= 0 && j < lens[i]) {
                return true;
            }
        }
        return false;
    }

    /**
     * 验证是否能够落在棋盘上
     *
     * @param map
     * @return
     */
    public boolean verification(Map map) {
        if (verification() && !map.getMaps()[x][y]) {
            return true;
        }
        return false;
    }

    public boolean verification() {
        return verification(x, y);
    }

    /**
     * 获取附近下一个点位
     *
     * @param way
     * @return
     */
    public Pointer next(int way) {
        Pointer next = null;
        int i = -1, j = -1;
        switch (way) {
            case 1:
                i = x - 1;
                if (x < 5) {
                    j = y;
                } else {
                    j = y + 1;
                }
                if (verification(i, j)) {
                    next = new Pointer(i, j);
                }
                break;
            case 2:
                i = x;
                j = y + 1;
                if (verification(i, j)) {
                    next = new Pointer(i, j);
                }
                break;
            case 3:
                i = x + 1;
                if (x >= 4) {
                    j = y;
                } else {
                    j = y + 1;
                }
                if (verification(i, j)) {
                    next = new Pointer(i, j);
                }
                break;
            case 4:
                i = x + 1;
                if (x >= 4) {
                    j = y - 1;
                } else {
                    j = y;
                }
                if (verification(i, j)) {
                    next = new Pointer(i, j);
                }
                break;
            case 5:
                i = x;
                j = y - 1;
                if (verification(i, j)) {
                    next = new Pointer(i, j);
                }
                break;
            case 6:
                i = x - 1;
                if (x < 5) {
                    j = y - 1;
                } else {
                    j = y;
                }
                if (verification(i, j)) {
                    next = new Pointer(i, j);
                }
                break;
        }
        return next;
    }

    /**
     * 在棋盘上遍历下一个节点
     *
     * @return
     */
    public Pointer next() {
        if (y == lens[x] - 1) {
            if (x == 8) {
                return null;
            }
            y = 1;
            x++;
            return new Pointer(x, y);
        } else {
            y++;
            return new Pointer(x, y);
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Pointer{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
