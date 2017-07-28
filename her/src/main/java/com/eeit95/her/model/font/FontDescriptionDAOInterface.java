package com.eeit95.her.model.font;

import java.util.List;

public interface FontDescriptionDAOInterface {
	public void insert(FontDescriptionBean fontDescriptionBean);
    public void update(FontDescriptionBean fontDescriptionBean);
    public void delete(String fontId,int order);
    public FontBean selectById(String fontId,int order);
    public List<FontBean> selectAll();
}
