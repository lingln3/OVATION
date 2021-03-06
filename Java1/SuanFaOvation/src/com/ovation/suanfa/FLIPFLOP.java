package com.ovation.suanfa;
/**
 * OVATION FLIPFLOP function
 * RS触发器
 * @author snpas
 *
 */
public class FLIPFLOP {
	private boolean set_val = false;
	private boolean reset_val = false;
	private boolean out = false;
	private boolean previous_out = false;
	private String type = null;
	
	/**
	 * 构造函数，获取算法块的配置
	 * @param set
	 * @param reset
	 * @param previous
	 * @param type
	 */
	public FLIPFLOP(String type){
		this.type = type;
	}
	
	/**
	 * 点的置值
	 */
	public void set(boolean set,boolean reset){
		this.set_val = set;
		this.reset_val = reset;
	}
	
	/**
	 * 计算模块
	 * @return
	 */
	public boolean get_out(){
		switch (type) {
		case "SET":
			if(set_val == true){
				previous_out = out;
				out = true;
			}
			else if(reset_val == true){
				previous_out = out;
				out = false;
			}else{
				previous_out = out;
				out = previous_out;
			}
			break;
		case "RESET":
			if(reset_val == true){
				previous_out = out;
				out = false;
			}else{
				if(set_val == true){
					previous_out = out;
					out = true;
				}else{
					previous_out = out;
					out = previous_out;
				}
			}
			break;
		}
		return out;
	}
}
