package com.lyh2.handle;

import java.sql.ResultSet;

public interface IResultSetHandle<T> {
    T IHandle(ResultSet rs) throws Exception;
}
