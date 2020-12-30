package com.lh.puzzle.model;

import com.lh.puzzle.view.LinkAndWay;
import org.apache.commons.lang3.ObjectUtils;

/**
 * 多个节点构成一个区块，代表拼图的一块
 * 每个节点包含一个6个对象的Link循环链表
 * 每个Link可能包含到下一个节点对象
 * 节点保存了Link链表的其中三个位点，代表每个旋转位置的起始位置
 *
 * @auther: loneyfall
 * @date: 2020/12/28
 * @description: 一个节点
 */
public class Node {
    private Link l1;
    private Link l2;
    private Link l3;

    // 当前旋转位置:1\2\3
    private int rotate;

    private int count = 0;

    public Node(NodeTmp tmp) {
        // 根据模版生成节点，生成第一个旋转点位
        NodeTmp[] list = tmp.getList();
        if (list.length != 6) {
            return;
        }

        this.rotate = 1;
        if (ObjectUtils.isNotEmpty(list[0])) {
            this.count++;
            this.l1 = new Link(new Node(list[0]));
        } else {
            this.l1 = new Link();
        }
        Link prev = l1;
        for (int i = 1; i < list.length; i++) {
            Link li;
            if (ObjectUtils.isNotEmpty(list[i])) {
                this.count++;
                li = new Link(new Node(list[i]));
            } else {
                li = new Link();
            }
            prev.setNext(li);
            prev = li;
        }
        prev.setNext(l1);

        l2 = l1.getNext().getNext();
        l3 = l2.getNext().getNext();
    }

    public LinkAndWay[] getNextWay(int rotate) {
        if (count <= 0) {
            return null;
        }
        LinkAndWay[] result = new LinkAndWay[count];
        int index = 0;

        Link start;
        if (1 == rotate) {
            start = l1;
        } else if (2 == rotate) {
            start = l2;
        } else {
            start = l3;
        }
        for (int i = 1; i <= 6; i++) {
            if (start.linked()) {
                result[index++] = new LinkAndWay(start, i);
            }
            start = start.getNext();
        }
        return result;
    }

    /**
     * 旋转区块，从第一个节点开始
     *
     * @return
     */
    public Node rotate() {
        if (3 == rotate) {
            rotate = 1;
        } else {
            rotate++;
        }
        Link pinter = l1;
        for (int i = 0; i < 6; i++, pinter = pinter.getNext()) {
            if (pinter.linked()) {
                pinter.getNode().rotate();
            }
        }
        return this;
    }

    public int getRotate() {
        return rotate;
    }

    public int getCount() {
        return count;
    }
}
