package cn.pzhu.pserson.service;

import cn.pzhu.pserson.domain.User;
import cn.pzhu.pserson.domain.response.IndexHeaderResDTO;
import java.util.Map;

public interface UserService {

  String repeatName(String name);

  void insertUser(User user);

  IndexHeaderResDTO countHeader();

}
