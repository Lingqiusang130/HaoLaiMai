/**
 * 
 */
package edu.fjnu.haolaimai.utils;

/**
 * 分页测试
 * @author lingqiusang
 *
 */
public class PageTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//自管理类
		Page page=new Page();
		
		page.setTotalRecNum(102);
		page.setPageSize(10);
		
		System.out.println(page.getTotalPageNum());

		page.setPageNo(11);
		
		System.out.println(page.getStartIndex()+"-"+page.getEndIndex());
		
		System.out.println(page.getNextPage());
		System.out.println(page.getPrePage());
		
	}

}
