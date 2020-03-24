package com.aistar.util;

/**
 * Created by admin on 2020/2/21.
 */
public class ServerResponse {
    private int status;//响应的状态：1.表示成功 0.表示失败
    private String message;//响应的消息提示
    private Object data;//相应数据

    public ServerResponse(){};
    public ServerResponse(int status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }
    public ServerResponse(int status, String message) {
        this.status = status;
        this.message = message;

    }

    //增加
    public static ServerResponse addSuccess(){
        ServerResponse serverResponse=new ServerResponse(1,"添加数据成功",MessageUtil.ADD_SUCCESS);
        return serverResponse;
    }
    public static ServerResponse addFailed(){
        ServerResponse serverResponse=new ServerResponse(0,"添加数据失败",MessageUtil.ADD_FAIL);
        return serverResponse;
    }

    //删除
    public static ServerResponse deleteSuccess(){
        ServerResponse serverResponse=new ServerResponse(1,"删除数据成功",MessageUtil.DELETE_SUCCESS);
        return serverResponse;
    }
    public static ServerResponse deleteFailed(){
        ServerResponse serverResponse=new ServerResponse(0,"删除数据失败",MessageUtil.DELETE_FAIL);
        return serverResponse;
    }

    //修改
    public static ServerResponse updateSuccess(){
        ServerResponse serverResponse= new ServerResponse(1,"修改数据成功",MessageUtil.UPDATE_SUCCESS);
        return serverResponse;
    }
    public static ServerResponse updateFailed(){
        ServerResponse serverResponse= new ServerResponse(0,"修改数据失败",MessageUtil.UPDATE_FAIL);
        return serverResponse;
    }

    //注册
    public static ServerResponse hasRegist(){
        ServerResponse serverResponse= new ServerResponse(1,"已经注册",MessageUtil.HAS_REGISTED);
        return serverResponse;
    }
    public static ServerResponse noRegist(){
        ServerResponse serverResponse= new ServerResponse(0,"暂未注册",MessageUtil.NO_REGIST);
        return serverResponse;
    }

    //登录
    public static ServerResponse hasLogin(){
        ServerResponse serverResponse= new ServerResponse(1,"已经登录",MessageUtil.HAS_LOGIN);
        return serverResponse;
    }
    public static ServerResponse noLogin(){
        ServerResponse serverResponse= new ServerResponse(0,"暂未登录",MessageUtil.NO_LOGIN);
        return serverResponse;
    }

    //查询
    public static ServerResponse getDataSuccess(Object data){
        ServerResponse serverResponse=new ServerResponse(1,"查询数据成功");
        serverResponse.setData(data);
        return serverResponse;
    }
    public static ServerResponse getDataFailed(Object data){
        ServerResponse serverResponse=new ServerResponse(1,"查询数据失败");
        serverResponse.setData(data);
        return serverResponse;
    }

    //get set
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ServerResponse{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

}

