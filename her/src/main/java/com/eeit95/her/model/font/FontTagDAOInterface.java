package com.eeit95.her.model.font;

import java.util.List;

public interface FontTagDAOInterface {
	public FontTagBean insert(FontTagBean fontTagBean);
    public FontTagBean update(FontTagBean fontTagBean);
    public boolean delete(String fontId,int tagId);
    public List<FontTagBean> selectByFontId(String fontId);
    public List<FontTagBean> selectByTagId(int tagId);
    public List<FontTagBean> selectAll();
}
