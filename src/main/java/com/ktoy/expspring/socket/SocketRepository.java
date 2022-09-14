package com.ktoy.expspring.socket;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SocketRepository {

    SocketDTO selectOneBySocketIdx(SocketDTO socketDTO);
}
