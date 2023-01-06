package com.salvatierravictor.portfolio.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="education")

public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "The institute cannot be empty")
    private String institute;

    @NotNull(message = "The title cannot be empty")
    private String title;

    @NotNull(message = "The imageUrl cannot be empty")
    private String imageUrl;

    @Column(name = "start_date")
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate startDate;

    @Column(name = "finish-date")
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate finishDate;

}
