package com.eeit95.her.model.font;

import java.util.List;

public interface FontDescriptionDAOInterface {
	public FontDescriptionBean insert(FontDescriptionBean fontDescriptionBean);
    public FontDescriptionBean update(FontDescriptionBean fontDescriptionBean);
    public boolean delete(String fontId);
    public List<FontDescriptionBean> selectById(String fontId);
    public List<FontDescriptionBean> selectAll();
}
