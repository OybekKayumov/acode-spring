package com.acode;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Customer {

	@Id
	@SequenceGenerator(
					name = "customer_id_sequence",
					sequenceName = "customer_id_sequence",
					allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,
									generator = "customer_id_sequence")
	private Integer id;
	private String name;
	private String email;
	private Integer age;

}
