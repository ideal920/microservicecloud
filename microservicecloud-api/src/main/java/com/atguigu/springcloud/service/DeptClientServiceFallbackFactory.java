package com.atguigu.springcloud.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.atguigu.springcloud.entities.Dept;

import feign.hystrix.FallbackFactory;

//不要忘记添加，不要忘记添加
@Component
//FallbackFactory 备选响应
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService>{

	/*
	 * @Override public Dept get(long id) { // TODO Auto-generated method stub
	 * return new Dept().setDeptno(id).setDname("该id没有对应信息").
	 * setDb_source("no this database in MySQL"); }
	 * 
	 * @Override public List<Dept> list() { // TODO Auto-generated method stub
	 * return null; }
	 * 
	 * @Override public boolean add(Dept dept) { // TODO Auto-generated method stub
	 * return false; }
	 */
	
	@Override
    public DeptClientService create(Throwable throwable) {
        return new DeptClientService() {
            @Override
            public Dept get(long id) {
                Dept dept = new Dept();
                dept.setDeptno(id);
                dept.setDname("该ID：" + id + "没有对应的信息，Consumer客户端提供的信息，此服务Provider已关闭");
                dept.setDb_source("no this database in mysql");
                return dept;
            }
            @Override
            public List<Dept> list() {
                return null;
            }
            @Override
            public boolean add(Dept dept) {
                return false;
            }
        };
    }
}