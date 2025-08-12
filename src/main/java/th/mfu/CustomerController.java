package th.mfu;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
        @Autowired
        CustomerRepository customerRepo;


         @Autowired
    private CustomerTierRepo tierRepo;


    @GetMapping ("/customers")
    public ResponseEntity<Collection> getAllCustomers() {
       Collection result = customerRepo.findAll();
       return new ResponseEntity<Collection>(result, HttpStatus.OK);
    }

    @GetMapping("/customers/name/{prefix}")
    public ResponseEntity<Collection> searchCustomerByName(@PathVariable String prefix){
        List<Customer> results = customerRepo.findByNameStartingWith(prefix);
        return new ResponseEntity<Collection>(results, HttpStatus.OK);
    }



    @GetMapping("/customers/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable Integer id) {
        if (customerRepo.existsById(id)) {
          Optional   <Customer> foundcustomer = customerRepo.findById(id);
        return new ResponseEntity <Customer>(foundcustomer.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
        }
       
    }


   @PostMapping("/customers")
public ResponseEntity<String> createCustomer(@RequestBody Customer customer) {
    if (customer.getCustomerTier() != null && customer.getCustomerTier().getId() != null) {
       Optional<CustomerTier> tierOpt = tierRepo.findById(customer.getCustomerTier().getId()); 
        if (tierOpt.isPresent()) {
            customer.setCustomerTier(tierOpt.get());
        } else {
            return new ResponseEntity<>("Customer tier not found", HttpStatus.BAD_REQUEST);
        }
    }
    customerRepo.save(customer);
    return new ResponseEntity<>("Customer created", HttpStatus.CREATED);
}

    @DeleteMapping("/customers/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Integer id) {
        customerRepo.deleteById(id);
         return new ResponseEntity<String>("Customer deleted", HttpStatus.NO_CONTENT);
    }
}
