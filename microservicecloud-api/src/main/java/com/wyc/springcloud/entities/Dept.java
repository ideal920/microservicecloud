package com.wyc.springcloud.entities;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@AllArgsConstructor        //全参构造函数
@NoArgsConstructor        //空参构造函数
@Data
@Accessors(chain=true)	//链式调用
public class Dept implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long deptno;	//主键
	private String dname;	//部门名称
	private String db_source;//对应哪个数据库
	
}