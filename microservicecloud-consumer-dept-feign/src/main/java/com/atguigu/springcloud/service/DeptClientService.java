package com.atguigu.springcloud.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.atguigu.springcloud.entities.Dept;
@FeignClient(value = "MICROSERVICECLOUD-DEPT")
@RequestMapping("/dept")
public interface DeptClientService{
	@RequestMapping(value = "/get/{id}",method = RequestMethod.GET)
    public Dept get(@PathVariable("id") long id);


    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public List<Dept> list();


    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public boolean add(Dept dept);
}