package com.lyh2.handle;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BeanListHandle<T>  implements IResultSetHandle<List<T>> {
    private Class<T> classType;
    public BeanListHandle(Class<T> classType){
        this.classType=classType;
    }
    @Override
    public List<T> IHandle(ResultSet rs) throws Exception {
        List<T> list = new ArrayList<>();
        while (rs.next()){
            //创建classType对象
            T obj = this.classType.getDeclaredConstructor().newInstance();
            //通过内省获得属性
            BeanInfo bi = Introspector.getBeanInfo(this.classType, Object.class);
            //创建属性方法构造器
            PropertyDescriptor[] pds = bi.getPropertyDescriptors();
            //遍历构造器中的属性
            for (PropertyDescriptor pd:pds) {
                Object val = rs.getObject(pd.getName());
                pd.getWriteMethod().invoke(obj,val);
            }
            list.add(obj);
        }
        return list;
    }
}
