package vn.edu.iuh.fit.dtos;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "phong_ban", schema = "demo")
public class PhongBan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "maPhongBan", nullable = false)
    private Long maPhongBan;

    @Size(max = 100)
    @NotNull
    @Column(name = "tenPhongBan", nullable = false, length = 100)
    private String tenPhongBan;

}