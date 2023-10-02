package com.alimama.mealgpt.pojo;

import com.alimama.mealgpt.entity.FitnessInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ResponseListEntity {

    private HttpStatus code;
    private List<FitnessInfo> dataList;

}
