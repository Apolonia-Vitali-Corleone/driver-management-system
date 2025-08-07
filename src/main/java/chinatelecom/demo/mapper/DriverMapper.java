package chinatelecom.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import chinatelecom.demo.entity.Driver;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DriverMapper extends BaseMapper<Driver> {
    // MyBatis-Plus Automatically generate the universal CRUD
}

