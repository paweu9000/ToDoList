package com.example.demo.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "td")
@Getter
@Setter
@NoArgsConstructor
public class Task {

    @Id
    @GeneratedValue
    @Type(type = "uuid-char")
    @Column(name = "id")
    private UUID id;

    @Length(min = 4, max = 30)
    @NotNull(message = "Task name is too short!")
    @Column(name = "task")
    private String taskName;

    @Column(name = "category")
    @NotNull(message = "Category cannot be empty!")
    private String category;

    @Min(value = 1)
    @Max(value = 5)
    @NotNull(message = "Priority must be number between 1-5")
    @Column(name = "priority")
    private int priority;

    @Future(message = "The date must be located in future")
    @NotNull(message = "You must choose date!")
    @Column(name = "finish_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date finishDate;


}
