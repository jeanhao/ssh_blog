package com.utils;

public class Page {
	private int pageNow = 1;		// ��ǰҳ��
	private int pageSize = 22;		// ÿҳ��ʾ��������¼
	private int totalPage;			// ���ж���ҳ
	private int totalSize;			// һ�����ټ�¼
	@SuppressWarnings("unused")
	private boolean hasFirst;		// �Ƿ�����ҳ
	@SuppressWarnings("unused")
	private boolean hasPre;			// �Ƿ���ǰһҳ
	@SuppressWarnings("unused")
	private boolean hasNext;		// �Ƿ�����һҳ
	@SuppressWarnings("unused")
	private boolean hasLast;		// �Ƿ������һҳ

	public Page(int pageNow, int pageSize, int totalSize) {
		// ���ù��պ���Ϊ������ֵ
		this.pageNow = pageNow;
		this.pageSize = pageSize;
		this.totalSize = totalSize;
	}

	public int getPageNow() {
		return pageNow;
	}

	public void setPageNow(int pageNow) {
		this.pageNow = pageNow;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalPage() {
		// һ������ҳ���㷨
		totalPage = getTotalSize() / getPageSize();
		if (totalSize % pageSize != 0)
			totalPage++;
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getTotalSize() {
		return totalSize;
	}

	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}

	public boolean isHasFirst() {
		// �����ǰΪ��һҳ��û����ҳ
		if (pageNow == 1)
			return false;
		else
			return true;
	}

	public void setHasFirst(boolean hasFirst) {
		this.hasFirst = hasFirst;
	}

	public boolean isHasPre() {
		// �������ҳ����ǰһҳ����Ϊ����ҳ�Ͳ��ǵ�һҳ
		if (this.isHasFirst())
			return true;
		else
			return false;
	}

	public void setHasPre(boolean hasPre) {
		this.hasPre = hasPre;
	}

	public boolean isHasNext() {
		// �����βҳ������һҳ����Ϊ��βҳ�����������һҳ
		if (isHasLast())
			return true;
		else
			return false;
	}

	public void setHasNext(boolean hasNext) {
		this.hasNext = hasNext;
	}

	public boolean isHasLast() {
		// ����������һҳ����βҳ
		if (pageNow == this.getTotalPage())
			return false;
		else
			return true;
	}

	public void setHasLast(boolean hasLast) {
		this.hasLast = hasLast;
	}

}
