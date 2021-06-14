package ${package.Controller};

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.fang.hotel_order_system.util.JsonResponse;
import ${package.Service}.${table.serviceName};
import ${package.Entity}.${entity};


/**
 *
 *  前端控制器
 *
 *
 * @author ${author}
 * @since ${date}
 * @version v1.0
 */
@RestController
@RequestMapping("/api/${table.entityPath}")
public class ${table.controllerName} {

    private final Logger logger = LoggerFactory.getLogger( ${table.controllerName}.class );

    @Autowired
    private ${entity}Service ${entity?uncap_first}Service;

    /**
    * 描述：根据Id 查询
    *
    */
    @GetMapping("/{id}")
    public JsonResponse getById(@PathVariable("id") Long id)throws Exception {
        ${entity}  ${entity?uncap_first} =  ${entity?uncap_first}Service.getById(id);
        return JsonResponse.success(${entity?uncap_first});
    }

    /**
    * 描述：根据Id删除
    *
    */
    @DeleteMapping("/{id}")
    public JsonResponse deleteById(@PathVariable("id") Long id) throws Exception {
        ${entity?uncap_first}Service.removeById(id);
        return JsonResponse.success(null);
    }


    /**
    * 描述：根据Id 更新
    *
    */
    @PutMapping("/{id}")
    public JsonResponse update${entity}(@PathVariable("id") Long  id,${entity}  ${entity?uncap_first}) throws Exception {
        ${entity?uncap_first}.set${entity}Id(id);
        ${entity?uncap_first}Service.updateById(${entity?uncap_first});
        return JsonResponse.success(null);
    }


    /**
    * 描述:创建${entity}
    *
    */
    @PostMapping("")
    public JsonResponse create(${entity}  ${entity?uncap_first}) throws Exception {
        ${entity?uncap_first}Service.save(${entity?uncap_first});
        return JsonResponse.success(null);
    }
}

