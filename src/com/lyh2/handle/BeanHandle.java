package com.lyh2.handle;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.sql.ResultSet;

public class BeanHandle<T> implements IResultSetHandle<T>{
    private Class<T> classType;
    public BeanHandle(Class<T> classType){
        this.classType = classType;
    }
    @Override
    public T IHandle(ResultSet rs) throws Exception {
        if (rs.next()){
            //创建classType对象
            T obj = this.classType.getDeclaredConstructor().newInstance();
            //通过内省来获得属性
            BeanInfo bi = Introspector.getBeanInfo(this.classType, Object.class);
            //获得所有属性的描述器
            PropertyDescriptor[] pds = bi.getPropertyDescriptors();
            //遍历每个属性描述器
            for (PropertyDescriptor pd:pds) {
                Object val = rs.getObject(pd.getName());
                //给对象设置属性值
                pd.getWriteMethod().invoke(obj,val);
            }
            return obj;
        }
        return null;
    }
}
