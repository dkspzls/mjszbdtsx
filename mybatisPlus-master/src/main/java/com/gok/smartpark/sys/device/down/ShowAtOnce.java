package com.gok.smartpark.sys.device.down;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.ByteArrayInputStream;

/*
* 下行接口：设置显示器显示
*/
public class ShowAtOnce {
    public static void main(String[] args) throws Exception {
        setLine1(args) ;
        setLine2(args) ;
        setLine3(args) ;
    }
    public static void setLine1(String[] args) throws Exception {
        final String CONTENT_TYPE_TEXT_JSON = "text/json";

        // 创建Httpclient对象
        CloseableHttpClient httpclient = HttpClients.createDefault();
        // 创建http POST请求
        String url = "http://192.168.168.188/Home/ShowAtOnce" ;
        HttpPost httpPost = new HttpPost(url);
        // 把自己伪装成浏览器。否则开源中国会拦截访问
        httpPost.setHeader("Content-Type", "application/x-www-form-urlencoded");
        String js="{\"key\":\"78E4A0164CCE064A4489013E66FB7A7D\",\"channelout\":2,\"textmum\":1,\"linenumber\":1,\"mobilemode\":0,\"stoptime\":5,\"showtime\":20,\"textcolor\":2,\"numcolor\":1," +
                "\"showcontent\":\"欢迎国科\"}" ;

         System.out.println("======js old:" + js);

        byte[] bs = js.getBytes("GBK");

        BasicHttpEntity httpEntity = new BasicHttpEntity() ;
        ByteArrayInputStream in = new ByteArrayInputStream(bs);
        httpEntity.setContent(in);

        httpPost.setEntity(httpEntity);

        CloseableHttpResponse response = null;
        try {
            // 执行请求
            response = httpclient.execute(httpPost);
            // 判断返回状态是否为200
            if (response.getStatusLine().getStatusCode() == 200) {
                // 解析响应数据
                String content = EntityUtils.toString(response.getEntity(), "UTF-8");
                System.out.println(content);
            }
        } finally {
            if (response != null) {
                response.close();
            }
            // 关闭浏览器
            httpclient.close();
        }

    }

    public static void setLine2(String[] args) throws Exception {
        final String CONTENT_TYPE_TEXT_JSON = "text/json";

        // 创建Httpclient对象
        CloseableHttpClient httpclient = HttpClients.createDefault();
        // 创建http POST请求
        String url = "http://192.168.168.188/Home/ShowAtOnce" ;
        HttpPost httpPost = new HttpPost(url);
        // 把自己伪装成浏览器。否则开源中国会拦截访问
        httpPost.setHeader("Content-Type", "application/x-www-form-urlencoded");
        String js="{\"key\":\"78E4A0164CCE064A4489013E66FB7A7D\",\"channelout\":2,\"textmum\":1,\"linenumber\":2,\"mobilemode\":0,\"stoptime\":5,\"showtime\":20,\"textcolor\":2,\"numcolor\":1," +
                "\"showcontent\":\"临时车\"}" ;

        System.out.println("======js old:" + js);

        byte[] bs = js.getBytes("GBK");

        BasicHttpEntity httpEntity = new BasicHttpEntity() ;
        ByteArrayInputStream in = new ByteArrayInputStream(bs);
        httpEntity.setContent(in);

        httpPost.setEntity(httpEntity);

        CloseableHttpResponse response = null;
        try {
            // 执行请求
            response = httpclient.execute(httpPost);
            // 判断返回状态是否为200
            if (response.getStatusLine().getStatusCode() == 200) {
                // 解析响应数据
                String content = EntityUtils.toString(response.getEntity(), "UTF-8");
                System.out.println(content);
            }
        } finally {
            if (response != null) {
                response.close();
            }
            // 关闭浏览器
            httpclient.close();
        }

    }

    public static void setLine3(String[] args) throws Exception {
        final String CONTENT_TYPE_TEXT_JSON = "text/json";

        // 创建Httpclient对象
        CloseableHttpClient httpclient = HttpClients.createDefault();
        // 创建http POST请求
        String url = "http://192.168.168.188/Home/ShowAtOnce" ;
        HttpPost httpPost = new HttpPost(url);
        // 把自己伪装成浏览器。否则开源中国会拦截访问
        httpPost.setHeader("Content-Type", "application/x-www-form-urlencoded");
        String js="{\"key\":\"78E4A0164CCE064A4489013E66FB7A7D\",\"channelout\":2,\"textmum\":1,\"linenumber\":3,\"mobilemode\":0,\"stoptime\":5,\"showtime\":20,\"textcolor\":2,\"numcolor\":2," +
                "\"showcontent\":\"闽D12345\"}" ;

        System.out.println("======js old:" + js);

        byte[] bs = js.getBytes("GBK");

        BasicHttpEntity httpEntity = new BasicHttpEntity() ;
        ByteArrayInputStream in = new ByteArrayInputStream(bs);
        httpEntity.setContent(in);

        httpPost.setEntity(httpEntity);

        CloseableHttpResponse response = null;
        try {
            // 执行请求
            response = httpclient.execute(httpPost);
            // 判断返回状态是否为200
            if (response.getStatusLine().getStatusCode() == 200) {
                // 解析响应数据
                String content = EntityUtils.toString(response.getEntity(), "UTF-8");
                System.out.println(content);
            }
        } finally {
            if (response != null) {
                response.close();
            }
            // 关闭浏览器
            httpclient.close();
        }

    }
}
