package com.alimama.mealgpt.pojo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Entity
@Table(name = "gpt_plan")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class GptPlanEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String userName;
    private String plan;
}
