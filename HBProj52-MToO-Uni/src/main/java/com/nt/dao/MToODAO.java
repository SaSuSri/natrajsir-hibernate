package com.nt.dao;

public interface MToODAO {
	
	public void saveDataUsingChilds();
	public  void loadDataUsingChilds();
	public void  deleteDataUsingChilds();
	public void deleteOneChildOfAParent();
	public void addNewChildToExistingParent();
	public void addExistingChildToNewDepartment();
	public void deleteAllChildsOfAParent();

}
