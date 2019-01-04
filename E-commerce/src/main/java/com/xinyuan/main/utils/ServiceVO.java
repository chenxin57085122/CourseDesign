package com.xinyuan.main.utils;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * @Auther: chenxin
 * @Date: 2019/1/2 16:23
 * @Description: 使用了Builder
 */
@Setter
@Getter
public class ServiceVO<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    private  T content = null;
    private   String message = "success";
    private   int code = 1;
    private Long time = new Date().getTime();

    public ServiceVO(T content){
        this.content = content;
    }

    public ServiceVO(){}

    public ServiceVO (ServiceVOBuilder builder){
        this.content = (T) builder.context;
        this.code = builder.code;
        this.message = builder.message;
    }



    public static class ServiceVOBuilder{
        public Object context = null;
        public int code = 1;
        public String message = "success";

        public ServiceVOBuilder(){

        }

        public ServiceVOBuilder context(Object context){
            this.context = context;
            return this;
        }

        public ServiceVOBuilder code(int code){
            this.code = code;
            return this;
        }
        public ServiceVOBuilder message(String message){
            this.message = message;
            return this;
        }

        public ServiceVO builder(){
            return new ServiceVO(this);
        }

    }

}
