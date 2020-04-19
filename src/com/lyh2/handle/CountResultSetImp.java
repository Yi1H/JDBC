package com.lyh2.handle;

import java.sql.ResultSet;

public class CountResultSetImp implements IResultSetHandle<Integer>{

    @Override
    public Integer IHandle(ResultSet rs) throws Exception {
        if (rs.next()){
            return rs.getInt(1);
        }
        return 0;
    }
}