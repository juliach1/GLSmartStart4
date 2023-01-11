package Rest;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RestTest {

    public List<Student> students = new ArrayList<>();

    public RestTest() {
        students.add(new Student("John", "Smith"));
        students.add(new Student("Jane", "Doe"));
        students.add(new Student("Mary", "Ann"));
    }


    @GetMapping("/students")
    public List<Student> getStudents(){

        return students;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){

        return students.get(studentId);
    }

    @PostMapping("/students")
    public Student addStudent(@RequestBody Student theStudent){
        students.add(theStudent);

        return theStudent;
    }

    @PutMapping("/students/{studentId}")
    public Student updateStudent(@PathVariable int studentId, @RequestBody Student theStudent){
        students.add(studentId, theStudent);

        return theStudent;
    }

    @DeleteMapping("/students/{studentId}")
    public List<Student> deleteStudent(@PathVariable int studentId){
        students.remove(studentId);

        return students;
    }

}

