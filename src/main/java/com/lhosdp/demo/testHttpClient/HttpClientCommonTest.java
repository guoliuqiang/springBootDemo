package com.lhosdp.demo.testHttpClient;

import org.dom4j.DocumentHelper;
import org.dom4j.DocumentType;
import org.dom4j.Element;
import org.springframework.http.RequestEntity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HttpClientCommonTest {

    public static void main(String[] args) throws Exception{
        OrderNNKRequest request = new OrderNNKRequest();


        createXmlString("1000000007|100000000000007|lkm20091231170808419|1|5000|120||xml|9|007KA_KM|1.0.1.4|||13460123455\n" +
                "|20091231170808||http://58.61.38.4/MCtestRs.php|", "E2F3E0F50EA267C155F7771C7619A655");



    }

    /**
     * 生成xml格式的字符串
     * @return
     */
    public static String createXmlString(String orderinfo, String sign){
        //创建document对象
        org.dom4j.Document document = DocumentHelper.createDocument();
        //设置编码
        document.setXMLEncoding("UTF-8");

        //创建根节点
        Element requestData = document.addElement("html");
        //在根节点加入username子节点
        Element head = requestData.addElement("head");
        //往head节点添加子节点
        Element title = head.addElement("title");
        title.setText("007Ka直充交易");
        //加入password子节点
        Element body = requestData.addElement("body");
        //添加内容
        Element form = body.addElement("form");
        form.addAttribute("name", "test");
        form.addAttribute("action", "https://ceshi.007ka.cn/ recvcdkey.php");
        form.addAttribute("method", "post");

        Element input1 = body.addElement("input");
        input1.addAttribute("type","hidden");
        input1.addAttribute("name","Orderinfo");
        input1.addAttribute("value", orderinfo);

        Element input2 = body.addElement("input");
        input2.addAttribute("type","hidden");
        input2.addAttribute("name","Sign");
        input2.addAttribute("value",sign);
        //将document对象转换成字符串
        String xml = document.asXML();
        System.out.println(xml);
        return xml;
    }

//    public static String sendXmlPost(String url, String xml,String appId,String appKey) {
//        // 设置默认请求头
//        StringBuffer response = new StringBuffer();
//        HttpClient client = new HttpClient();
//        PostMethod method = new PostMethod(url);
//        BufferedReader reader = null;
//        try {
//            method.setRequestHeader("X-APP-ID",appId);
//            method.setRequestHeader("X-APP-KEY",appKey);
//            RequestEntity requestEntity = new StringRequestEntity(xml, "application/xml", "UTF-8");// application/json,text/xml,text/plain
//            method.setRequestEntity(requestEntity);
//            client.executeMethod(method);
//            reader = new BufferedReader(new InputStreamReader(method.getResponseBodyAsStream(), "UTF-8"));
//            String line;
//            while ((line = reader.readLine()) != null) {
//                if (false) {
//                    response.append(line).append(System.getProperty("line.separator"));
//                } else {
//                    response.append(line);
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }finally {
//            try {
//                if (reader != null) {
//                    reader.close();
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            method.releaseConnection();
//        }
//        return response.toString();
//
//
//    }


}
