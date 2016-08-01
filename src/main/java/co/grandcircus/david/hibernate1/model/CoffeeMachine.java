package co.grandcircus.david.hibernate1.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "COFFEE_MACHINE")
public class CoffeeMachine {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	Integer id;
	@Column(name = "FLOOR")
	int floor;
	@Column(name = "MANUAL_WATER_FILL")
	@Type(type = "true_false")
	boolean requiresManualWaterFill;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

	public boolean isRequiresManualWaterFill() {
		return requiresManualWaterFill;
	}

	public void setRequiresManualWaterFill(boolean requiresManualWaterFill) {
		this.requiresManualWaterFill = requiresManualWaterFill;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + floor;
		result = prime * result + (requiresManualWaterFill ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CoffeeMachine other = (CoffeeMachine) obj;
		if (floor != other.floor)
			return false;
		if (requiresManualWaterFill != other.requiresManualWaterFill)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CoffeeMachine [id=" + id + ", floor=" + floor + ", requiresManualWaterFill=" + requiresManualWaterFill
				+ "]";
	}

	
}
