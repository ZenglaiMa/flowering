package com.happier.flowering.mapper;

import com.happier.flowering.entity.Message;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * @ClassName MessageMapper
 * @Description
 * @Author 喬
 * @Date 2020-04-15 15:08
 */
public interface MessageMapper {


    /**
     * 个人所有私信查询
     * @param userId
     * @return
     */
    List<Message> searchMessageByUserId(@Param("userId") int userId);


}
