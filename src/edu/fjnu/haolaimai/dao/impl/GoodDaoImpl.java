/**
 * 
 */
package edu.fjnu.haolaimai.dao.impl;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import edu.fjnu.haolaimai.dao.CategoryDao;
import edu.fjnu.haolaimai.dao.GoodDao;
import edu.fjnu.haolaimai.domain.Category;
import edu.fjnu.haolaimai.domain.Good;
import edu.fjnu.haolaimai.exception.ApplicationException;
import edu.fjnu.haolaimai.service.GoodQueryHelper;
import edu.fjnu.haolaimai.utils.DBUtils;

/**
 * @author lingqiusang
 *
 */
public class GoodDaoImpl implements GoodDao {
	
	private static final String ADD_GOOD = "insert into t_good values(seq_good.nextval,?,?,Empty_BLOB(),?,?,?)";
	private static final String LOAD_ALL_GOOD="select * from t_good where stockstatus='1' order by good_id desc";
	private static final String SQL_GETPIC="select good_image from t_good where stockstatus='1' and good_id=?";
	private static final String DEL_GOOD_BYID="update t_good set stockstatus='0' where good_id=?";
	private static final String GET_GOOD_BYID="select * from t_good where stockstatus='1' and good_id=?";
	private static final String UPDATE_GOOD = "update t_good set good_name=?,good_price=?,description=?,cate_id=?,stockstatus=? where good_id=?";
	
