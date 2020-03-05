package br.com.devdojo.endpoint;

import br.com.devdojo.error.CustomErrorType;
import br.com.devdojo.model.Student;
import br.com.devdojo.util.DateUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import static java.util.Arrays.asList;
//Endpoint é o ponto onde os usuário vão chegar para pegar as informações da API, no caso Estudantes.
@RestController
//RequestMapping libera para o usuário pesquisar as informações do student
@RequestMapping("students") //O usuário pesquisará na URI por "student" para acessar minha API
public class StudentEndpoint { //Tudo relacionado a Student que a API entregará.
    //Faz a injeção das dependencias, instancia o objeto para mim.
    private final DateUtil dateUtil;

    public StudentEndpoint(DateUtil dateUtil) {
        this.dateUtil = dateUtil;
    }

    //RequestMapping libera o metodo com REQUEST GET com o PATH "/list" para o usuario requisitar
    //@RequestMapping(method = RequestMethod.GET)//, path = "/list")  adicionar "/list" para acessar listAll se tiver outros metodos GET.
    @GetMapping //Substitui a anotação de cima
    public ResponseEntity<?> listAll(){ //Metodo para listar os Estudantes
        System.out.println(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        return new ResponseEntity<>(Student.studentList, HttpStatus.OK); //Status da Requisição
        //asList retorna uma lista com os objetos inseridos;
    }

    //@RequestMapping(method = RequestMethod.GET, path = "/{id}") //tenho 2 metodos GET entao tenho que dizer o Path
    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable("id") int id){ //PathVariable pega o id para a variavel
        Student student = new Student();
        student.setId(id);
        int index = Student.studentList.indexOf(student);
        if(index == -1)
            return new ResponseEntity<>(new CustomErrorType("Student not found."), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(Student.studentList.get(index), HttpStatus.OK);
    }

    //@RequestMapping(method = RequestMethod.POST)
    @PostMapping
    public ResponseEntity<?> save(@RequestBody Student student){ //Vai pegar o corpo da requisição e procurar um Stundent
        if(Student.studentList.contains(student))
            return new ResponseEntity<>("Student already created.",HttpStatus.CREATED);

        Student.studentList.add(student);
        return new ResponseEntity<>("Student "+student.getName()+" added.", HttpStatus.CREATED);
    }

    //@RequestMapping(method = RequestMethod.DELETE)
    @DeleteMapping
    public ResponseEntity<?> delete(@RequestBody Student student){
        Student.studentList.remove(student);
        return new ResponseEntity<>("Student "+student.getName()+" deleted.", HttpStatus.OK);
    }

    //@RequestMapping(method = RequestMethod.PUT)
    @PutMapping
    public ResponseEntity<?> update(@RequestBody Student student){
        Student.studentList.remove(student);
        Student.studentList.add(student);
        return new ResponseEntity<>("Student updated.", HttpStatus.OK);
    }
}