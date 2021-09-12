package com.me.carsite.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Data

@NoArgsConstructor
@Table(name = "customer")
@Entity
@PrimaryKeyJoinColumn(name="id")
public class Customer extends User {

}
