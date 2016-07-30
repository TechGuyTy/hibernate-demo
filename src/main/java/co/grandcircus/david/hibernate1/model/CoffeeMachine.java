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
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
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

	
}
