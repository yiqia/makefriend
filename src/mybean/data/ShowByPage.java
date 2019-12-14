package mybean.data;
import com.sun.rowset.*;
public class ShowByPage {
	CachedRowSetImpl rowSet=null;	// 数据行容器，用于保存类似于Excel之类的表格列，可以同结果集一样操作
	int pageSize=10;	// 每页显示的数目
	int pageAllCount=0;	// 最大页面
	int showPage=1;	// 显示第几页
	StringBuffer presentPageResult;
	public CachedRowSetImpl getRowSet() {
		return rowSet;
	}
	public void setRowSet(CachedRowSetImpl rowSet) {
		this.rowSet = rowSet;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageAllCount() {
		return pageAllCount;
	}
	public void setPageAllCount(int pageAllCount) {
		this.pageAllCount = pageAllCount;
	}
	public int getShowPage() {
		return showPage;
	}
	public void setShowPage(int showPage) {
		this.showPage = showPage;
	}
	public StringBuffer getPresentPageResult() {
		return presentPageResult;
	}
	public void setPresentPageResult(StringBuffer presentPageResult) {
		this.presentPageResult = presentPageResult;
	}
	@Override
	public String toString() {
		return "ShowByPage [rowSet=" + rowSet + ", pageSize=" + pageSize + ", pageAllCount=" + pageAllCount
				+ ", showPage=" + showPage + ", presentPageResult=" + presentPageResult + "]";
	}
	
}
