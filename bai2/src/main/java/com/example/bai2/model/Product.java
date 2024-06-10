package com.example.bai2.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Length;


@Setter
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
@NotBlank(message = "tên sản phẩm không được để trống ")
    private String name;
@NotNull(message="giá sản phẩm không được để trống")
@Min(value =1, message="giá sản phẩm không được nhỏ hơn 1")
@Max(value=99999999, message="giá sản phẩm không được lớn hơn 9999999999")
    private double price;
    private String description;
    @Length(min=0, max=50,message="df")
    private String ImageUrl ;
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;
}
