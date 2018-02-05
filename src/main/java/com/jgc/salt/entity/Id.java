package com.jgc.salt.entity;

public class Id {
	private Long lastId;

	public Long getLastId() {
		return lastId;
	}

	public void setLastId(Long lastId) {
		this.lastId = lastId;
	}

	public Id(Long lastId) {
		this.lastId = lastId;
	}
	
	public Id() {
	}

	@Override
	public boolean equals(Object that) {
		if (this == that) {
			return true;
		}
		if (that == null) {
			return false;
		}
		if (getClass() != that.getClass()) {
			return false;
		}
		Id other = (Id) that;
		return (this.getLastId() == null ? other.getLastId() == null : this.getLastId().equals(other.getLastId()));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getLastId() == null) ? 0 : getLastId().hashCode());
		return result;
	}
}