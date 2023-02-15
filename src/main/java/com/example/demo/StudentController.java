package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class StudentController {
	
	static List<Student> list = new ArrayList<>();
    static int id = 2;

    static {
        list.add(new Student(1, "홍길동", "201014198", "hong@skhu.net"));
        list.add(new Student(2, "임꺽정", "201014199", "lim@skhu.net"));
    }

    @GetMapping("api/student/{id}")
    public Student student(@PathVariable("id") int id) {
        int index = indexOf(id);
        return list.get(index);
    }

    @GetMapping("api/student/list")
    public List<Student> list() {
        return list;
    }

    @PostMapping("api/student/add")
    public String add(@RequestBody Student student) {
        list.add(student);
        return "success";
    }

    @PutMapping("api/student/update")
    public String update(@RequestBody Student student) {
        int index = indexOf(student.getId());
        list.set(index, student);
        return "success";
    }

    @DeleteMapping("api/student/delete")
    public String delete(int[] idlist) {
        for (int id : idlist) {
            int index = indexOf(id);
            if (index >= 0) list.remove(index);
        }
        return "success";
    }

    private int indexOf(int id) {
        for (int i = 0; i < list.size(); ++i)
            if (list.get(i).getId() == id)
                return i;
        return -1;

}
}

