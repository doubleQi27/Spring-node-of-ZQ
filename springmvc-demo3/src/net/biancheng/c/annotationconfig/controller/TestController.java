package net.biancheng.c.annotationconfig.controller;

import net.biancheng.c.annotationconfig.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
public class TestController {
    @Resource
    private User user;
    /**
     * 测试 Spring 配置是否生效
     *
     * @return
     */
    @ResponseBody
    @GetMapping("/test")
    public User get() {
        return user;
    }
    /**
     * 测试异常映射是否生效
     *
     * @return
     */
    @GetMapping("/testException")
    public User get2() {
        int a = 10 / 0;
        return user;
    }
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String login(User user, HttpServletRequest request, Model model) {
        List<String> newFileNameList = new ArrayList<>();
        List<MultipartFile> photos = user.getPhotos();
        for (MultipartFile photo : photos) {
            String realPath = request.getServletContext().getRealPath("/upload/");
            System.out.println(realPath);
            File fileDir = new File(realPath);
            if (!fileDir.exists()) {
                fileDir.mkdir();
            }
            String filename = photo.getOriginalFilename();
            System.err.println("正在上传的图片为：" + filename);
            String newFileName = UUID.randomUUID() + filename;
            try {
                //将文件保存指定目录
                photo.transferTo(new File(realPath + newFileName));
            } catch (Exception e) {
                e.printStackTrace();
            }
            newFileNameList.add(newFileName);
        }
        System.out.println(user);
        model.addAttribute("type", "success");
        model.addAttribute("user", user);
        model.addAttribute("filePath", "/upload/");
        model.addAttribute("fileNameList", newFileNameList);
        return "success";
    }
}
