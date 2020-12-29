package com.lh.puzzle.model;

import org.apache.commons.lang3.ObjectUtils;

/**
 * 一个节点有6个链接，组成一个循环链表
 * 每个区块选择一个初始节点，初始节点到下一个节点的链接是单向的
 * 每个节点只有一个入口，以此保证循环时不会重复判断
 *
 * @auther: loneyfall
 * @date: 2020/12/28
 * @description: 节点之间的链接
 */
public class Link {
    private Node node;
    private Link next;

    public Link() {
    }

    public Link(Node node) {
        this.node = node;
    }

    public boolean linked() {
        return ObjectUtils.isNotEmpty(this.node);
    }

    public Node getNode() {
        return node;
    }

    public void setNode(Node node) {
        this.node = node;
    }

    public Link getNext() {
        return next;
    }

    public void setNext(Link next) {
        this.next = next;
    }
}
