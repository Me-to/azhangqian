package com.example.demo.conf;

public class AlipayConfig {

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号,开发时使用沙箱提供的APPID，生产环境改成自己的APPID
    public static String APP_ID = "2016102800775171";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String APP_PRIVATE_KEY = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCdyn0U3iWZ98Frfd6jpq08fu1D2rhKJlHjFJZ0uQKRpx41gJed/NOorhE4rpgolCZovqdyvtBz6E590TIH+HPZX7IyCgwoy8jABHAfji9Nm/0MMVTj+eVj/8DU8g8Qi5WjFV1/gHbqOszPOFqIwAFGRMfnr8a2YaDyacH5U5DRZPjFfzNo5+/9qdrx44H/eaylo/uSljDYkSX+sBogLDIwTpxbNMRWARV8F5RpxtW0IVt4oLDRQMY5LbgQYvPvKuW/D84yEooTZqpFzaZ/R1FKx+JT7gtFB7HCHFu0oPPr50hAbaJwI+YrHXOMHqAEGVeY+O/QlV5Lwqvl7FLqaMhFAgMBAAECggEBAJYs79r6isL9QEMz6r/KlLos+1hHRHqd+fWr1H6GzuEdMu0s1CBzTmcONCnEUeDdD6lFO01EOlT2Vi38+icH2gqav5hMY8I4IXpPPv9pba/ptG70TJ0la6M++KIzNw9CKkqqvO/qrkLDb8YRFmlshEoCkFf7vZ47UNkmuoy3ce83LsFqP1b/DmZsY4AFAWGkin9Sb7dKC8cJ+GAcG/YmryiJcNMDPu3IctCpGw8wENI9XagxwOZD0RocpPTs1COyV/wQjRQQUNlOIoc+X2vbw+ZLMm/D3w4n9xln+d9cucwZKXxCzG4IuB5sMMu4zuSmC0ebxqE03CdaqD1v2IXdoQECgYEA5BmTwGXGNWYmfIkqytSieC1ycXnqEkKPQsEu3ljb6bVvE0zfVxMKSweupn9kWM674aUHkMUAOssk7ina+ncvygXrjgUxFRQCRElv1tQAIEwgVrQD0aN/gZU9odruate+9ElSQr+XhvIrjzKICeIeKoQS9Sc2OPb/KJvQ1DWE/GUCgYEAsRdZXelBvIoWxR73NaqoAVbKAkuXSCQyZw+d9pAiEmOKwpZ9FSFgkFE2QlbbJ0vMGX4qfny00CkIyMcX4eQ9z/Cx4m5hElMAG2Wz+1iF2SWIq4kaJKyomT0zW+w0iaZjjeuD6j8cFBGIzRhyYl0YY/+NQpsCQJc/6Cfeg4jPLmECgYAMmW0T34tHP9E4Z8s5UO14feooYnePcqW/JjSUi4v6KM9t3X0oriCPbGk1QSwly6WNHTSBxp/wn2/2x9EUrKizHAia26aOZ4CIjRXkY+lt30aaA2+CkOlmGvxAiHtK44fkrnggv7x68718N2pUQW0xJAJ4ECZqlxoZACJU1m/2EQKBgQCCLdfT4RQhtKDoZsry+HBoC5ST+11J+tHSUPidt3ZUbjgist1gGxkQ/aIVQiP3zxBJ7STvtlx0aLW8Yh58P3vwz87z1JAnGDyL50dXDMvXxG+jKTW+n+2QOBz5BbnZNicYvHhMSfgqCHm3yrDK/gRf/gupWqldMdIYprY7muYyAQKBgEIgJguFn2jyUXwNFO//ySmF7QzY8Kqdx31sGdMYnEtVFW/N0MFiUvP7LKNxU1LbIkRw+r47JLLdBTVkVIFzIuYyRoUcvpM3Vaevpjqtl9E4pX3t3umbCuHiQHJosIy3cxjEZX11492I+yDPC7VrScO1rx8FZ6uhBRyrV4G9dXUa";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAmSPQrSt7eNTW1lFpDPqJlABxQ5T46T7M8NBLjcFU+eFtLjKXFOJwPzb0nGIcW9iGNZzYzWyKx/wc5wOxVjIQA7dfb2w/lr9DYeruHtOO+PGWbiE3vmUKoaU8+bYNm0vmzIv5+QjcEHeiMLOTqa6T9jFW4q9Zhv76bwDB6qKXXpP3ffQtxgvo5tKcoArPHx713FyOEnCThpFpkEC/sVPJ+Quw4WdRl/K6fSgZwajFJuyBc5Fp58064FRn89bHfAyTb2sdLg230ewLfEEbBpz0l0lu5HoiCCsq1TCgfCdmsXraomaJ2anKyHoOKiXV1IF8w8r2htANJL5sh4W2cvvIxQIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "https://www.sogou.com";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问(其实就是支付成功后返回的页面)
    public static String return_url = "https://www.baidu.com";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String CHARSET = "utf-8";

    // 支付宝网关，这是沙箱的网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关
   // public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
//    public static void logResult(String sWord) {
//        FileWriter writer = null;
//        try {
//            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
//            writer.write(sWord);
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            if (writer != null) {
//                try {
//                    writer.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
}
