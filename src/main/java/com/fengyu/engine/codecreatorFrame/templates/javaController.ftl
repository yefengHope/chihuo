package ${config.packagePath};

import com.fengyu.system.base.BaseController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Map;

/**
* Created by HanFeng on 2017/7/28.
*/
@Controller
@RequestMapping(value = "")
public class ${config.className}Controller extends BaseController {

    private static Logger logger;

    static {
        logger = LoggerFactory.getLogger(RoleController.class);
    }

    @RequestMapping(value = "page.htm", method = RequestMethod.GET)
    public String toPage() {
        return "";
    }


    @RequestMapping(value = "page_data.json", method = RequestMethod.POST)
    @ResponseBody
    public Map pageJson() {
        return returnBootTable(true,"查询成功",new ArrayList(),0);
    }

    @RequestMapping(value = "to_add.htm", method = RequestMethod.GET)
    public String toAdd() {
        return "";
    }

    @RequestMapping(value = "add.htm", method = RequestMethod.POST)
    public Map add() {
        return returnAjax(true,"",null,null);
    }

    @RequestMapping(value = "to_update.htm", method = RequestMethod.GET)
    public String toUpdate() {
        return "";
    }

    @RequestMapping(value = "update.htm", method = RequestMethod.POST)
    public Map update() {
        return returnAjax(true,"",null,null);
    }

    @RequestMapping(value = "del_rows.htm", method = RequestMethod.POST)
    @ResponseBody
    public Map delRows() {
        return returnAjax(true,"",null,null);
    }

}