	@Override
	public void addGood(Good good) {
		Connection conn=DBUtils.getInstance().getConn();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			conn.setAutoCommit(false);//设置数据库为不自动提交，必须的一步	
			
			pstmt=conn.prepareStatement(ADD_GOOD);
			pstmt.setString(1, good.getGoodName().toString());
			pstmt.setDouble(2, good.getGoodPrice());
			pstmt.setString(3, good.getDescription());
			pstmt.setInt(4,good.getCategory().getCateId());
			pstmt.setInt(5, good.getStockStatus());
			
			pstmt.executeUpdate();
			
			   //以行的方式锁定   
			   pstmt=conn.prepareStatement("select good_image from t_good where good_id=(select max(good_id) from t_good) for update");
			   rs=pstmt.executeQuery();  
			   
			   if (rs.next()) {   
				   //得到流   
				   oracle.sql.BLOB blob = (oracle.sql.BLOB) rs.getBlob("good_image");   
				   //从得到的低级流构造一个高级流   
				   PrintStream ps = new PrintStream(blob.getBinaryOutputStream());   
				   ps.write(good.getGoodImage());
				   //清空流的缓存   
				   ps.flush();   
				   //关闭流，注意一定要关   
				   ps.close();   
				}
			   
			   conn.commit();			
			
		}catch(SQLException e)
		{
			e.printStackTrace();
			throw new ApplicationException("操作出错！");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtils.getInstance().ReleaseRes(conn, pstmt, rs);
		}
		
	}

	@Override
	public List<Good> loadGood() {
		Connection conn=DBUtils.getInstance().getConn();
		PreparedStatement pstmt=null;
		ResultSet rset=null;
		List<Good> goodList=null;
		
		try{
			
		  pstmt=conn.prepareStatement(LOAD_ALL_GOOD);
		  rset=pstmt.executeQuery();
		  
		  goodList=new ArrayList<Good>();
		  
		  while(rset.next()){
			  
			  Good good=new Good();
			  good.setGoodId(rset.getInt("good_id"));
			  good.setGoodName(rset.getString("good_name"));
			  good.setGoodPrice(rset.getDouble("good_price"));
			  good.setDescription(rset.getString("description"));
			  CategoryDao categoryDao = new CategoryDaoImpl();
			  //通过catId查询菜单
			  Category category = categoryDao.getCategoryById(rset.getInt("cate_id"));
			  good.setCategory(category);
			  good.setStockStatus(rset.getInt("stockstatus"));
		  
			  goodList.add(good);		  
		  }
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBUtils.getInstance().ReleaseRes(conn, pstmt,rset);
		}
		
		return goodList;
	}
	
	public byte[] getGoodPic(int goodId){

		Connection conn=DBUtils.getInstance().getConn();
		PreparedStatement pstmt=null;
		ResultSet rset=null;

		byte[] goodPic=null;
		
		try{
		
		   pstmt=conn.prepareStatement(SQL_GETPIC);
		   pstmt.setInt(1, goodId);
		   rset=pstmt.executeQuery();
		   
		   
		   if(rset.next())
		   {
			   java.sql.Blob blob = rset.getBlob("good_image");
			   if(blob!=null){
			    InputStream inStream = blob.getBinaryStream();
			    goodPic = new byte[(int) blob.length()];
			    inStream.read(goodPic);
			    inStream.close();
			   }
		   }
		  			
		}catch(SQLException e)
		{
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtils.getInstance().ReleaseRes(conn, pstmt, rset);
		}
		return goodPic;
	}

	@Override
	public List<Good> loadTermGood(GoodQueryHelper helper) {
		Connection conn=DBUtils.getInstance().getConn();
		PreparedStatement pstmt=null;
		ResultSet rset=null;
		List<Good> goodList=null;
		
		try{
			
		  pstmt=conn.prepareStatement(this.generateSQL(helper));
		  rset=pstmt.executeQuery();
		  
		  goodList=new ArrayList<Good>();
		  
		  while(rset.next()){
			  
			  Good good=new Good();
			  good.setGoodId(rset.getInt("good_id"));
			  good.setGoodName(rset.getString("good_name"));
			  good.setGoodPrice(rset.getDouble("good_price"));
			  good.setDescription(rset.getString("description"));
			  CategoryDao categoryDao = new CategoryDaoImpl();
			  //通过catId查询菜单
			  Category category = categoryDao.getCategoryById(rset.getInt("cate_id"));
			  good.setCategory(category);
			  good.setStockStatus(rset.getInt("stockstatus"));
		  
			  goodList.add(good);		  
		  }
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBUtils.getInstance().ReleaseRes(conn, pstmt,rset);
		}
		
		return goodList;
	}
	
	/**
	 * 根据查询条件，动态生成商品查询SQL语句
	 * @param helper
	 * @return
	 */
	private String generateSQL(GoodQueryHelper helper){
		
		String baseSQL="select * from t_good where stockstatus='1'";

		if(helper.getCategoryIdB()!=null){			
			if(helper.getCategoryIdS()!=null){
				baseSQL+=" and cate_id='"+helper.getCategoryIdS()+"'";
			}
			else{
				baseSQL="select * from t_good where stockstatus='1' and cate_Id IN(select CATE_ID from t_category where pid='"+helper.getCategoryIdB()+"')";				
			}
		}				
		if(StringUtils.isNotEmpty(helper.getKeyValue())){
			baseSQL+=" and good_name like '%"+helper.getKeyValue()+"%'";
		}
		
		baseSQL+=" order by good_id desc";
		
		System.out.println("SQL BY HELPER:"+baseSQL);
		
		return baseSQL;		
	}

	@Override
	public void removeGood(int goodId) {
		// TODO Auto-generated method stub
		Connection conn=DBUtils.getInstance().getConn();
		PreparedStatement pstmt=null;
		
		try {
		  pstmt=conn.prepareStatement(DEL_GOOD_BYID);
		  pstmt.setInt(1, goodId);
		  pstmt.executeUpdate();
		  
 		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();		
			
		} finally{
		   DBUtils.getInstance().ReleaseRes(conn, pstmt, null);
		}		
	}

	@Override
	public int cntGoods(GoodQueryHelper helper) {
		String sql=this.generateSQL(helper);
		
		//select count(*) goot_cnt from t_good where ..
		
		sql=sql.replace("*", "count(*) good_cnt");
		sql=sql.substring(0,sql.indexOf("order")).trim();
		
		System.out.println("cntGoods:"+sql);
		
		Connection conn=DBUtils.getInstance().getConn();
		PreparedStatement pstmt=null;
		ResultSet rset=null;
		int goodCnt=0;
		
		try {
			
		  pstmt=conn.prepareStatement(sql);
		  rset=pstmt.executeQuery();
		  
		  if(rset.next()){
			  goodCnt=rset.getInt("good_cnt");
		  }
		  
 		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
		   DBUtils.getInstance().ReleaseRes(conn, pstmt, rset);
		}				
		return goodCnt;
	}

	@Override
	public List<Good> loadTermPageGood(GoodQueryHelper helper, int begin,int end) {
		String sql=this.generateSQL(helper);
		sql="select * from (select rownum rn, a.* from ("+sql+") a where rownum<=? ) where rn>=?";
		
		System.out.println("get term page goods:"+sql+","+end+","+begin);
				
		Connection conn=DBUtils.getInstance().getConn();
		PreparedStatement pstmt=null;
		ResultSet rset=null;
		List<Good> goodList=null;
		
		try {
			
		  pstmt=conn.prepareStatement(sql);
		  pstmt.setInt(1, end);
		  pstmt.setInt(2, begin);
		  rset=pstmt.executeQuery();
		  goodList=new ArrayList<Good>();
		  
		  while(rset.next()){
			  Good good=new Good();
			  good.setGoodId(rset.getInt("good_id"));
			  good.setGoodName(rset.getString("good_name"));
			  good.setGoodPrice(rset.getDouble("good_price"));
			  good.setDescription(rset.getString("description"));
			  CategoryDao categoryDao = new CategoryDaoImpl();
			  //通过catId查询菜单
			  Category category = categoryDao.getCategoryById(rset.getInt("cate_id"));
			  good.setCategory(category);
			  good.setStockStatus(rset.getInt("stockstatus"));
		  
			  goodList.add(good);	
		  }
		  
 		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
		   DBUtils.getInstance().ReleaseRes(conn, pstmt, rset);
		}		
		return goodList;
	}
	

	@Override
	public Good getGoodById(int goodId) {
		Connection conn=DBUtils.getInstance().getConn();
		PreparedStatement pstmt=null;
		ResultSet rset=null;
		Good good=null;
		
		try{
			
		  pstmt=conn.prepareStatement(GET_GOOD_BYID);
		  pstmt.setInt(1, goodId);
		  rset=pstmt.executeQuery();
		  
		  good=new Good();
		  
		  if(rset.next()){
	
			  good.setGoodId(rset.getInt("good_id"));
			  good.setGoodName(rset.getString("good_name"));
			  good.setGoodPrice(rset.getDouble("good_price"));
			  good.setDescription(rset.getString("description"));
			  CategoryDao categoryDao = new CategoryDaoImpl();
			  //通过catId查询菜单
			  Category category = categoryDao.getCategoryById(rset.getInt("cate_id"));
			  good.setCategory(category);
			  good.setStockStatus(rset.getInt("stockstatus"));
		  	  
		  }
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBUtils.getInstance().ReleaseRes(conn, pstmt,rset);
		}
		
		return good;
	}

	@Override
	public void updetaGood(Good good) {
		Connection conn=DBUtils.getInstance().getConn();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
	
		try {
			conn.setAutoCommit(false);//设置数据库为不自动提交，必须的一步	
			
			pstmt=conn.prepareStatement(UPDATE_GOOD);
			pstmt.setString(1, good.getGoodName().toString());
			pstmt.setDouble(2, good.getGoodPrice());
			pstmt.setString(3, good.getDescription());
			pstmt.setInt(4,good.getCategory().getCateId());
			pstmt.setInt(5, good.getStockStatus());
			pstmt.setInt(6,good.getGoodId());
			pstmt.executeUpdate();
			
			   //以行的方式锁定   
			   pstmt=conn.prepareStatement("select good_image from t_good where good_id='"+good.getGoodId()+"'for update");
			   rs=pstmt.executeQuery();  
			   
			   if (rs.next()) {   
				   //得到流   
				   oracle.sql.BLOB blob = (oracle.sql.BLOB) rs.getBlob("good_image");   
				   //从得到的低级流构造一个高级流   
				   PrintStream ps = new PrintStream(blob.getBinaryOutputStream());   
				   ps.write(good.getGoodImage());
				   //清空流的缓存   
				   ps.flush();   
				   //关闭流，注意一定要关   
				   ps.close();   
				}
			   
			   conn.commit();			
			
		}catch(SQLException e)
		{
			e.printStackTrace();
			throw new ApplicationException("操作出错！");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtils.getInstance().ReleaseRes(conn, pstmt, rs);
		}		
	}
	
}
