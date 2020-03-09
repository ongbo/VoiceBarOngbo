package com.voicebar.Map;

import com.voicebar.Entity.UserGroupINFOByReduce;
import com.voicebar.Entity.UserGroupInfo;
import org.apache.commons.lang3.StringUtils;
import org.apache.flink.api.common.functions.MapFunction;

import java.util.ArrayList;
import java.util.List;

/**
 * 日志信息：
 *           0:配音Id：DubID
 *         * 1:用户ID：Uid
 *         * 2:素材ID：Mid
 *         * 3:配音真实语种：language
 *         * 4:类别：theme
 *         * 5:声音类型：style
 *         * 6:配音时间：createTime
 *         * 7:作品系统评分：workscore
 *
 * 对于上面的日志信息，我们要包装成UserGroupInfo，即对应的信息
 * 然后把每一条都再包装成UserGroupINFOByReduce类，传给Reduce去聚合
 *
 * */
public class UserGroupMap implements MapFunction<String, UserGroupINFOByReduce> {
    public UserGroupINFOByReduce map(String value) throws Exception {
       if(StringUtils.isBlank(value)){
           return null;
       }
       /**
        * 对于每个进来的value
        * 进行切分，然后构造对应的UserGroupInfo对象，写出去
        *
        * 对应的一个作品的日志信息
        * 0:配音Id：DubID
        * 1:用户ID：Uid
        * 2:素材ID：Mid
        * 3:配音真实语种ID：language
        * 4:类别ID：theme
        * 5:声音风格ID：style
        * 6:配音时间：createTime
        * 7:作品系统评分：workscore
        * */
        String[] values = value.split(",");
        UserGroupInfo userGroupInfo = new UserGroupInfo();
        userGroupInfo.setUserid(values[1]);
        userGroupInfo.setLanguage(values[3]);
        userGroupInfo.setTheme(values[4]);
        userGroupInfo.setStyle(values[5]);
        userGroupInfo.setWorktime(values[6]);
        userGroupInfo.setWorkscore(values[7]);
        userGroupInfo.setGroupfield("userGroupinfoid="+values[1]);

        UserGroupINFOByReduce userGroupINFOByReduce = new UserGroupINFOByReduce();
        List<UserGroupInfo> list = new ArrayList<UserGroupInfo>();
        list.add(userGroupInfo);
        userGroupINFOByReduce.setList(list);

        return userGroupINFOByReduce;


    }
}
