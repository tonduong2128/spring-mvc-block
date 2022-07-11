package com.tonduong.paging;

import com.tonduong.sort.Sorter;

public interface Pageble {
	Integer getPage();
	Integer getOffset();
	Integer getLimit();
	Sorter getSorter();
}
