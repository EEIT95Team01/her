package com.eeit95.her.model.font;

import java.util.List;

public interface FontDAOInterface {
	public FontBean insert(FontBean fontBean);
    public FontBean update(FontBean fontBean);
    public boolean delete(String id);
    public FontBean selectById(String id);
    public List<FontBean> selectAll();
}
