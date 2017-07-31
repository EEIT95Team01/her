package com.eeit95.her.model.font;

import java.util.List;

public interface WriterDAOInterface {
	public void insert(WriterBean writerBean);
    public void update(WriterBean writerBean);
    public void delete(int id);
    public WriterBean selectById(int id);
    public List<WriterBean> selectAll();
}
