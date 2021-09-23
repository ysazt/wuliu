package com.wuliu.entity;

/*
* 1. 总条数         --》查询数据库中的所有数据
	               2. 每页展示几条   --》你自己决定的
				   3. 共计几页       --》 （总数%每页==0）？（总数/每页）：（总数/每页+1）；
				   默认页面第一次访问，就是第一页
				   4. 当前页     --》用户给的
				   5.起始位置    起始位置 = （当前页-1）*每页
* */
public class PageEntity {

    private int totalNum ;
    private int pageNum = 3;
    private int totalPage;
    private int currentPage;
    private int startIndex ;

    public int getTotalNum() {
        return totalNum;
    }

    //数据库返回的结果
    public void setTotalNum(int totalNum) {
        this.totalNum = totalNum;
    }

    // 计算总页数
    public int getPageNum() {
        return pageNum;
    }

    // 用户要每页展示的条数是动态的，
    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    //（总数%每页==0）？（总数/每页）：（总数/每页+1）；
    public int getTotalPage() {
        return (getTotalNum()%getPageNum()==0)?(getTotalNum()/getPageNum()):(getTotalNum()/getPageNum()+1);
    }

    public int getCurrentPage() {
        return currentPage;
    }
    // 将用户传递的当前页封装
    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getStartIndex() {
        return (getCurrentPage()-1)*getPageNum();
    }


}
