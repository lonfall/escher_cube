package com.lh.puzzle.view;

import com.lh.puzzle.model.Link;

/**
 * @auther: loneyfall
 * @date: 2020/12/30
 * @description:
 */
public class LinkAndWay {
    private Link link;
    private int way;

    public LinkAndWay(Link link, int way) {
        this.link = link;
        this.way = way;
    }

    public Link getLink() {
        return link;
    }

    public void setLink(Link link) {
        this.link = link;
    }

    public int getWay() {
        return way;
    }

    public void setWay(int way) {
        this.way = way;
    }
}
