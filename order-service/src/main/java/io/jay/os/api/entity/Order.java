package io.jay.os.api.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="ORDER_TB")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order {

	@Id
	private int id;
	private String name;
	private int qty;
	private double price;
}
