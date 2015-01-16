/**
 * 
 */
package edu.fjnu.haolaimai.dao.impl;

import java.io.IOException;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import edu.fjnu.haolaimai.dao.CategoryDao;
import edu.fjnu.haolaimai.domain.Category;
import edu.fjnu.haolaimai.domain.Good;
import edu.fjnu.haolaimai.exception.DataAccessException;
import edu.fjnu.haolaimai.service.CategoryQueryHelper;
import edu.fjnu.haolaimai.service.GoodQueryHelper;
import edu.fjnu.haolaimai.utils.DBUtils;


/**
 * @author lingqiusang
 *
 */
public class CategoryDaoImpl implements CategoryDao {
	private static final String LOAD_CATEGORY_BYNO = "select * from t_category where state='1' and cate_id=?";
	private static final String LOAD_ALL_PARENT = "select * from t_category where state='1' and pid is null";
	private static final String FIND_BY_PARENT = "select * from t_category where state='1' and pid=?";
	private static final String ADD_CATEGOTY = "insert into t_category values(seq_cate.nextval,?,?,?,?)";
	private static final String UPDATE_CATEGORY = "update t_category set cate_name=?,description=?,pid=? where cate_id=?";
	@Override
	public Category getCategoryById(int cateId) {
		Connection conn=DBUtils.getInstance().getConn();
		PreparedStatement pstmt=null;
		ResultSet rset=null;
		Category category=null;
		
		try{			
			  pstmt=conn.prepareStatement(LOAD_CATEGORY_BYNO);
			  pstmt.setInt(1, cateId);
			  rset=pstmt.executeQuery();
			 		  
			  if(rset.next()){
				  
				  category=new Category();
				  category.setCateId(rset.getInt("cate_id"));
				  category.setCateName(rset.getString("cate_name"));
				  category.setDecription(rset.getString("description"));
				  
				  String pid = rset.getString("pid");
				  if(pid==null){
					  List<Category> children = findByParent(category);
					  // 设置给父分类
					  category.setChildren(children);
					  category.setParent(null);
				  }else{					  
					  category.setParent(new Category(Integer.parseInt(pid)));;
				  }				  
			  }
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally{
				DBUtils.getInstance().ReleaseRes(conn, pstmt, rset);
			}	
		return category;
	}
		
	@Override
	public List<Category> loadAllCategory() {
		Connection conn=DBUtils.getInstance().getConn();
		PreparedStatement pstmt=null;
		ResultSet rset=null;
		List<Category> parents=null;
		
		try{
			
		  pstmt=conn.prepareStatement(LOAD_ALL_PARENT);
		  rset=pstmt.executeQuery();
		  
		  parents=new ArrayList<Category>();
		  
		  while(rset.next()){
			  
			  Category category = new Category();
			  category.setCateId(rset.getInt("cate_id"));
			  category.setCateName(rset.getString("cate_name"));
			  category.setDecription(rset.getString("description"));
			  category.setParent(null);//父类没有子菜单	
			  
			  parents.add(category);
		  }
		  for(Category parent : parents) {
				// 查询出当前父分类的所有子分类
				List<Category> children = findByParent(parent);
				// 设置给父分类
				parent.setChildren(children);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBUtils.getInstance().ReleaseRes(conn, pstmt,rset);
		}
		
		return parents;
	}

	@Override
	public List<Category> findByParent(Category parent) {
		Connection conn=DBUtils.getInstance().getConn();
		PreparedStatement pstmt=null;
		ResultSet rset=null;
		List<Category> children=null;
		
		try{	
			  pstmt=conn.prepareStatement(FIND_BY_PARENT);
			  pstmt.setInt(1, parent.getCateId());
			  rset=pstmt.executeQuery();
			  children = new ArrayList<Category>();
			  
			  while(rset.next()){
				  
				  Category category=new Category();
				  category.setCateId(rset.getInt("cate_id"));
				  category.setCateName(rset.getString("cate_name"));
				  category.setDecription(rset.getString("description"));
				  category.setParent(parent);
				  
				  children.add(category);
			  }
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally{
				DBUtils.getInstance().ReleaseRes(conn, pstmt, rset);
			}	
		
		return children;
	}

	@Override
	public int cntCategorys(CategoryQueryHelper helper) {
		String sql=this.generateSQL(helper);
		
		//select count(*) goot_cnt from t_good where ..
		
		sql=sql.replace("*", "count(*) cate_cnt");
		sql=sql.substring(0,sql.indexOf("order")).trim();
		
		System.out.println("cntCategorys:"+sql);
		
		Connection conn=DBUtils.getInstance().getConn();
		PreparedStatement pstmt=null;
		ResultSet rset=null;
		int cateCnt=0;
		
		try {
			
		  pstmt=conn.prepareStatement(sql);
		  rset=pstmt.executeQuery();
		  
		  if(rset.next()){
			  cateCnt=rset.getInt("cate_cnt");
		  }
		  
 		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
		   DBUtils.getInstance().ReleaseRes(conn, pstmt, rset);
		}				
		return cateCnt;
	}

	@Override
	public List<Category> loadTermPageCategory(CategoryQueryHelper helper,
			int begin, int end) {
		String sql=this.generateSQL(helper);
		sql="select * from (select rownum rn, a.* from ("+sql+") a where rownum<=? ) where rn>=?";
		
		System.out.println("get term page categorys:"+sql+","+end+","+begin);
				
		Connection conn=DBUtils.getInstance().getConn();
		PreparedStatement pstmt=null;
		ResultSet rset=null;
		List<Category> cateList=null;
		
		try {
			
		  pstmt=conn.prepareStatement(sql);
		  pstmt.setInt(1, end);
		  pstmt.setInt(2, begin);
		  rset=pstmt.executeQuery();
		  cateList=new ArrayList<Category>();
		  
		  while(rset.next()){
			  Category category=new Category();
			  category.setCateId(rset.getInt("cate_id"));
			  category.setCateName(rset.getString("cate_name"));
			  category.setDecription(rset.getString("description"));
			  Integer pid = rset.getInt("pid");
			  if(pid == 0){
				  category.setParent(null);//父类没有子菜单	
			  }else{
				  category.setParent(this.getCategoryById(pid));
			  }
			  
  			  cateList.add(category);	
		  }
		  
 		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
		   DBUtils.getInstance().ReleaseRes(conn, pstmt, rset);
		}		
		return cateList;
	}
	
	/**
	 * 根据查询条件，动态生成菜单查询SQL语句
	 * @param helper
	 * @return
	 */
	private String generateSQL(CategoryQueryHelper helper){
		
		String baseSQL="select * from t_category where state='1'";

		if(helper.getCategoryIdB()!=null){			
				baseSQL+=" and pid='"+helper.getCategoryIdB()+"'";
		}				
		if(StringUtils.isNotEmpty(helper.getKeyValue())){
			baseSQL+=" and ( cate_name like '%"+helper.getKeyValue()+"%' or description like '%"+helper.getKeyValue()+"%')";
		}
		
		baseSQL+=" order by cate_id desc";
		
		System.out.println("SQL BY HELPER:"+baseSQL);
		
		return baseSQL;		
	}

	@Override
	public List<Category> getAllParentCategory() {
		Connection conn=DBUtils.getInstance().getConn();
		PreparedStatement pstmt=null;
		ResultSet rset=null;
		List<Category> parents=null;
		
		try{
			
		  pstmt=conn.prepareStatement(LOAD_ALL_PARENT);
		  rset=pstmt.executeQuery();
		  
		  parents=new ArrayList<Category>();
		  
		  while(rset.next()){
			  
			  Category category = new Category();
			  category.setCateId(rset.getInt("cate_id"));
			  category.setCateName(rset.getString("cate_name"));
			  category.setDecription(rset.getString("description"));
			  category.setParent(null);//父类没有子菜单	
			  
			  parents.add(category);
		  }
		  
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBUtils.getInstance().ReleaseRes(conn, pstmt,rset);
		}
		
		return parents;
	}

	@Override
	public void addCategory(Category category) {
		Connection conn=DBUtils.getInstance().getConn();
		PreparedStatement pstmt=null;
		
		try {
			
			pstmt=conn.prepareStatement(ADD_CATEGOTY);
			pstmt.setString(1, category.getCateName());
			pstmt.setString(2, category.getDecription());
			
			if(category.getParent().getCateId()==0){
				pstmt.setString(3, null);
			}else{
				pstmt.setInt(3, category.getParent().getCateId());
			}
			pstmt.setInt(4,1);
			
			pstmt.executeUpdate();
					
		}catch(SQLException e)
		{
			if(e.getMessage().contains("HAOLAIMAI.T_CATEGORY_UK1")){
				throw new DataAccessException("已经存在这["+category.getCateName()+"]的类别，请检查！");
			}

		}finally{
			DBUtils.getInstance().ReleaseRes(conn, pstmt, null);
		}
	}

	@Override
	public void updateCategory(Category category) {		
		Connection conn=DBUtils.getInstance().getConn();
		PreparedStatement pstmt=null;
		
		try {
			
			pstmt=conn.prepareStatement(UPDATE_CATEGORY);
			pstmt.setString(1, category.getCateName());
			pstmt.setString(2, category.getDecription());
			pstmt.setInt(3, category.getParent().getCateId());
			pstmt.setInt(4, category.getCateId());
			
			pstmt.executeUpdate();
					
		}catch(SQLException e)
		{
			e.printStackTrace();

		}finally{
			DBUtils.getInstance().ReleaseRes(conn, pstmt, null);
		}
	}
	
}
