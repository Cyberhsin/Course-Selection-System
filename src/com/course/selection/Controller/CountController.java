package com.course.selection.Controller;

import com.course.selection.Entity.StudentEntity;
import com.course.selection.Service.SelectionService;
import com.course.selection.Service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * Created by Shinlee on 2017/1/5.
 */
@Controller
public class CountController {

    @Resource(name = "studentService")
    private StudentService studentService;

    @Resource(name = "selectionService")
    private SelectionService selectionService;

    //学生籍贯统计
    @RequestMapping("/studentNativeCount")
    public String studentNativeCount(ModelMap modelMap) {
        HashMap<String, Long> nativeCount = studentService.studentNativeCount();
        modelMap.addAttribute("nativeCount", nativeCount);
        return "Admin/studentNativeCount";
    }

    //学生爱好统计
    @RequestMapping("/studentHobbyCount")
    public String studentHobbyCount(ModelMap modelMap){
        HashMap<String, Long> hobbyCount = studentService.studentHobbyCount();
        modelMap.addAttribute("hobbyCount", hobbyCount);
        return "Admin/studentHobbyCount";
    }

    //选课统计
    @RequestMapping("/selectionCount")
    public String studentSelectionCount(ModelMap modelMap) {
        HashMap<StudentEntity, Long> selectionCount = selectionService.selectionCount();
        modelMap.addAttribute("selectionCount", selectionCount);
        return "Admin/studentSelectionCount";
    }
}
