package com.muggle.base;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ResultBean {
    private String code;
    private String msg;
    private Object data;

    public ResultBean success(String msg, Object date){
        ResultBean resultBean = new ResultBean()
                .setCode(PoseidonProperties.SUCCESS_CODE).setData(date).setMsg(msg);
        return resultBean;
    }

    public ResultBean error(String msg){
        ResultBean resultBean = new ResultBean().setCode(PoseidonProperties.ERROR_CODE).setMsg(msg);
        return resultBean;
    }
    public ResultBean success(String msg){
        ResultBean resultBean = new ResultBean().setCode(PoseidonProperties.SUCCESS_CODE).setMsg(msg);
        return resultBean;
    }
    public static ResultBean getInstance(){
        ResultBean resultBean=new ResultBean();
        resultBean.setCode("200").setMsg("操作成功");
        return resultBean;
    }
    public static ResultBean getInstance(String code,String msg,Object data){
        ResultBean resultBean=new ResultBean();
        resultBean.setCode(code).setMsg(msg);
        resultBean.setData(data);
        return resultBean;
    }

    public static ResultBean getInstance(Object data){
        ResultBean resultBean=new ResultBean();
        resultBean.setCode("200").setMsg("操作成功");
        resultBean.setData(data);
        return resultBean;
    }
    public static ResultBean getInstance(String code,String msg){
        ResultBean resultBean=new ResultBean();
        resultBean.setCode(code).setMsg(msg);
        return resultBean;
    }
}
