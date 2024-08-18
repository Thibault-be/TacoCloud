/*
package tacos.web.api;


import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tacos.Taco;
import tacos.TacoOrder;
import tacos.data.TacoRepository;

import java.util.Optional;

@RestController
@RequestMapping(path= "api/tacos", produces= "application/json")
@CrossOrigin(origins="http://tacocloud:8080")
public class TacoController {

    private TacoRepository tacoRepo;


    public TacoController(TacoRepository tacoRepo){
        this.tacoRepo = tacoRepo;
    }

    @GetMapping(params="recent")
    public Iterable<Taco> recentTacos(){
        //PageRequest page = PageRequest.of(0, 12, Sort.by("createdAt").descending());
        return tacoRepo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Taco> tacoById(@PathVariable("id") Long id){
        Optional<Taco> optionalTaco = tacoRepo.findById(id);

        if(optionalTaco.isPresent()){
            return new ResponseEntity<>(optionalTaco.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Taco postTaco(@RequestBody Taco taco){
        return tacoRepo.save(taco);
    }

//    @PutMapping(path = "/{orderId}", consumes = "application/json")
//    public TacoOrder putOrder(@PathVariable("orderId") Long orderId, @RequestBody TacoOrder order){
//        order.setId(orderId);
//
//    }


    @DeleteMapping("/{orderId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOrder(@PathVariable("orderId") Long orderId){
        try{
            tacoRepo.deleteById(orderId);
        } catch (EmptyResultDataAccessException e){
            // do nothing
        }
    }

}
*/
