package mybean.data;
import com.sun.rowset.*;
public class ShowByPage {
	CachedRowSetImpl rowSet=null;	// ���������������ڱ���������Excel֮��ı���У�����ͬ�����һ������
	int pageSize=10;	// ÿҳ��ʾ����Ŀ
	int pageAllCount=0;	// ���ҳ��
	int showPage=1;	// ��ʾ�ڼ�ҳ
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
