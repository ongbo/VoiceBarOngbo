package com.voicebar.Util;

public class MailUtil {
    public static String getRegionBy(String region){
        if(region.equals("1")) return "北京市";
        else if(region.equals("2")) return "天津市";
        else if(region.equals("3")) return "上海市";
        else if(region.equals("4")) return "重庆市";
        else if(region.equals("5")) return "河北省";
        else if(region.equals("6")) return "山西省";
        else if(region.equals("7")) return "辽宁省";
        else if(region.equals("8")) return "吉林省";
        else if(region.equals("9")) return "黑龙江省";
        else if(region.equals("10")) return "江苏省";
        else if(region.equals("11")) return "浙江省";
        else if(region.equals("12")) return "安徽省";
        else if(region.equals("13")) return "福建省";
        else if(region.equals("14")) return "江西省";
        else if(region.equals("15")) return "山东省";
        else if(region.equals("16")) return "河南省";
        else if(region.equals("17")) return "湖北省";
        else if(region.equals("18")) return "湖南省";
        else if(region.equals("19")) return "广东省";
        else if(region.equals("20")) return "海南省";
        else if(region.equals("21")) return "四川省";
        else if(region.equals("22")) return "贵州省";
        else if(region.equals("23")) return "云南省";
        else if(region.equals("24")) return "陕西省";
        else if(region.equals("25")) return "甘肃省";
        else if(region.equals("26")) return "青海省";
        else if(region.equals("27")) return "台湾省";
        else if(region.equals("28")) return "内蒙古自治区";
        else if(region.equals("29")) return "广西藏族自治州";
        else if(region.equals("30")) return "西藏自治区";
        else if(region.equals("31")) return "宁夏回族自治区";
        else if(region.equals("32")) return "新疆维吾尔自治区";
        else if(region.equals("33")) return "香港特别行政区";
        else if(region.equals("34")) return "澳门特别行政区";
        else return "未知";
    }
    /**
     *  网易邮箱 @163.com @126.com
     移动邮箱 @139.com
     搜狐邮箱 @sohu.com
     qq邮箱  @qq.com
     189邮箱 @189.cn
     tom邮箱 @tom.com
     阿里邮箱 @aliyun.com
     新浪邮箱 @sina.com
     等等
     * @param email
     * @return
     */
    public static String getEmailtypeBy(String email){
        String emailtye = "其他邮箱用户";
        if(email.contains("@163.com")||email.contains("@126.com")){
            emailtye = "网易邮箱用户";
        }else if (email.contains("@139.com")){
            emailtye = "移动邮箱用户";
        }else if (email.contains("@sohu.com")){
            emailtye = "搜狐邮箱用户";
        }else if (email.contains("@qq.com")){
            emailtye = "qq邮箱用户";
        }else if (email.contains("@189.cn")){
            emailtye = "189邮箱用户";
        }else if (email.contains("@tom.com")){
            emailtye = "tom邮箱用户";
        }else if (email.contains("@aliyun.com")){
            emailtye = "阿里邮箱用户";
        }else if (email.contains("@sina.com")){
            emailtye = "新浪邮箱用户";
        }
        return emailtye;
    }
}
