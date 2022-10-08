package org.example.demo;

import com.google.common.collect.ImmutableList;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NodeService {

    public List<Node> findAll(){
        return ImmutableList.of(
                new Node("a", 1),
                new Node("b", 2)
        );
    }
}
