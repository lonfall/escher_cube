package com.lh.puzzle.model;

import org.apache.commons.lang3.ObjectUtils;

import java.util.Arrays;

/**
 * @auther: loneyfall
 * @date: 2020/12/28
 * @description: 节点数据模版，用于创建节点
 */
public class NodeTmp {
    private NodeTmp[] list;

    public NodeTmp() {
        list = new NodeTmp[6];
    }

    public NodeTmp[] getList() {
        return list;
    }

    public void add(int index, NodeTmp tmp) {
        if (ObjectUtils.isNotEmpty(tmp)) {
            list[index] = tmp;
        }
    }

    @Override
    public String toString() {
        return toString("");
    }

    public String toString(String tab) {
        String result = tab + "[] =>\n";
        tab += "\t";
        for (int i = 0; i < list.length; i++) {
            if (ObjectUtils.isNotEmpty(list[i])) {
                result += tab + "<" + (i + 1) + ">\n" + list[i].toString(tab) + "\n";
            }
        }
        return result;
    }
}
