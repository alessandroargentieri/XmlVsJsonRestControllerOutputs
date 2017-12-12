package com.quicktutorialz.learnmicroservices.XmlVsJsonData.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import java.util.List;

/**
 * Only through a Wrapper you can get a List of Object transformed in Xml
 * Otherwise it is only possible for single items
 * @param <T>
 */

@XmlRootElement @XmlSeeAlso({Task.class, User.class})
@AllArgsConstructor @NoArgsConstructor
public class ResponseWrapper<T> {
    @Getter @Setter
    private List<T> wrappedObject;
}
