package com.nt.dao;

public interface OToMDAO {
	public void SaveDataUsingParents();
	public void loadDataUsingParent();
    public void deleteOneChildFromCollectionOfChildsInAParent();
}
