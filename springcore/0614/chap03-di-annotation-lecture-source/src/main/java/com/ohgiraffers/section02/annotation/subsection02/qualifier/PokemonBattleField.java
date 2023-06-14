package com.ohgiraffers.section02.annotation.subsection02.qualifier;

import com.ohgiraffers.section02.common.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("fieldQualifier")
public class PokemonBattleField {


    @Autowired
    @Qualifier(value = "squirtle")
    private Pokemon pokemon;

    public void fight(){
        pokemon.attack();
    }
}
