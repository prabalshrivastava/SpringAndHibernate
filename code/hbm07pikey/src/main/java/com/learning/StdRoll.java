package com.learning;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class StdRoll implements Serializable {
	@Column
	private int std;
	@Column
	private int roll;

	public StdRoll() {
	}

	public StdRoll(int std, int roll) {
		this.std = std;
		this.roll = roll;
	}

	public int getStd() {
		return std;
	}

	public void setStd(int std) {
		this.std = std;
	}

	public int getRoll() {
		return roll;
	}

	public void setRoll(int roll) {
		this.roll = roll;
	}

	@Override
	public String toString() {
		return "StdRoll [std=" + std + ", roll=" + roll + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(roll, std);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof StdRoll))
			return false;
		StdRoll other = (StdRoll) obj;
		return roll == other.roll && std == other.std;
	}
	
}