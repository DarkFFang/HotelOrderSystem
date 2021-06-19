package ${package.Controller};

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.fang.hotel_order_system.util.JsonResponse;
import ${package.Service}.${table.serviceName};
import ${package.Entity}.${entity};

import java.util.List;


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

    private final Logger logger = LoggerFactory.getLogger( this.getClass() );

    @Autowired
    private ${entity}Service ${entity?uncap_first}Service;

    /**
    * 描述：查询整个列表
    *
    */
    @GetMapping("")
    public JsonResponse getList()throws Exception {
        List<${entity}> ${entity?uncap_first}List =  ${entity?uncap_first}Service.list();
        return JsonResponse.success(${entity?uncap_first}List);
    }

    /**
    * 描述：查询整个列表,并分页
    *
    */
    @GetMapping("/page/{current}/{size}")
    public JsonResponse getListPage(@PathVariable long current,@PathVariable long size)throws Exception {
        Page<${entity}> page=new Page<>(current,size);
        ${entity?uncap_first}Service.page(page);
        return JsonResponse.success(page);
    }

    /**
    * 描述：根据Id 查询
    *
    */
    @GetMapping("/{id}")
    public JsonResponse getById(@PathVariable("id") Long id)throws Exception {
        ${entity} ${entity?uncap_first} =  ${entity?uncap_first}Service.getById(id);
        return JsonResponse.success(${entity?uncap_first});
    }

    /**
    * 描述：根据Id删除
    *
    */
    @DeleteMapping("/{id}")
    public JsonResponse deleteById(@PathVariable("id") Long id) throws Exception {
        if(${entity?uncap_first}Service.removeById(id)){
            return JsonResponse.successMessage("删除成功！");
        }else{
            return JsonResponse.failure("删除失败！");
        }
    }


    /**
    * 描述：根据Id 更新
    *
    */
    @PutMapping("")
    public JsonResponse updateBy${entity}Id(${entity}  ${entity?uncap_first}) throws Exception {
        if(${entity?uncap_first}Service.updateById(${entity?uncap_first})){
            return JsonResponse.success(${entity?uncap_first}, "修改成功！");
        }else{
            return JsonResponse.failure("修改失败！");
        }
    }


    /**
    * 描述:创建${entity}
    *
    */
    @PostMapping("")
    public JsonResponse create(${entity}  ${entity?uncap_first}) throws Exception {
        if(${entity?uncap_first}Service.save(${entity?uncap_first})){
            return JsonResponse.success(${entity?uncap_first}, "添加成功！");
        }else{
            return JsonResponse.failure("添加失败！");
        }


    }
}

