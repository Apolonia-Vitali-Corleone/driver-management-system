package chinatelecom.demo.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import chinatelecom.demo.entity.Driver;
import chinatelecom.demo.common.PageResult;
import chinatelecom.demo.common.Result;
import chinatelecom.demo.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/drivers")
public class DriverController {

    @Autowired
    private DriverService driverService;


    @PostMapping
    public Result<?> Qq(@RequestBody Driver driver) {
        boolean ok = driverService.save(driver);
        return ok ? Result.success(null) : Result.error("Create failed!");
    }

    @PutMapping
    public Result<Driver> update(@RequestBody Driver driver) {

        boolean ok = driverService.updateById(driver);
        return ok ? Result.success(null) : Result.error("Update failed!");
    }

    @GetMapping
    public Result<PageResult<Driver>> list(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String idCardNumber,
            @RequestParam(required = false) String phoneNumber,
            @RequestParam(required = false) String licenseStatus
    ) {

        Page<Driver> pageResult = driverService.search(page, size, name, idCardNumber, phoneNumber, licenseStatus);

        PageResult<Driver> result = new PageResult<>(
                pageResult.getRecords(),
                pageResult.getTotal(),
                pageResult.getCurrent(),
                pageResult.getSize()
        );

        return Result.success(result);
    }


    @GetMapping("/{id}")
    public Result<Driver> getDriver(@PathVariable Long id) {
        Driver driver = driverService.getById(id);
        if (driver != null) {
            return Result.success(driver);
        } else {
            return Result.error("The driver does not exist!");
        }
    }

    @DeleteMapping("/{id}")
    public Result<?> delete(@PathVariable Long id) {
        boolean ok = driverService.removeById(id);
        return ok ? Result.success(null) : Result.error("Delete failed!");
    }

}
