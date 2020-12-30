package com.lh.puzzle.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lh.puzzle.model.NodeTmp;

import java.io.*;

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

    /**
     * 通过json文件生成节点模版数据
     *
     * @param path
     * @return
     */
    public static NodeTmp initNodeTmpByJsonFile(String path) {
        JSONObject json1 = JSON.parseObject(readJsonFile(path));
        return NodeUtils.initNodeTmpByJson(json1);
    }

    //读取json文件
    private static String readJsonFile(String fileName) {
        String jsonStr = "";
        try {
            File jsonFile = new File(fileName);
            FileReader fileReader = new FileReader(jsonFile);
            Reader reader = new InputStreamReader(new FileInputStream(jsonFile), "utf-8");
            int ch = 0;
            StringBuffer sb = new StringBuffer();
            while ((ch = reader.read()) != -1) {
                sb.append((char) ch);
            }
            fileReader.close();
            reader.close();
            jsonStr = sb.toString();
            return jsonStr;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
