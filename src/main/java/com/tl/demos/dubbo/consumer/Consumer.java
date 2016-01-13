package com.tl.demos.dubbo.consumer;

import com.alibaba.fastjson.JSON;
import com.kuaidadi.databus.api.ManagerRemoteService;
import com.kuaidadi.databus.api.config.NodeConfig;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Thinkpad on 2015/9/6.
 */
public class Consumer {

    public static void main(String[] args) throws Exception {
//consumer.xml����maven��Ŀ��resourcesĿ¼��
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath*:consumer.xml");
        context.start();

        ManagerRemoteService demoService = (ManagerRemoteService)context.getBean("demoService"); // ��ȡԶ�̷������
//        RpcContext.getContext().setAttachment("attachment","something");
        NodeConfig config = demoService.getClientConfig(61); // ִ��Զ�̷���

        System.out.println(JSON.toJSONString(config)); // ��ʾ���ý��
    }
}