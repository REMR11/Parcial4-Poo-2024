package com.parcialpoo.ufg.MR100823.services;

import java.util.List;

import com.parcialpoo.ufg.MR100823.models.Menu;

public interface IMenuService {

	public List<Menu> showAll();

	public Menu FindById(Integer pMenu_Id);

	public void saveMenu(Menu pMenu);

	public void deleteMenu(Menu pMenu);
}
