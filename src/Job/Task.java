package Job;

import Database.*;

public class Task {

	private long taskID;
	private int jobNo;
	private String taskName;
	private String description;
	private String status = "Uncompleted";
	SQL_TaskHelper sqL_TaskHelper;

	public boolean isAvalaible() {
		// TODO - implement Task.isAvalaible
		throw new UnsupportedOperationException();
	}

	public void complete() {
		// TODO - implement Task.complete
		throw new UnsupportedOperationException();
	}

	public void unComplete() {
		// TODO - implement Task.unComplete
		throw new UnsupportedOperationException();
	}

	public int getJobNo() {
		return this.jobNo;
	}

	public String getTaskID() {
		// TODO - implement Task.getTaskID
		throw new UnsupportedOperationException();
	}

	public String getTaskName() {
		return this.taskName;
	}

	/**
	 * 
	 * @param taskName
	 */
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getDescription() {
		return this.description;
	}

	/**
	 * 
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return this.status;
	}

}