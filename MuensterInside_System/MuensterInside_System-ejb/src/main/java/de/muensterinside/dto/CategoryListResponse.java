package de.muensterinside.dto;

import java.util.List;

/**
 * @author Lennart Giesen
 */
public class CategoryListResponse extends ReturncodeResponse {

	private List<CategoryTO> categoryList;
	
	public List<CategoryTO> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(List<CategoryTO> categoryList) {
		this.categoryList = categoryList;
	}
}
