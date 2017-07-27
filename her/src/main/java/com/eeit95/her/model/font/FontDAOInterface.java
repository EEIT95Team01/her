package com.eeit95.her.model.font;

import java.util.List;

public interface FontDAOInterface {
	public void insert(FontBean fontBean);
    public void update(FontBean fontBean);
    public void delete(Integer empno);
    public FontBean findByPrimaryKey(Integer fontId);
    public List<FontBean> getAll();
}
