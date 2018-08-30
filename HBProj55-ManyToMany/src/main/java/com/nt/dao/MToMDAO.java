package com.nt.dao;

public interface MToMDAO {
	public void saveDataUsingParents();
	public void saveDataUsingChilds();
	public void addNewParentToExistringChild();
	public void changeExistingProgrammerToAnotherExistingProject();
	public void loadObjectsUsingParents();

}
