package com.xinyuan.main.domain.Enum;

/**
 * @Auther: chenxin
 * @Date: 2019/1/5 15:39
 * @Description: 定义Boolean 与 int 转换的枚举
 */
public enum  DefaultAddressEnum {
    TRUE(1,true) , FALSE(0,false);

    private int status;
    private Boolean flag;
    private DefaultAddressEnum(int status, boolean flag){
        this.status = status;
        this.flag = flag;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public static DefaultAddressEnum getDefaulAddressEnum(int status){
        if (status == 0)
            return FALSE;
        else
            return TRUE;
    }

    public static DefaultAddressEnum getDefaulAddressEnum(Boolean flag){
        if (flag == false)
            return FALSE;
        else
            return TRUE;
    }
}
