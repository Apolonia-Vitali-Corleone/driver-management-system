package chinatelecom.demo.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import chinatelecom.demo.entity.Driver;

public interface DriverService extends IService<Driver> {
    Page<Driver> search(int page, int size, String name, String idCardNumber, String phoneNumber, String licenseStatus);

}
