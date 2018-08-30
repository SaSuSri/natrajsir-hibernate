package com.nt.dao;

public interface OToMDAO {
	public void SaveDataUsingParents();
	public void loadDataUsingParent();
	public void deleteDataUsingParent();
    public void deleteOneChildFromCollectionOfChildsInAParent();
    public void addingNewChildToExistingParent();
    public void deleteAllChildsOfAParent();
}
