package org.dbc.admin.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.dbc.admin.utils.BaseUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: ray, liu.
 * @Date: 2018/10/4 16:15
 */

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/admin")
public class LoginController {

    @RequestMapping("/info")
    public Object info(){
        Map<String,Object> map = new HashMap<>();
        map.put("info","hello hello hello");
        return map;
    }

    @GetMapping(path = "/principal", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Principal> getPrincipal(Principal user) {
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout() {
        return new ResponseEntity<String>(HttpStatus.OK);
    }

    @GetMapping("/loginFail")
    public ResponseEntity<String> loginFail(Model model) {
        return new ResponseEntity<String>(HttpStatus.UNAUTHORIZED);
    }

    @PostMapping("/welcome")
    public void login(HttpServletRequest req,
                                        HttpServletResponse resp) throws Exception {

        resp.setStatus(HttpServletResponse.SC_OK);
        resp.setContentType("application/json;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        ObjectMapper objectMapper = new ObjectMapper();
        String s = "{\"status\":\"success\",\"msg\": " + objectMapper.writeValueAsString(BaseUtils.getCurrentUser()) + "}";
        out.write(s);
        out.flush();
        out.close();

    }
}
