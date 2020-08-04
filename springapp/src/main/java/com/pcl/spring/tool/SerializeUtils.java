package com.pcl.spring.tool;

import com.pcl.spring.bean.UserSession;

import java.io.*;

/**
 * 序列化工具
 *
 * @author pengchenglin
 * @create 2020-07-22 20:09
 */
public class SerializeUtils  {

    /**
     * 序列化对象
     *
     * @param seria
     * @return
     * @throws IOException
     */
    public static <T> String serialize(T seria) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(seria);
        String serStr = byteArrayOutputStream.toString("ISO-8859-1");
        serStr = java.net.URLEncoder.encode(serStr, "UTF-8");
        objectOutputStream.close();
        byteArrayOutputStream.close();
        return serStr;
    }

    /**
     * 反序列化对象
     * @param <T>
     *
     * @param str
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @SuppressWarnings("unchecked")
    public static <T> T deserialize(String str) throws IOException,
            ClassNotFoundException {
        String redStr = java.net.URLDecoder.decode(str, "UTF-8");
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(
                redStr.getBytes("ISO-8859-1"));
        ObjectInputStream objectInputStream = new ObjectInputStream(
                byteArrayInputStream);
        T seria= (T) objectInputStream.readObject();
        objectInputStream.close();
        byteArrayInputStream.close();
        return seria;
    }
}
