package com.ovation.point;
/**
 * 点的基类
 * 点具有基本属性：点名，点描述，点的质量，点值
 * @author snpas
 *
 */
public class POINT {
	private String name;
	private String description;
	private QUALITY quality;//四种
	private POINT_TYPE value;//点的值类型由其类型决定
}
