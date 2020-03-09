package com.voicebar.Reduce;

import com.voicebar.Entity.UserGroupINFOByReduce;
import com.voicebar.Entity.UserGroupInfo;
import org.apache.flink.api.common.functions.ReduceFunction;

import java.util.ArrayList;
import java.util.List;

/**
 * 这里循环迭代UserGroupINFOReduce
 * 然后加起来
 * */
public class UserGroupReduce implements ReduceFunction<UserGroupINFOByReduce> {
    public UserGroupINFOByReduce reduce(UserGroupINFOByReduce value1, UserGroupINFOByReduce value2) throws Exception {
        List<UserGroupInfo> returnlist = new ArrayList<UserGroupInfo>();
        returnlist.addAll(value1.getList());
        returnlist.addAll(value2.getList());
        UserGroupINFOByReduce userGroupINFOByReduce = new UserGroupINFOByReduce();
        userGroupINFOByReduce.setList(returnlist);
        return userGroupINFOByReduce;
    }
}
