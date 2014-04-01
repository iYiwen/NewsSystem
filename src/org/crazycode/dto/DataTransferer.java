package org.crazycode.dto;

public class DataTransferer {

	private Integer pageNum=1;		//分页中的当前页
	
	private Integer pageStart=1;		//分页中的起始页
	
	private Integer pageEnd;		//分页中的结束页
	
	private String msg;				//系统中的提示信息
	
	private Object data;			//用于传输数据的Object
	
	private Integer pageSize=10;		//每页显示的数据记录数
	
	private Long count;			//该数据对应的总记录数
	
	private Integer pageCount;		//该数据的总页数
	
	private Integer navPageSize = 9;
	
	public DataTransferer(){
		
	}
	public DataTransferer(Object data){
		this.data=data;
	}
	public DataTransferer(Integer pageNum,Integer pageSize){
		this.pageNum = pageNum;
		this.pageSize = pageSize;
	}
	/**
	 * 数据处理
	 * @param count
	 */
	public void process(Long count){
		pageNum = (pageNum==0)?1:pageNum;
		pageSize=(pageSize==0)?20:pageSize;
		this.count = count;
		pageStartAndStop(count, pageNum, pageSize);
	}
	/**
	 * 页面数值的计算
	 * @param count
	 * @param pageNum1
	 * @param pageSize1
	 */
	private void pageStartAndStop(Long count,int pageNum1,int pageSize1){
		pageCount = (int)Math.ceil(count*1.0/pageSize);
		pageNum = (pageNum1>pageCount)?pageCount:pageNum1;
		if(pageCount>=navPageSize){
			if((pageNum-((int)Math.ceil(navPageSize*1.0/2)))<=0){
				pageStart=1;
				pageEnd=navPageSize;
			}else{
				if((pageCount-pageNum)<((int)Math.ceil(navPageSize*1.0/2))){
					pageStart=pageCount-navPageSize+1;
					pageEnd=pageCount;
				}else{
					pageStart=pageNum-((int)Math.ceil(navPageSize*1.0/2))+1;
					pageEnd=pageNum+((int)Math.ceil(navPageSize*1.0/2))-1;
				}
			}
		}else{
			pageStart=1;
			pageEnd=pageCount;
		}
	}
	public Integer getPageNum() {
		return pageNum;
	}
	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}
	public Integer getPageStart() {
		return pageStart;
	}
	public void setPageStart(Integer pageStart) {
		this.pageStart = pageStart;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getPageEnd() {
		return pageEnd;
	}
	public void setPageEnd(Integer pageEnd) {
		this.pageEnd = pageEnd;
	}
	public Long getCount() {
		return count;
	}
	public Integer getPageCount() {
		return pageCount;
	}
	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public Integer getNavPageSize() {
		return navPageSize;
	}
	public void setNavPageSize(Integer navPageSize) {
		this.navPageSize = navPageSize;
	}
	
}
