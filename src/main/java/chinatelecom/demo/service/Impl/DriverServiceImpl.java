package chinatelecom.demo.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import chinatelecom.demo.entity.Driver;
import chinatelecom.demo.mapper.DriverMapper;
import chinatelecom.demo.service.DriverService;
import org.springframework.stereotype.Service;


@Service
public class DriverServiceImpl extends ServiceImpl<DriverMapper, Driver> implements DriverService {

    @Override
    public Page<Driver> search(int page, int size, String name, String idCardNumber, String phoneNumber, String licenseStatus) {
        LambdaQueryWrapper<Driver> wrapper = new LambdaQueryWrapper<>();

        if (StringUtils.isNotBlank(name)) {
            wrapper.like(Driver::getName, name);
        }
        if (StringUtils.isNotBlank(idCardNumber)) {
            wrapper.eq(Driver::getIdCardNumber, idCardNumber);
        }
        if (StringUtils.isNotBlank(phoneNumber)) {
            wrapper.like(Driver::getPhoneNumber, phoneNumber);
        }
        if (StringUtils.isNotBlank(licenseStatus)) {
            wrapper.eq(Driver::getLicenseStatus, licenseStatus);
        }

        return this.page(new Page<>(page, size), wrapper);
    }
}

