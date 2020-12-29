package com.lh.puzzle.util;

import com.alibaba.fastjson.JSONObject;
import com.lh.puzzle.model.NodeTmp;

/**
 * @auther: loneyfall
 * @date: 2020/12/28
 * @description:
 */
public class NodeUtils {

    /**
     * 通过json字符串生成节点模版数据
     *
     * @param json
     * @return
     */
    public static NodeTmp initNodeTmpByJson(JSONObject json) {
        if (json == null) {
            return null;
        }
        NodeTmp tmp = new NodeTmp();

        tmp.add(0, initNodeTmpByJson(json.getJSONObject("1")));
        tmp.add(1, initNodeTmpByJson(json.getJSONObject("2")));
        tmp.add(2, initNodeTmpByJson(json.getJSONObject("3")));
        tmp.add(3, initNodeTmpByJson(json.getJSONObject("4")));
        tmp.add(4, initNodeTmpByJson(json.getJSONObject("5")));
        tmp.add(5, initNodeTmpByJson(json.getJSONObject("6")));

        return tmp;
    }
}
