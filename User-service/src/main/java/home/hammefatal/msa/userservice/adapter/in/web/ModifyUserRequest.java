package home.hammefatal.msa.userservice.adapter.in.web;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ModifyUserRequest {

    private String password;
    private String email;
    private String name;
    private String nickName;
    private String phoneNumber;

}
