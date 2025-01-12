package com.easypan.entity.query;
import com.easypan.entity.enums.PageSize;

/**
 * pageNo：当前页码。
 * countTotal：总记录数。
 * pageSize：每页记录数。
 * pageTotal：总页数。
 * start：当前页的起始记录索引。
 * end：当前页的结束记录索引。
 * 构造方法
 * SimplePage()：无参构造方法。
 * SimplePage(Integer pageNo, int countTotal, int pageSize)：带参数的构造方法，用于初始化分页信息，	并调用action()方法计算分页信息。
 * SimplePage(int start, int end)：带起始和结束索引的构造方法。
 * 方法
 * action()：计算分页信息的方法。根据总记录数和每页记录数计算总页数，并调整当前页码、起始和结束索引。
 * getStart()：返回当前页的起始记录索引。
 * getEnd()：返回当前页的结束记录索引。
 * getPageTotal()：返回总页数。
 * getPageNo()：返回当前页码。
 * setPageNo(int pageNo)：设置当前页码。
 * setPageTotal(int pageTotal)：设置总页数。
 * getCountTotal()：返回总记录数。
 * getPageSize()：返回每页记录数。
 * setStart(int start)：设置起始记录索引。
 * setEnd(int end)：设置结束记录索引。
 * setCountTotal(int countTotal)：设置总记录数，并调用action()方法重新计算分页信息。
 * setPageSize(int pageSize)：设置每页记录数。
 * action()方法说明
 * 如果pageSize小于等于0，默认设置为20。
 * 根据countTotal和pageSize计算pageTotal（总页数）。
 * 调整pageNo（当前页码）使其在合法范围内（1到pageTotal之间）。
 * 计算start和end的索引值
 */

public class SimplePage {
	private int pageNo;
	private int countTotal;
	private int pageSize;
	private int pageTotal;
	private int start;
	private int end;

	public SimplePage() {
	}

	public SimplePage(Integer pageNo, int countTotal, int pageSize) {
		if (null == pageNo) {
			pageNo = 0;
		}
		this.pageNo = pageNo;
		this.countTotal = countTotal;
		this.pageSize = pageSize;
		action();
	}

	public SimplePage(int start, int end) {
		this.start = start;
		this.end = end;
	}

	public void action() {
		if (this.pageSize <= 0) {
			this.pageSize = PageSize.SIZE20.getSize();
		}
		if (this.countTotal > 0) {
			this.pageTotal = this.countTotal % this.pageSize == 0 ? this.countTotal / this.pageSize
					: this.countTotal / this.pageSize + 1;
		} else {
			pageTotal = 1;
		}

		if (pageNo <= 1) {
			pageNo = 1;
		}
		if (pageNo > pageTotal) {
			pageNo = pageTotal;
		}
		this.start = (pageNo - 1) * pageSize;
		this.end = this.pageSize;
	}

	public int getStart() {
		return start;
	}

	public int getEnd() {
		return end;
	}

	public int getPageTotal() {
		return pageTotal;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public void setPageTotal(int pageTotal) {
		this.pageTotal = pageTotal;
	}

	public int getCountTotal() {
		return countTotal;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public void setCountTotal(int countTotal) {
		this.countTotal = countTotal;
		this.action();
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

}
