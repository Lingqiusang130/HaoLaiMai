/**
 * 
 */
package edu.fjnu.haolaimai.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.fjnu.haolaimai.dao.CategoryDao;
import edu.fjnu.haolaimai.domain.Category;
import edu.fjnu.haolaimai.domain.Good;
import edu.fjnu.haolaimai.utils.DBUtils;


/**
 * @author lingqiusang
 *
 */
public class CategoryDaoImpl implements CategoryDao {
	private static final String LOAD_CATEGORY_BYNO = "select * from t_category where cate_id=?";
	private static final String LOAD_ALL_PARENT = "select * from t_category where pid is null";
	private static final String FIND_BY_PARENT = "select * from t_category where pid=?";
	
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
	
}
