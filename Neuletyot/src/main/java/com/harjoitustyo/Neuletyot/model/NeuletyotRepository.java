package com.harjoitustyo.Neuletyot.model;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface NeuletyotRepository  extends CrudRepository<Neuletyot, Long>{

        List<Neuletyot> findByNeuleTitle(String neuleTitle);

}
