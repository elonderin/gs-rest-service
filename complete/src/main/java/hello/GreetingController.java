package hello;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

  private static final String template = "Hello, %s!";
  private final AtomicLong    counter  = new AtomicLong();

  @GetMapping(path = "/greeting", produces = MediaType.APPLICATION_XML_VALUE)
  public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") final String name) {
    return new Greeting(counter.incrementAndGet(),
                        String.format(template, name));
  }

  @PostMapping(path = "/post", produces = MediaType.APPLICATION_XML_VALUE, consumes = MediaType.APPLICATION_XML_VALUE)
  public void post(@RequestBody final Greeting name) {
  }

  @PostMapping(path = "/post2", produces = MediaType.APPLICATION_XML_VALUE, consumes = MediaType.APPLICATION_XML_VALUE)
  public void post2(@RequestBody final Greeting2 name) {
  }
}
