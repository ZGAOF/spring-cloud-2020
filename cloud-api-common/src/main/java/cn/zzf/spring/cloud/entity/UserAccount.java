package cn.zzf.spring.cloud.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * @author GaoFeng
 * @date 2020/11/12 11:13
 */
@Accessors(chain = true)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserAccount {
    private Long id;
    private Long userId;
    private Integer total;
    private Integer used;
    private Integer residue;
}
