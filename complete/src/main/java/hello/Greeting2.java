package hello;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "greeting-jaxb")
@XmlRootElement(name = "greeting-jaxb")
public class Greeting2 {

  @XmlElement(name = "my-id")
  private final long   id;
  private final String content;

  public Greeting2(final long id, final String content) {
    this.id = id;
    this.content = content;
  }

  public long getId() {
    return id;
  }

  public String getContent() {
    return content;
  }
}
