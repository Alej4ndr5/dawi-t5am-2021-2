package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_productos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Productos {
	@Id
	private String idprod;
	private String descripcion;
	private double precio;
	private int estado;
	private int idcategoria;
	private int stock;
}
