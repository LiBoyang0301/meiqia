package org.lby.meiqia.common.asserts;

import org.lby.meiqia.common.exception.MeiQiaException;

import java.util.Collection;
import java.util.Objects;

public class Asserts {

    public static void isNull(Object object,String msg){
        if(Objects.nonNull(object)){
            throw  new MeiQiaException(msg);
        }
    }

    public static void isNotNull(Object object,String msg){
        if(Objects.isNull(object)){
            throw  new MeiQiaException(msg);
        }
    }

    public static void isNotNull(Collection collection, String msg){
        if(Objects.isNull(collection)||collection.isEmpty()){
            throw  new MeiQiaException(msg);
        }
    }

    public static void isTrue(Boolean flag, String msg){
        if(!flag){
            throw  new MeiQiaException(msg);
        }
    }
}
