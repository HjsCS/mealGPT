package com.alimama.mealgpt.pojo;

import com.alimama.mealgpt.entity.FitnessInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@AllArgsConstructor
@ToString
public class FitnessInfoUpdateRequest {
    private String jwtToken;
    private FitnessInfo fitnessInfo;
}
