package xyz.yuanmo.model;

import lombok.*;

/**
 * @ClassName Music
 * @Description TODO
 * @Author MatthewHan
 * @Date 2019/7/26 15:36
 * @Version 1.0
 **/
@ToString
@Setter(value = AccessLevel.PUBLIC)
@Getter(value = AccessLevel.PUBLIC)
@AllArgsConstructor
@NoArgsConstructor
public class Music {

    private String name;
    private Long length;
}
